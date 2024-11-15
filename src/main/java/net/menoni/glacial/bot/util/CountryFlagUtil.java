package net.menoni.glacial.bot.util;

public class CountryFlagUtil {

	private static final String WILDCARD_COUNTRY = "Antarctica";
	private static final String FALLBACK_FLAG = "AQ"; // Antarctica

	public static String getCountryDisplayName(String countryName) {
		if (isWildcardCountry(countryName)) {
			return "Wildcard";
		}
		return countryName;
	}

	public static boolean isWildcardCountry(String countryName) {
		return countryName == null || WILDCARD_COUNTRY.equalsIgnoreCase(countryName);
	}

	public static String tryGetCountryFlag(String countryName) {
		for (CountryDef countryDef : COUNTRY_DEFS) {
			if (countryDef.name().equalsIgnoreCase(countryName)) {
				return factorFlag(countryDef.code());
			}
		}
		return factorFlag(FALLBACK_FLAG);
	}

	private static String factorFlag(String countryCode) {
		int flagOffset = 0x1F1E6;
		int asciiOffset = 0x41;

		int firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset;
		int secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset;

		return new String(Character.toChars(firstChar)) + new String(Character.toChars(secondChar));
	}
	
	private record CountryDef(
			String code,
			String name
	) { }
	
