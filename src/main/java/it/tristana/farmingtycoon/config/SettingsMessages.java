package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;

public class SettingsMessages extends Settings<ConfigMessages> {

	private static final String[] EMPTY_ARRAY = {};
	
	private String[] units;

	private String waitingProfileLoad;
	private String grassPerfectClearTitle;
	private String grassPerfectClearSubtitle;
	private String grassFailedPerfectClearTitle;
	private String grassFailedPerfectClearSubtitle;
	
	private String playerOffline;
	private String notADouble;

	private String commandGoExecuted;
	private String commandGoHelp;
	private String commandMoneyExecuted;
	private String commandMoneyHelp;
	
	public SettingsMessages(File folder) {
		super(folder, ConfigMessages.class);
	}

	@Override
	protected void reload(ConfigMessages config) {
		units = config.getList(ConfigMessages.UNITS).toArray(EMPTY_ARRAY);

		waitingProfileLoad = config.getString(ConfigMessages.WAITING_PROFILE_LOAD);
		grassPerfectClearTitle = config.getString(ConfigMessages.GRASS_PERFECT_CLEAR_TITLE);
		grassPerfectClearSubtitle = config.getString(ConfigMessages.GRASS_PERFECT_CLEAR_SUBTITLE);
		grassFailedPerfectClearTitle = config.getString(ConfigMessages.GRASS_FAILED_PERFECT_CLEAR_TITLE);
		grassFailedPerfectClearSubtitle = config.getString(ConfigMessages.GRASS_FAILED_PERFECT_CLEAR_SUBTITLE);

		playerOffline = config.getString(ConfigMessages.PLAYER_OFFLINE);
		notADouble = config.getString(ConfigMessages.NOT_A_DOUBLE);
		
		commandGoExecuted = config.getString(ConfigMessages.COMMAND_GO_EXECUTED);
		commandGoHelp = config.getString(ConfigMessages.COMMAND_GO_HELP);
		
		commandMoneyExecuted = config.getString(ConfigMessages.COMMAND_MONEY_EXECUTED);
		commandMoneyHelp = config.getString(ConfigMessages.COMMAND_MONEY_HELP);
	}
	
	public String getCommandMoneyExecuted() {
		return commandMoneyExecuted;
	}

	public String getCommandMoneyHelp() {
		return commandMoneyHelp;
	}

	public String getNotADouble() {
		return notADouble;
	}

	public String getPlayerOffline() {
		return playerOffline;
	}

	public String getGrassFailedPerfectClearTitle() {
		return grassFailedPerfectClearTitle;
	}

	public String getGrassFailedPerfectClearSubtitle() {
		return grassFailedPerfectClearSubtitle;
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
