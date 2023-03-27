package it.tristana.farmingtycoon.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.OfflinePlayer;

import it.tristana.commons.database.DatabaseManager;
import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.Island;

public class FarmingDatabase extends DatabaseManager<FarmingUser> {

	private Main plugin;
	private String tableIslands;
	private String tableFarms;
	private String tablePlayers;

	public FarmingDatabase(String host, String database, String username, String password, int port, Main plugin, String tableIslands, String tableFarms, String tablePlayers) {
		super(host, database, username, password, port);
		this.plugin = plugin;
		this.tableIslands = tableIslands;
		this.tableFarms = tableFarms;
		this.tablePlayers = tablePlayers;
	}

	@Override
	public FarmingUser getUser(OfflinePlayer player) {
		FarmingUser user = new FarmingUser(player);
		executeQueryAsync("SELECT money, grass_id, wheat_id, potato_id, carrot_id, beetroot_id, sugar_cane_id,"
				+ "	mushroom_id, cactus_id, sapling_id, water_lily_id, melon_id, pumpkin_id, sweet_berries_id,"
				+ "	chorus_id, cocoa_id, nether_wart_id, dead_bush_id, " + tableIslands + ".id AS island_id, pos_x, pos_y FROM " + tableFarms + "LEFT JOIN"
				+ "	" + tableIslands + " ON " + tablePlayers + ".island_id = " + tableIslands + ".id;", resultSet -> {
					if (!resultSet.next()) {
						createIsland(user);
						return;
					}

					parseUser(user, resultSet);
				}, error -> {
					CommonsHelper.consoleInfo("&cError while loading " + player.getName() + " (" + player.getUniqueId() + ")'s data!");
					plugin.writeThrowableOnErrorsFile(error);
				});
		return user;
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
				+ "	beetroot_id INTEGER NOT NULL,"
				+ "	sugar_cane_id INTEGER NOT NULL,"
				+ "	mushroom_id INTEGER NOT NULL,"
				+ "	cactus_id INTEGER NOT NULL,"
				+ "	sapling_id INTEGER NOT NULL,"
				+ "	water_lily_id INTEGER NOT NULL,"
				+ "	melon_id INTEGER NOT NULL,"
				+ "	pumpkin_id INTEGER NOT NULL,"
				+ "	sweet_berries_id INTEGER NOT NULL,"
				+ "	chorus_id INTEGER NOT NULL,"
				+ "	cocoa_id INTEGER NOT NULL,"
				+ "	nether_wart_id INTEGER NOT NULL,"
				+ "	dead_bush_id INTEGER NOT NULL,"
				+ " FOREIGN KEY (island_id) REFERENCES " + tableIslands + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (grass_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (wheat_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (potato_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (carrot_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (beetroot_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sugar_cane_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (mushroom_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (cactus_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sapling_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (water_lily_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (melon_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (pumpkin_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (sweet_berries_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (chorus_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (cocoa_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (nether_wart_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "	FOREIGN KEY (dead_bush_id) REFERENCES " + tableFarms + "(id) ON UPDATE CASCADE ON DELETE CASCADE"
				+ ");");
	}

	private void parseUser(FarmingUser user, ResultSet resultSet) throws SQLException {
		double money = resultSet.getDouble("money");
		Island island = parseIsland(resultSet);
		Farm[] farms = parseFarms(user, resultSet);
		user.load(money, island, farms);
	}

	private Island parseIsland(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("island_id");
		int posX = resultSet.getInt("pos_x");
		int posZ = resultSet.getInt("pos_z");
		return new Island(id, posX, 64, posZ);
	}

	private Farm[] parseFarms(FarmingUser user, ResultSet resultSet) throws SQLException {
		return new Farm[] {
				getFarm(user, FarmType.WHEAT, resultSet.getInt("wheat_id")),
				getFarm(user, FarmType.POTATO, resultSet.getInt("potato_id")),
				getFarm(user, FarmType.CARROT, resultSet.getInt("carrot_id")),
				getFarm(user, FarmType.BEETROOT, resultSet.getInt("beetroot_id")),
				getFarm(user, FarmType.SUGAR_CANE, resultSet.getInt("sugar_cane_id")),
				getFarm(user, FarmType.MUSHROOM, resultSet.getInt("mushroom_id")),
				getFarm(user, FarmType.CACTUS, resultSet.getInt("cactus_id")),
				getFarm(user, FarmType.SAPLING, resultSet.getInt("sapling_id")),
				getFarm(user, FarmType.WATER_LILY, resultSet.getInt("water_lily_id")),
				getFarm(user, FarmType.MELON, resultSet.getInt("melon_id")),
				getFarm(user, FarmType.PUMPKIN, resultSet.getInt("pumpkin_id")),
				getFarm(user, FarmType.SWEET_BERRIES, resultSet.getInt("sweet_berries_id")),
				getFarm(user, FarmType.CHORUS, resultSet.getInt("chorus_id")),
				getFarm(user, FarmType.COCOA, resultSet.getInt("cocoa_id")),
				getFarm(user, FarmType.NETHER_WART, resultSet.getInt("nether_wart_id")),
				getFarm(user, FarmType.DEAD_BUSH, resultSet.getInt("dead_bush_id"))
		};
	}

	private Farm getFarm(FarmingUser user, FarmType type, int id) throws SQLException {
		return executeQuery("SELECT amount, level, total_income FROM " + tableIslands + " WHERE id = " + id + ";", resultSet -> {
			if (!resultSet.next()) {
				throw new SQLException("Farm entry " + id + " for " + user.getPlayer().getUniqueId() + " not found!");
			}

			int amount = resultSet.getInt("amount");
			int level = resultSet.getInt("level");
			double totalIncome = resultSet.getDouble("total_income");
			return new Farm(user, type, amount, level, totalIncome);
		});
	}
}
