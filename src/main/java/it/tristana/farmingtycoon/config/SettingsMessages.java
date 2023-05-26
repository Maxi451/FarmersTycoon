package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;

public class SettingsMessages extends Settings<ConfigMessages> {

	private String[] units;

	private String waitingProfileLoad;
	private String grassPerfectClearTitle;
	private String grassPerfectClearSubtitle;

	private String commandGoExecuted;
	private String commandGoHelp;
	
	public SettingsMessages(File folder) {
		super(folder, ConfigMessages.class);
	}

	@Override
	protected void reload(ConfigMessages config) {
		units = config.getList(ConfigMessages.UNITS).toArray(new String[0]);

		waitingProfileLoad = config.getString(ConfigMessages.WAITING_PROFILE_LOAD);
		grassPerfectClearTitle = config.getString(ConfigMessages.GRASS_PERFECT_CLEAR_TITLE);
		grassPerfectClearSubtitle = config.getString(ConfigMessages.GRASS_PERFECT_CLEAR_SUBTITLE);

		commandGoExecuted = config.getString(ConfigMessages.COMMAND_GO_EXECUTED);
		commandGoHelp = config.getString(ConfigMessages.COMMAND_GO_HELP);
	}
	
	public String getGrassPerfectClearTitle() {
		return grassPerfectClearTitle;
	}

	public String getGrassPerfectClearSubtitle() {
		return grassPerfectClearSubtitle;
	}

	public String[] getUnits() {
		return units;
	}

	public String getWaitingProfileLoad() {
		return waitingProfileLoad;
	}

	public String getCommandGoExecuted() {
		return commandGoExecuted;
	}

	public String getCommandGoHelp() {
		return commandGoHelp;
	}
}
