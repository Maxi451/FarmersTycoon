package it.tristana.farmingtycoon.config;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;

import it.tristana.commons.config.Settings;
import it.tristana.commons.helper.CommonsHelper;

public class SettingsIslands extends Settings<ConfigIslands> {

	private static final int LINES_IN_SIGN = 4;
	
	private World world;
	private int islandsHeight;
	private int islandsDistance;
	private String defaultSchematicName;
	private String[] farmSignLines;

	public SettingsIslands(File folder) {
		super(folder, ConfigIslands.class);
	}

	@Override
	protected void reload(ConfigIslands config) {
		String worldName = config.getString(ConfigIslands.WORLD);
		world = Bukkit.getWorld(worldName);
		if (world == null) {
			throw new IllegalStateException("The world " + worldName + " does not exist or is not loaded!");
		}

		islandsHeight = CommonsHelper.parseIntOrGetDefault(config.getString(ConfigIslands.ISLANDS_HEIGHT), 64);
		islandsDistance = CommonsHelper.parseIntOrGetDefault(config.getString(ConfigIslands.ISLANDS_DISTANCE), 500);
		defaultSchematicName = config.getString(ConfigIslands.DEFAULT_SCHEMATIC_NAME);
		List<String> lines = config.getList(ConfigIslands.FARM_SIGN_LINES);
		farmSignLines = lines.size() == LINES_IN_SIGN ? lines.toArray(new String[0]) : new String[] { "{name}", "{level}", "{mps}", "{total}" };
	}

	public World getWorld() {
		return world;
	}

	public int getIslandsHeight() {
		return islandsHeight;
	}

	public int getIslandsDistance() {
		return islandsDistance;
	}

	public String getDefaultSchematicName() {
		return defaultSchematicName;
	}

	public String[] getFarmSignLines() {
		return farmSignLines;
	}
}
