package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.ConfigDatabase;

public class ConfigFarmDatabase extends ConfigDatabase {

	public static final String TABLE_ISLANDS = "table-islands";
	public static final String TABLE_FARMS = "table-farms";
	public static final String TABLE_GRASS = "table-grass";
	public static final String TABLE_PLAYERS = "table-players";
	
	public ConfigFarmDatabase(File folder) {
		super(new File(folder, "database.yml"));
	}
	
	@Override
	protected void createDefault() {
		super.createDefault();
		set(TABLE_ISLANDS, "ft_islands");
		set(TABLE_FARMS, "ft_farms");
		set(TABLE_GRASS, "ft_grass");
		set(TABLE_PLAYERS, "ft_players");
	}
}
