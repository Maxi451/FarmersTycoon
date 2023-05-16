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

	private static final String COMMAND_GO = COMMAND + "go.";
	public static final String COMMAND_GO_EXECUTED = COMMAND_GO + EXECUTED;
	public static final String COMMAND_GO_HELP = COMMAND_GO + HELP;

	public ConfigMessages(File folder) {
		super(new File(folder, FILE_NAME));
	}

	@Override
	protected void createDefault() {
		set(UNITS, Arrays.asList(
				"",
				"th",
				"mil",
				"bil",
				"tril",
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

		set(COMMAND_GO_EXECUTED, "&aWhoosh!");
		set(COMMAND_GO_HELP, "Teleports back to your island");
	}
}
