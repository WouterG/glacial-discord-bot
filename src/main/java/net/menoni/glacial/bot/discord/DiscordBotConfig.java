package net.menoni.glacial.bot.discord;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "discord")
@Getter
@Setter
public class DiscordBotConfig {

    private String token;
    private String guildId;
    private String adminChannelId;
    private Boolean forceUpdateCommands = false;
    private String customBotStatus;
    private String limitInteractionsToMember;
    private String memberRoleId;
    private String playerRoleId;
    private String teamLeadRoleId;
    private String teamsChannelId;
    private String resultsChannelId;
    private String matchesCategoryId;
    private String matchesSecondaryCategoryId;
    private String adminRoleId;
    private String staffRoleId;
    private String casterRoleId;
    private String cmdChannelId;

    public String getMatchesCategoryId(boolean primary) {
        return primary ? matchesCategoryId : matchesSecondaryCategoryId;
    }

}
