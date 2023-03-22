package it.tristana.farmingtycoon.database;

import java.sql.SQLException;

import org.bukkit.OfflinePlayer;

import it.tristana.commons.database.DatabaseManager;

public class FarmingDatabase extends DatabaseManager<FarmingUser> {

	private String tableIslands;
	private String tableFarms;
	private String tablePlayers;

	public FarmingDatabase(String host, String database, String username, String password, int port, String tableIslands, String tableFarms, String tablePlayers) {
		super(host, database, username, password, port);
		this.tableIslands = tableIslands;
		this.tableFarms = tableFarms;
		this.tablePlayers = tablePlayers;
	}

	@Override
	public FarmingUser getUser(OfflinePlayer player) {

	}

	@Override
	public void saveUser(FarmingUser user) {

	}

	@Override
	public void createTables() throws SQLException {
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableIslands + " ("
				+ "	id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "	pos_x INTEGER NOT NULL,"
				+ "	pos_y INTEGER NOT NULL"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableFarms + " ("
				+ "	id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "	amount INTEGER NOT NULL DEFAULT 0,"
				+ "	level INTEGER NOT NULL DEFAULT 0,"
				+ "	total_income DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tablePlayers + "("
				+ "	uuid CHAR(36) PRIMARY KEY,"
				+ "	money DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0,"
				+ "	island_id INTEGER NOT NULL,"
				+ "	grass_id INTEGER NOT NULL,"
				+ "	wheat_id INTEGER NOT NULL,"
				+ "	potato_id INTEGER NOT NULL,"
				+ "	carrot_id INTEGER NOT NULL,"
				+ "	sugar_cane_id INTEGER NOT NULL,"
				+ "	mushroom_id INTEGER NOT NULL,"
				+ "	cactus_id INTEGER NOT NULL,"
				+ "	sapling_id INTEGER NOT NULL,"
				+ "	water_lily_id INTEGER NOT NULL,"
				+ "	melon_id INTEGER NOT NULL,"
				+ "	pumpkin_id INTEGER NOT NULL,"
				+ "	sweet_berries_id INTEGER NOT NULL,"
				+ "	chorus_id INTEGER NOT NULL,"
				+ "	coral_id INTEGER NOT NULL,"
				+ "	cocoa_id INTEGER NOT NULL,"
				+ "	nether_wart_id INTEGER NOT NULL,"
				+ "	dead_bush_id INTEGER NOT NULL,"
				+ " FOREIGN KEY (island_id) REFERENCES " + tableIslands + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (grass_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (wheat_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (potato_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (carrot_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sugar_cane_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (mushroom_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (cactus_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sapling_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (water_lily_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (melon_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (pumpkin_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sweet_berries_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (chorus_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (coral_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (cocoa_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (nether_wart_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (dead_bush_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE"
				+ ");");
	}
}
