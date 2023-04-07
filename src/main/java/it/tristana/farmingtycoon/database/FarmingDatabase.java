package it.tristana.farmingtycoon.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

import it.tristana.commons.database.DatabaseManager;
import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class FarmingDatabase extends DatabaseManager<FarmingUser> {

	private final Main plugin;
	private final IslandsManager islandsBroker;
	private final String tableIslands;
	private final String tableFarms;
	private final String tablePlayers;

	public FarmingDatabase(String host, String database, String username, String password, int port, Main plugin, String tableIslands, String tableFarms, String tablePlayers) {
		super(host, database, username, password, port);
		this.plugin = plugin;
		this.islandsBroker = plugin.getIslandsBroker();
		this.tableIslands = tableIslands;
		this.tableFarms = tableFarms;
		this.tablePlayers = tablePlayers;
	}

	@Override
	public FarmingUser getUser(OfflinePlayer player) {
		FarmingUser user = new FarmingUser(player);
		executeQueryAsync(String.format("SELECT money, amount, farm_type, level, total_income, pos_x, pos_y"
				+ " from %s left join %s on %s.uuid = %s.player_uuid left join %s on %s.uuid = %s.player_uuid"
				+ " where uuid = '%s'", tablePlayers, tableFarms, tableIslands, tablePlayers, tableIslands, getUuid(user.getPlayer())), resultSet -> {
					if (!resultSet.isBeforeFirst()) {
						createUser(user);
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
				+ " pos_y INTEGER NOT NULL,"
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
	
	private void createUser(FarmingUser user) {
		Location pos = islandsBroker.generate(user);
		Island island = new Island(user, pos.getBlockX(), islandsBroker.getIslandsHeight(), pos.getBlockZ());
		user.load(0, island, FarmType.asList().stream().map(type -> new Farm(user, type)).collect(Collectors.toList()).toArray(new Farm[0]));
	}

	private void parseUser(FarmingUser user, ResultSet resultSet) throws SQLException {
		Farm[] farms = parseFarms(user, resultSet);
		Island island = parseIsland(user, resultSet);
		double money = resultSet.getDouble("money");
		user.load(money, island, farms);
	}

	private Island parseIsland(FarmingUser user, ResultSet resultSet) throws SQLException {
		int posX = resultSet.getInt("pos_x");
		int posY = resultSet.getInt("pos_y");
		int posZ = resultSet.getInt("pos_z");
		return new Island(user, posX, posY, posZ);
	}

	private Farm[] parseFarms(FarmingUser user, ResultSet resultSet) throws SQLException {
		Farm[] farms = new Farm[FarmType.length()];
		for (int i = 0; i < farms.length; i ++) {
			if (!resultSet.next()) {
				throw new SQLException("Wrong farm count! Expected " + farms.length + " but got " + i + " for " + getUuid(user.getPlayer()));
			}

			farms[i] = parseFarm(user, resultSet);
		}
		return farms;
	}

	private Farm parseFarm(FarmingUser user, ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("farm_type");
		FarmType type = FarmType.get(id);
		if (type == null) {
			throw new SQLException("Unknown FarmType ordinal " + id + " for " + getUuid(user.getPlayer()));
		}

		return new Farm(user, type, resultSet.getInt("amount"), resultSet.getInt("level"), resultSet.getDouble("total_income"));
	}
}
