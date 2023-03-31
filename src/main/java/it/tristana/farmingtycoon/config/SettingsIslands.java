package it.tristana.farmingtycoon.config;

import java.io.File;

import org.bukkit.World;

import it.tristana.commons.config.Settings;

public class SettingsIslands extends Settings<ConfigIslands> {

	private World world;
	private int islandsHeight;
	private int islandsDistance;
	
	public SettingsIslands(File folder) {
		super(folder, ConfigIslands.class);
	}
	
	@Override
	protected void reload(ConfigIslands config) {
		
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
}
