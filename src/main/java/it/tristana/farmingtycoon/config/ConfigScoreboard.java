package it.tristana.farmingtycoon.config;

import java.io.File;
import java.util.Arrays;

import it.tristana.commons.config.Config;

public class ConfigScoreboard extends Config {

	public static final String SCOREBOARD_NAME = "scoreboard-name";
	public static final String SCOREBOARD_LINES = "scoreboard-lines";
	
	public ConfigScoreboard(File folder) {
		super(new File(folder, "scoreboard.yml"));
	}

	@Override
	protected void createDefault() {
		set(SCOREBOARD_NAME, "&6&lFarmers Tycoon");
		set(SCOREBOARD_LINES, Arrays.asList(
				"Player: %ft_player%",
				"Balance: %ft_money%"
				));
	}
}
