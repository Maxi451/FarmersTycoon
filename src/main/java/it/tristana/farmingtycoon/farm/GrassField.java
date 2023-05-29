package it.tristana.farmingtycoon.farm;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.interfaces.Tickable;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.config.SettingsMessages;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.helper.TitleHelper;

public class GrassField implements Tickable {

	private static final Main plugin = JavaPlugin.getPlugin(Main.class);
	private static final SettingsFarm settingsFarm = plugin.getSettingsFarm();
	private static final SettingsMessages settingsMessages = plugin.getSettingsMessages();

	private static final String[] perfectTitlePieces = { "{old}", "{new}" };
	private static final String[] failedTitlePieces = { "{old}" };
	private static final int X_OFFSET = 5;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 1;
	private static final int LENGTH = 4;
	private static final int WIDTH = 7;

	private final FarmingUser user;
	private int level;
	private int grassLeft;
	private int ticks;
	private double currentMultiplier;
	private double totalIncome;

	private double cachedIncome;

	public GrassField(FarmingUser user) {
		this(user, 0, 0);
	}

	public GrassField(FarmingUser user, int level, double totalIncome) {
		this.user = user;
		this.level = level;
		this.totalIncome = totalIncome;
		ticks = settingsFarm.getGrassResetTicks();
		currentMultiplier = 1;
	}

	@Override
	public void runTick() {
		if (++ ticks >= settingsFarm.getGrassResetTicks()) {
			reset();
			ticks = 0;
		}
	}

	public void onGrassBroken() {
		user.giveMoney(cachedIncome);
		totalIncome += cachedIncome;
		if (-- grassLeft == 0) {
			String current = format(currentMultiplier);
			currentMultiplier = Math.min(currentMultiplier + settingsFarm.getGrassIncreaseMultiplierPerfect(), settingsFarm.getGrassMaxMultiplier());
			TitleHelper.send(
					user.getOnlinePlayer(),
					settingsMessages.getGrassPerfectClearTitle(),
					CommonsHelper.replaceAll(
							settingsMessages.getGrassPerfectClearSubtitle(),
							perfectTitlePieces,
							new String[] { current, format(currentMultiplier) }
							));
		}
	}

	public void upgrade() {
		level ++;
	}

	public int getLevel() {
		return level;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	private Location getGrassLocation() {
		Island island = user.getIsland();
		return new Location(island.world(), island.posX() + X_OFFSET, island.posY() + Y_OFFSET, island.posZ() + Z_OFFSET);
	}

	private void reset() {
		Location pos = getGrassLocation();
		World world = pos.getWorld();
		int posX = pos.getBlockX();
		int posY = pos.getBlockY();
		int posZ = pos.getBlockZ();
		for (int x = 0; x < LENGTH; x ++) {
			for (int z = 0; z < WIDTH; z ++) {
				world.getBlockAt(posX + x, posY, posZ + z).setType(Material.GRASS);
			}
		}
		int grassAmount = getGrassAmount();
		if (grassLeft > 0 && currentMultiplier > 1) {
			if (grassLeft < grassAmount) {
				TitleHelper.send(
						user.getOnlinePlayer(),
						settingsMessages.getGrassFailedPerfectClearTitle(),
						CommonsHelper.replaceAll(
								settingsMessages.getGrassFailedPerfectClearSubtitle(),
								failedTitlePieces,
								new String[] { format(currentMultiplier) }
								)
						);
			}
			currentMultiplier = 1;
		}
		grassLeft = grassAmount;
		cacheIncome();
	}

	private void cacheIncome() {
		cachedIncome = settingsFarm.getGrassBaseIncome() * currentMultiplier * Math.pow(settingsFarm.getGrassLevelMultiplier(), level);
	}
	
	private static int getGrassAmount() {
		return LENGTH * WIDTH;
	}

	private static String format(double val) {
		return String.format("%.2f", val);
	}
}
