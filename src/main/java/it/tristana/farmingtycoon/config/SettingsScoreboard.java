package it.tristana.farmingtycoon.config;

import java.io.File;
import java.util.List;

import it.tristana.commons.config.Settings;

public class SettingsScoreboard extends Settings<ConfigScoreboard> {

	private String scoreboardName;
	private List<String> scoreboardLines;
	
	public SettingsScoreboard(File folder) {
		super(folder, ConfigScoreboard.class);
	}

	@Override
	protected void reload(ConfigScoreboard config) {
		scoreboardName = config.getString(ConfigScoreboard.SCOREBOARD_NAME);
		scoreboardLines = config.getList(ConfigScoreboard.SCOREBOARD_LINES);
	}

	public String getScoreboardName() {
		return scoreboardName;
	}

	public List<String> getScoreboardLines() {
		return scoreboardLines;
	}
}
