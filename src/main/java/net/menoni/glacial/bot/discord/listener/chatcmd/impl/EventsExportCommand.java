package net.menoni.glacial.bot.discord.listener.chatcmd.impl;

import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.utils.FileUpload;
import net.menoni.glacial.bot.discord.listener.ChatCommandListener;
import net.menoni.glacial.bot.discord.listener.chatcmd.ChatCommand;
import net.menoni.glacial.bot.jdbc.model.JdbcTeam;
import net.menoni.glacial.bot.jdbc.model.JdbcTeamSignup;
import net.menoni.glacial.bot.service.TeamService;
import org.springframework.context.ApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Slf4j
public class EventsExportCommand implements ChatCommand {
	@Override
	public Collection<String> names() {
		return List.of("eventsexport");
	}

	@Override
	public Collection<Permission> requiredPermissions() {
		return List.of(Permission.MANAGE_ROLES);
	}

	@Override
	public boolean canExecute(ApplicationContext applicationContext, GuildMessageChannelUnion channel, Member member, Message message, String alias, String[] args) {
		return ChatCommandListener.requireBotCmdChannel(applicationContext, channel);
	}

	@Override
	public void execute(ApplicationContext applicationContext, GuildMessageChannelUnion channel, Member member, Message message, String alias, String[] args) {
		TeamService teamService = applicationContext.getBean(TeamService.class);
		List<JdbcTeam> teams = teamService.getAllTeams();
		List<JdbcTeamSignup> signups = teamService.getAllSignups();

		ByteArrayOutputStream fileBytes = new ByteArrayOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(fileBytes);
		try (CSVWriter w = new CSVWriter(writer)) {
			List<String> errors = new ArrayList<>();
			w.writeNext(new String[] {"Team", "Player1", "Player2", "Player3"});
			teams.forEach(team -> {
				String[] line = new String[4];
				line[0] = team.getName();

				List<JdbcTeamSignup> teamSignups = signups.stream().filter(s -> Objects.equals(s.getTeamId(), team.getId())).toList();
				if (teamSignups.size() != 3) {
					errors.add("Team `%s` has %d members".formatted(team.getName(), teamSignups.size()));
				} else {
					line[1] = teamSignups.get(0).getTrackmaniaUuid();
					line[2] = teamSignups.get(1).getTrackmaniaUuid();
					line[3] = teamSignups.get(2).getTrackmaniaUuid();
					w.writeNext(line);
				}
			});

			writer.flush();

			channel
					.sendMessage("Created trackmania.events teams CSV")
					.addFiles(FileUpload.fromData(fileBytes.toByteArray(), "glacial_nations_teams_%d.csv".formatted(System.currentTimeMillis())))
					.queue();
		} catch (IOException e) {
			log.error("Failed to write trackmania.events CSV", e);
			reply(channel, alias, "Failed to write trackmania.events CSV");
		}
	}

	@Override
	public Collection<String> help() {
		return List.of(
				"!eventsexport -- Creates a teams csv that can be sent to the trackmania.events admin"
		);
	}
}
