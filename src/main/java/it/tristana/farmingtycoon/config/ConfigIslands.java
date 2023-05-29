package it.tristana.farmingtycoon.config;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;

import it.tristana.commons.config.Config;
import it.tristana.farmingtycoon.Main;

public class ConfigIslands extends Config {

	public static final String WORLD = "world";
	public static final String ISLANDS_HEIGHT = "islands-height";
	public static final String ISLANDS_DISTANCE = "islands-distance";
	public static final String DEFAULT_SCHEMATIC_NAME = "default-schematic-name";
	public static final String FARM_SIGN_LINES = "farm-sign-lines";

	public ConfigIslands(File folder) {
		super(new File(folder, "islands.yml"));
	}

	@Override
	protected void createDefault() {
		set(WORLD, Bukkit.getWorlds().get(0).getName());
		set(ISLANDS_HEIGHT, "64");
		set(ISLANDS_DISTANCE, "500");
		set(DEFAULT_SCHEMATIC_NAME, Main.DEFAULT_SCHEMATIC_FILE);
		set(FARM_SIGN_LINES, Arrays.asList(
				"&6{name}",
				"&bPrice {price_affordable_color}{price}",
				"&bLevel &6{level}",
				"&bIncome &6{mps} / s"
		));
	}
}
