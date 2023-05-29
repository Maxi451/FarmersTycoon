package it.tristana.farmingtycoon.config;

import java.io.File;
import java.util.Arrays;

import it.tristana.commons.config.Config;

public class ConfigMessages extends Config {

	public static final String FILE_NAME = "messages.yml";

	public static final String UNITS = "units";

	private static final String COMMAND = "command.";
	private static final String HELP = "help";
	private static final String EXECUTED = "executed";

	public static final String WAITING_PROFILE_LOAD = "waiting-profile-load";
	public static final String GRASS_PERFECT_CLEAR_TITLE = "grass-perfect-clear-title";
	public static final String GRASS_PERFECT_CLEAR_SUBTITLE = "grass-perfect-clear-subtitle";
	public static final String GRASS_FAILED_PERFECT_CLEAR_TITLE = "grass-failed-perfect-clear-title";
	public static final String GRASS_FAILED_PERFECT_CLEAR_SUBTITLE = "grass-failed-perfect-clear-subtitle";
	
	public static final String PLAYER_OFFLINE = "player-offline";
	public static final String NOT_A_DOUBLE = "not-a-double";

	private static final String COMMAND_GO = COMMAND + "go.";
	public static final String COMMAND_GO_EXECUTED = COMMAND_GO + EXECUTED;
	public static final String COMMAND_GO_HELP = COMMAND_GO + HELP;

	private static final String COMMAND_MONEY = COMMAND + "money.";
	public static final String COMMAND_MONEY_EXECUTED = COMMAND_MONEY + EXECUTED;
	public static final String COMMAND_MONEY_HELP = COMMAND_MONEY + HELP;

	public ConfigMessages(File folder) {
		super(new File(folder, FILE_NAME));
	}

	@Override
	protected void createDefault() {
		set(UNITS, Arrays.asList(
				"",
				"Th",
				"Mil",
				"Bil",
				"Tril",
				"Quad",
				"Quint",
				"Sext",
				"Sept",
				"Oct",
				"Non",
				"Dec",
				"Undec",
				"Duodec",
				"Tredec",
				"Quatt",
				"Quind",
				"Sexdec",
				"Sept.dec",
				"Octodec",
				"Nov.dec",
				"Vigint"
				));

		set(WAITING_PROFILE_LOAD, "&cThe profile is loading");
		set(GRASS_PERFECT_CLEAR_TITLE, "&6&lPerfect!");
		set(GRASS_PERFECT_CLEAR_SUBTITLE, "&aMultiplier &6{old}x &a-> &6{new}x");
		set(GRASS_FAILED_PERFECT_CLEAR_TITLE, "&4&lFailed!");
		set(GRASS_FAILED_PERFECT_CLEAR_SUBTITLE, "&cMultiplier &6{old}x &a-> &61.00x");
		
		set(PLAYER_OFFLINE, "&cThat player is offline!");
		set(NOT_A_DOUBLE, "&cThat isn't a valid number!");

		set(COMMAND_GO_EXECUTED, "&aWhoosh!");
		set(COMMAND_GO_HELP, "Teleports back to your island");
		set(COMMAND_MONEY_EXECUTED, "&aMoney sent");
		set(COMMAND_MONEY_HELP, "Gives money to another player");
	}
}
