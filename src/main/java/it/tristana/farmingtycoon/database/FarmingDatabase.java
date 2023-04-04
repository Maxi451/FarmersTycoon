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
		executeQueryAsync("SELECT ", resultSet -> {
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
				+ "	player_uuid CHAR(36) PRIMARY KEY,"
				+ "	pos_x INTEGER NOT NULL,"
				+ "	pos_y INTEGER NOT NULL"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableFarms + " ("
				+ " player_uuid CHAR(36),"
				+ "	farm_type INTEGER,"
				+ "	amount INTEGER NOT NULL DEFAULT 0,"
				+ "	level INTEGER NOT NULL DEFAULT 0,"
				+ "	total_income DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0,"
				+ " PRIMARY KEY (player_uuid, farm_type),"
				+ " FOREIGN KEY (player_uuid) REFERENCES " + tablePlayers + "(uuid)"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tablePlayers + "("
				+ "	uuid CHAR(36) PRIMARY KEY,"
				+ "	money DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0"
				+ ");");
	}
// select money, amount, farm_type, level, total_income, pos_x, pos_y from tableplayers left join tablefarms on tableplayers.uuid = tablefarms.player_uuid left join tableislands on tableplayers.uuid = tableislands.player_uuid where uuid = 'bla'
	private void parseUser(FarmingUser user, ResultSet resultSet) throws SQLException {
		double money = resultSet.getDouble("money");
		Island island = parseIsland(user, resultSet);
		Farm[] farms = parseFarms(user, resultSet);
		user.load(money, island, farms);
	}

	private Island parseIsland(FarmingUser user, ResultSet resultSet) throws SQLException {
		int posX = resultSet.getInt("pos_x");
		int posZ = resultSet.getInt("pos_z");
		return new Island(user, posX, 64, posZ);
	}
	
	private Farm[] parseFarms(user, )
}
