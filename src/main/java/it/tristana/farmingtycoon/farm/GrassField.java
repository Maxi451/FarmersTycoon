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

	private static final String[] titlePieces = { "{old}", "{new}" };
	private static final int X_OFFSET = 0;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 0;
	private static final int LENGTH = 5;
	private static final int WIDTH = 4;

	private final FarmingUser user;
	private int grassLeft;
	private int ticks;
	private double currentMultiplier;

	public GrassField(FarmingUser user) {
		this.user = user;
	}
	
	public GrassField() {
		
	}

	@Override
	public void runTick() {
		if (++ ticks >= settingsFarm.getGrassResetTicks()) {
			reset();
		}
	}

	public void onGrassBroken() {
		if (-- grassLeft == 0) {
			String current = format(currentMultiplier);
			currentMultiplier = Math.max(currentMultiplier * settingsFarm.getGrassIncreaseMultiplierPerfect(), settingsFarm.getGrassMaxMultiplier());
			TitleHelper.send(
					user.getOnlinePlayer(),
					settingsMessages.getGrassPerfectClearTitle(),
					CommonsHelper.replaceAll(
							settingsMessages.getGrassPerfectClearTitle(),
							titlePieces,
							new String[] { current, format(currentMultiplier) }
							));
		}
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
				world.getBlockAt(x + posX, posY, z + posZ).setType(Material.GRASS);
			}
		}
		grassLeft = LENGTH * WIDTH;
	}

	private static String format(double val) {
		return String.format("%.2f", val);
	}
}
