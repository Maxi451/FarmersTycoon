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
import it.tristana.farmingtycoon.farm.GrassField;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class FarmingDatabase extends DatabaseManager<FarmingUser> {

	private static final Farm[] EMPTY_FARMS_ARRAY = {};

	private final Main plugin;
	private final String tableIslands;
	private final String tableFarms;
	private final String tableGrass;
	private final String tablePlayers;

	public FarmingDatabase(String host, String database, String username, String password, int port, Main plugin, String tableIslands, String tableFarms, String tableGrass, String tablePlayers) {
		super(host, database, username, password, port);
		this.plugin = plugin;
		this.tableIslands = tableIslands;
		this.tableFarms = tableFarms;
		this.tableGrass = tableGrass;
		this.tablePlayers = tablePlayers;
	}

	@Override
	public FarmingUser getUser(OfflinePlayer player) {
		return getUser(player, true);
	}

	public FarmingUser getUser(OfflinePlayer player, boolean createIfMissing) {
		FarmingUser[] user = new FarmingUser[] { new FarmingUser(player) }; // Ugly hack to pass by reference
		String uuid = getUuid(player);

		executeQueryAsync(String.format("SELECT players.money as player_money, grass.level as grass_level, grass.total_income as grass_total_income, farms.amount as farm_amount,"
				+ " farms.farm_type as farm_type, farms.level as farm_level, farms.total_income as farm_total_income, islands.pos_x as island_pos_x, islands.pos_y as island_pos_y,"
				+ " islands.pos_z as island_pos_z from %s players left join %s grass on players.uuid = grass.player_uuid left join %s farms on players.uuid = farms.player_uuid"
				+ " left join %s islands on players.uuid = islands.player_uuid where uuid = '%s'", tablePlayers, tableGrass, tableFarms, tableIslands, uuid), resultSet -> {

					CommonsHelper.broadcast("&aQuery executed");
					if (!resultSet.isBeforeFirst()) {
						CommonsHelper.broadcast("&aNot Before First");
						if (createIfMissing) {
							CommonsHelper.broadcast("&aCreating new");
							createUser(user[0]);
						} else {
							user[0] = null;
						}
						return;
					}

					CommonsHelper.broadcast("&aParsing existing");
					parseUser(user[0], resultSet);
				}, error -> {
					CommonsHelper.consoleInfo("&cError while loading " + player.getName() + " (" + uuid + ")'s data!");
					plugin.writeThrowableOnErrorsFile(error);
				});
		return user[0];
	}

	@Override
	public void saveUser(FarmingUser user) {
		OfflinePlayer player = user.getPlayer();
		String uuid = getUuid(player);
		new Thread(() -> {
			try {
				double money = user.getMoney();
				GrassField grassField = user.getGrassField();
				int grassLevel = grassField.getLevel();
				double grassIncome = grassField.getTotalIncome();

				executeUpdate(String.format("INSERT INTO %s (uuid, money) VALUES ('%s', %.3f)"
						+ " ON DUPLICATE KEY UPDATE money = %.3f;",
						tablePlayers, uuid, money, money));

				executeUpdate(String.format("INSERT INTO %s (player_uuid, level, total_income) VALUES ('%s', %d, %.3f)"
						+ " ON DUPLICATE KEY UPDATE level = %d, total_income = %.3f;",
						tableGrass, uuid, grassLevel, grassIncome, grassLevel, grassIncome));

				for (Farm farm : user.getFarms()) {
					int amount = farm.getAmount();
					int level = farm.getLevel();
					double totalIncome = farm.getTotalIncome();
					int typeId = farm.getFarmType().ordinal();
					executeUpdate(String.format("INSERT INTO %s (player_uuid, farm_type, amount, level, total_income) VALUES ('%s', %d, %d, %d, %.3f)"
							+ "ON DUPLICATE KEY UPDATE farm_type = %d, amount = %d, level = %d, total_income = %.3f;",
							tableFarms, uuid, typeId, amount, level, totalIncome, typeId, amount, level, totalIncome));
				}

				Island island = user.getIsland();
				executeUpdate(String.format("INSERT INTO %s (player_uuid, pos_x, pos_y, pos_z) VALUES ('%s', %d, %d, %d)"
						+ "ON DUPLICATE KEY UPDATE pos_x = %d, pos_y = %d, pos_z = %d;",
						tableIslands, uuid, island.posX(), island.posY(), island.posZ(), island.posX(), island.posY(), island.posZ()));
			} catch (SQLException e) {
				CommonsHelper.consoleInfo("&cError while saving " + player.getName() + " (" + uuid + ")'s data!");
				plugin.writeThrowableOnErrorsFile(e);
			}
		}).start();
	}

	@Override
	public void createTables() throws SQLException {
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tablePlayers + "("
				+ "	uuid CHAR(36) PRIMARY KEY,"
				+ "	money DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableGrass + "("
				+ " player_uuid CHAR(36) PRIMARY KEY,"
				+ " level INTEGER NOT NULL DEFAULT 0,"
				+ " total_income DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0,"
				+ " FOREIGN KEY (player_uuid) REFERENCES " + tablePlayers + "(uuid)"
				+ " ON UPDATE CASCADE ON DELETE CASCADE"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableFarms + " ("
				+ " player_uuid CHAR(36),"
				+ "	farm_type INTEGER NOT NULL,"
				+ "	amount INTEGER NOT NULL DEFAULT 0,"
				+ "	level INTEGER NOT NULL DEFAULT 0,"
				+ "	total_income DECIMAL(53, 3) UNSIGNED NOT NULL DEFAULT 0,"
				+ " PRIMARY KEY (player_uuid, farm_type),"
				+ " FOREIGN KEY (player_uuid) REFERENCES " + tablePlayers + "(uuid)"
				+ " ON UPDATE CASCADE ON DELETE CASCADE"
				+ ");");
		executeUpdate("CREATE TABLE IF NOT EXISTS " + tableIslands + " ("
				+ "	player_uuid CHAR(36) PRIMARY KEY,"
				+ "	pos_x INTEGER NOT NULL,"
				+ " pos_y INTEGER NOT NULL,"
				+ "	pos_z INTEGER NOT NULL,"
				+ " FOREIGN KEY (player_uuid) REFERENCES " + tablePlayers + "(uuid)"
				+ " ON UPDATE CASCADE ON DELETE CASCADE"
				+ ");");
	}

	private void createUser(FarmingUser user) {
		IslandsManager islandsManager = plugin.getIslandsBroker();
		Location pos = islandsManager.generate(user);
		Island island = new Island(user, islandsManager.getIslandsWorld(), pos.getBlockX(), islandsManager.getIslandsHeight(), pos.getBlockZ());
		user.load(0, island, FarmType.asList().stream().map(type -> new Farm(user, type)).collect(Collectors.toList()).toArray(EMPTY_FARMS_ARRAY), new GrassField(user));
	}

	private void parseUser(FarmingUser user, ResultSet resultSet) throws SQLException {
		Farm[] farms = parseFarms(user, resultSet);
		Island island = parseIsland(user, resultSet);
		GrassField grassField = parseGrassField(user, resultSet);
		double money = resultSet.getDouble("money");
		user.load(money, island, farms, grassField);
	}

	private Island parseIsland(FarmingUser user, ResultSet resultSet) throws SQLException {
		int posX = resultSet.getInt("island_pos_x");
		int posY = resultSet.getInt("island_pos_y");
		int posZ = resultSet.getInt("island_pos_z");
		return new Island(user, plugin.getIslandsBroker().getIslandsWorld(), posX, posY, posZ);
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

		return new Farm(user, type, resultSet.getInt("farm_amount"), resultSet.getInt("farm_level"), resultSet.getDouble("farm_total_income"));
	}

	private GrassField parseGrassField(FarmingUser user, ResultSet resultSet) throws SQLException {
		int level = resultSet.getInt("grass_level");
		double totalIncome = resultSet.getDouble("grass_total_income");
		return new GrassField(user, level, totalIncome);
	}
}
