package it.tristana.farmingtycoon.config;

import java.io.File;

import org.bukkit.Bukkit;

import it.tristana.commons.config.Config;

public class ConfigIslands extends Config {

	public static final String WORLD = "world";
	public static final String ISLANDS_HEIGHT = "islands-height";
	public static final String ISLANDS_DISTANCE = "islands-distance";
	public static final String DEFAULT_SCHEMATIC_NAME = "default-schematic-name";

	public ConfigIslands(File folder) {
		super(new File(folder, "islands.yml"));
	}

	@Override
	protected void createDefault() {
		set(WORLD, Bukkit.getWorlds().get(0).getName());
		set(ISLANDS_HEIGHT, "64");
		set(ISLANDS_DISTANCE, "500");
		set(DEFAULT_SCHEMATIC_NAME, "default_farm.schematic");
	}
}