	private static final CountryDef[] COUNTRY_DEFS = new CountryDef[] {
			new CountryDef("AF", "Afghanistan"),
			new CountryDef("AL", "Albania"),
			new CountryDef("DZ", "Algeria"),
			new CountryDef("AS", "American Samoa"),
			new CountryDef("AD", "Andorra"),
			new CountryDef("AO", "Angola"),
			new CountryDef("AI", "Anguilla"),
			new CountryDef("AQ", "Antarctica"),
			new CountryDef("AG", "Antigua and Barbuda"),
			new CountryDef("AR", "Argentina"),
			new CountryDef("AM", "Armenia"),
			new CountryDef("AW", "Aruba"),
			new CountryDef("AU", "Australia"),
			new CountryDef("AT", "Austria"),
			new CountryDef("AZ", "Azerbaijan"),
			new CountryDef("BS", "The Bahamas"),
			new CountryDef("BH", "Bahrain"),
			new CountryDef("BD", "Bangladesh"),
			new CountryDef("BB", "Barbados"),
			new CountryDef("BY", "Belarus"),
			new CountryDef("BE", "Belgium"),
			new CountryDef("BZ", "Belize"),
			new CountryDef("BJ", "Benin"),
			new CountryDef("BM", "Bermuda"),
			new CountryDef("BT", "Bhutan"),
			new CountryDef("BO", "Bolivia"),
			new CountryDef("BA", "Bosnia and Herzegovina"),
			new CountryDef("BW", "Botswana"),
			new CountryDef("BV", "Bouvet Island"),
			new CountryDef("BR", "Brazil"),
			new CountryDef("IO", "British Indian Ocean Territory"),
			new CountryDef("VG", "British Virgin Islands"),
			new CountryDef("BN", "Brunei"),
			new CountryDef("BG", "Bulgaria"),
			new CountryDef("BF", "Burkina Faso"),
			new CountryDef("BI", "Burundi"),
			new CountryDef("CI", "Côte d'Ivoire"),
			new CountryDef("KH", "Cambodia"),
			new CountryDef("CM", "Cameroon"),
			new CountryDef("CA", "Canada"),
			new CountryDef("CV", "Cape Verde"),
			new CountryDef("KY", "Cayman Islands"),
			new CountryDef("CF", "Central African Republic"),
			new CountryDef("TD", "Chad"),
			new CountryDef("CL", "Chile"),
			new CountryDef("CN", "China"),
			new CountryDef("CX", "Christmas Island"),
			new CountryDef("CC", "Cocos (Keeling) Islands"),
			new CountryDef("CO", "Colombia"),
			new CountryDef("KM", "Comoros"),
			new CountryDef("CG", "Congo"),
			new CountryDef("CK", "Cook Islands"),
			new CountryDef("CR", "Costa Rica"),
			new CountryDef("HR", "Croatia"),
			new CountryDef("CU", "Cuba"),
			new CountryDef("CY", "Cyprus"),
			new CountryDef("CZ", "Czech Republic"),
			new CountryDef("CD", "Democratic Republic of the Congo"),
			new CountryDef("DK", "Denmark"),
			new CountryDef("DJ", "Djibouti"),
			new CountryDef("DM", "Dominica"),
			new CountryDef("DO", "Dominican Republic"),
			new CountryDef("EC", "Ecuador"),
			new CountryDef("EG", "Egypt"),
			new CountryDef("SV", "El Salvador"),
			new CountryDef("GQ", "Equatorial Guinea"),
			new CountryDef("ER", "Eritrea"),
			new CountryDef("EE", "Estonia"),
			new CountryDef("ET", "Ethiopia"),
			new CountryDef("FO", "Faeroe Islands"),
			new CountryDef("FK", "Falkland Islands"),
			new CountryDef("FJ", "Fiji"),
			new CountryDef("FI", "Finland"),
			new CountryDef("FR", "France"),
			new CountryDef("FX", "France, Metropolitan"),
			new CountryDef("GF", "French Guiana"),
			new CountryDef("PF", "French Polynesia"),
			new CountryDef("TF", "French Southern Territories"),
			new CountryDef("GA", "Gabon"),
			new CountryDef("GM", "The Gambia"),
			new CountryDef("GE", "Georgia"),
			new CountryDef("DE", "Germany"),
			new CountryDef("GH", "Ghana"),
			new CountryDef("GI", "Gibraltar"),
			new CountryDef("GR", "Greece"),
			new CountryDef("GL", "Greenland"),
			new CountryDef("GD", "Grenada"),
			new CountryDef("GP", "Guadeloupe"),
			new CountryDef("GU", "Guam"),
			new CountryDef("GT", "Guatemala"),
			new CountryDef("GN", "Guinea"),
			new CountryDef("GW", "Guinea-Bissau"),
			new CountryDef("GY", "Guyana"),
			new CountryDef("HT", "Haiti"),
			new CountryDef("HM", "Heard and Mc Donald Islands"),
			new CountryDef("HN", "Honduras"),
			new CountryDef("HK", "Hong Kong"),
			new CountryDef("HU", "Hungary"),
			new CountryDef("IS", "Iceland"),
			new CountryDef("IN", "India"),
			new CountryDef("ID", "Indonesia"),
			new CountryDef("IR", "Iran"),
			new CountryDef("IQ", "Iraq"),
			new CountryDef("IE", "Ireland"),
			new CountryDef("IL", "Israel"),
			new CountryDef("IT", "Italy"),
			new CountryDef("JM", "Jamaica"),
			new CountryDef("JP", "Japan"),
			new CountryDef("JO", "Jordan"),
			new CountryDef("KZ", "Kazakhstan"),
			new CountryDef("KE", "Kenya"),
			new CountryDef("KI", "Kiribati"),
			new CountryDef("XK", "Kosovo"),
			new CountryDef("KW", "Kuwait"),
			new CountryDef("KG", "Kyrgyzstan"),
			new CountryDef("LA", "Laos"),
			new CountryDef("LV", "Latvia"),
			new CountryDef("LB", "Lebanon"),
			new CountryDef("LS", "Lesotho"),
			new CountryDef("LR", "Liberia"),
			new CountryDef("LY", "Libya"),
			new CountryDef("LI", "Liechtenstein"),
			new CountryDef("LT", "Lithuania"),
			new CountryDef("LU", "Luxembourg"),
			new CountryDef("MO", "Macau"),
			new CountryDef("MG", "Madagascar"),
			new CountryDef("MW", "Malawi"),
			new CountryDef("MY", "Malaysia"),
			new CountryDef("MV", "Maldives"),
			new CountryDef("ML", "Mali"),
			new CountryDef("MT", "Malta"),
			new CountryDef("MH", "Marshall Islands"),
			new CountryDef("MQ", "Martinique"),
			new CountryDef("MR", "Mauritania"),
			new CountryDef("MU", "Mauritius"),
			new CountryDef("YT", "Mayotte"),
			new CountryDef("MX", "Mexico"),
			new CountryDef("FM", "Micronesia"),
			new CountryDef("MD", "Moldova"),
			new CountryDef("MC", "Monaco"),
			new CountryDef("MN", "Mongolia"),
			new CountryDef("ME", "Montenegro"),
			new CountryDef("MS", "Montserrat"),
			new CountryDef("MA", "Morocco"),
			new CountryDef("MZ", "Mozambique"),
			new CountryDef("MM", "Myanmar"),
			new CountryDef("NA", "Namibia"),
			new CountryDef("NR", "Nauru"),
			new CountryDef("NP", "Nepal"),
			new CountryDef("NL", "Netherlands"),
			new CountryDef("AN", "Netherlands Antilles"),
			new CountryDef("NC", "New Caledonia"),
			new CountryDef("NZ", "New Zealand"),
			new CountryDef("NI", "Nicaragua"),
			new CountryDef("NE", "Niger"),
			new CountryDef("NG", "Nigeria"),
			new CountryDef("NU", "Niue"),
			new CountryDef("NF", "Norfolk Island"),
			new CountryDef("KP", "North Korea"),
			new CountryDef("MK", "North Macedonia"),
			new CountryDef("MP", "Northern Marianas"),
			new CountryDef("NO", "Norway"),
			new CountryDef("OM", "Oman"),
			new CountryDef("PK", "Pakistan"),
			new CountryDef("PW", "Palau"),
			new CountryDef("PS", "Palestine"),
			new CountryDef("PA", "Panama"),
			new CountryDef("PG", "Papua New Guinea"),
			new CountryDef("PY", "Paraguay"),
			new CountryDef("PE", "Peru"),
			new CountryDef("PH", "Philippines"),
			new CountryDef("PN", "Pitcairn Islands"),
			new CountryDef("PL", "Poland"),
			new CountryDef("PT", "Portugal"),
			new CountryDef("PR", "Puerto Rico"),
			new CountryDef("QA", "Qatar"),
			new CountryDef("RE", "Reunion"),
			new CountryDef("RO", "Romania"),
			new CountryDef("RU", "Russia"),
			new CountryDef("RW", "Rwanda"),
			new CountryDef("ST", "São Tomé and Príncipe"),
			new CountryDef("SH", "Saint Helena"),
			new CountryDef("PM", "St. Pierre and Miquelon"),
			new CountryDef("KN", "Saint Kitts and Nevis"),
			new CountryDef("LC", "Saint Lucia"),
			new CountryDef("VC", "Saint Vincent and the Grenadines"),
			new CountryDef("WS", "Samoa"),
			new CountryDef("SM", "San Marino"),
			new CountryDef("SA", "Saudi Arabia"),
			new CountryDef("SN", "Senegal"),
			new CountryDef("RS", "Serbia"),
			new CountryDef("SC", "Seychelles"),
			new CountryDef("SL", "Sierra Leone"),
			new CountryDef("SG", "Singapore"),
			new CountryDef("SK", "Slovakia"),
			new CountryDef("SI", "Slovenia"),
			new CountryDef("SB", "Solomon Islands"),
			new CountryDef("SO", "Somalia"),
			new CountryDef("ZA", "South Africa"),
			new CountryDef("GS", "South Georgia and the South Sandwich Islands"),
			new CountryDef("KR", "South Korea"),
			new CountryDef("SS", "South Sudan"),
			new CountryDef("ES", "Spain"),
			new CountryDef("LK", "Sri Lanka"),
			new CountryDef("SD", "Sudan"),
			new CountryDef("SR", "Suriname"),
			new CountryDef("SJ", "Svalbard and Jan Mayen Islands"),
			new CountryDef("SZ", "Swaziland"),
			new CountryDef("SE", "Sweden"),
			new CountryDef("CH", "Switzerland"),
			new CountryDef("SY", "Syria"),
			new CountryDef("TW", "Taiwan"),
			new CountryDef("TJ", "Tajikistan"),
			new CountryDef("TZ", "Tanzania"),
			new CountryDef("TH", "Thailand"),
			new CountryDef("TG", "Togo"),
			new CountryDef("TK", "Tokelau"),
			new CountryDef("TL", "Timor-Leste"),
			new CountryDef("TO", "Tonga"),
			new CountryDef("TT", "Trinidad and Tobago"),
			new CountryDef("TN", "Tunisia"),
			new CountryDef("TR", "Turkey"),
			new CountryDef("TM", "Turkmenistan"),
			new CountryDef("TC", "Turks and Caicos Islands"),
			new CountryDef("TV", "Tuvalu"),
			new CountryDef("VI", "US Virgin Islands"),
			new CountryDef("UG", "Uganda"),
			new CountryDef("UA", "Ukraine"),
			new CountryDef("AE", "United Arab Emirates"),
			new CountryDef("GB", "United Kingdom"),
			new CountryDef("US", "United States"),
			new CountryDef("UM", "United States Minor Outlying Islands"),
			new CountryDef("UY", "Uruguay"),
			new CountryDef("UZ", "Uzbekistan"),
			new CountryDef("VU", "Vanuatu"),
			new CountryDef("VA", "Vatican City"),
			new CountryDef("VE", "Venezuela"),
			new CountryDef("VN", "Vietnam"),
			new CountryDef("WF", "Wallis and Futuna Islands"),
			new CountryDef("EH", "Western Sahara"),
			new CountryDef("YE", "Yemen"),
			new CountryDef("ZM", "Zambia"),
			new CountryDef("ZW", "Zimbabwe")
	};

}
