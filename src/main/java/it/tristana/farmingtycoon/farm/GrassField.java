package it.tristana.farmingtycoon.farm;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.interfaces.Tickable;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.helper.TitleHelper;

public class GrassField implements Tickable {

	private static final SettingsFarm settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();

	private static final int X_OFFSET = 0;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 0;
	private static final int LENGTH = 5;
	private static final int WIDTH = 4;
	
	private FarmingUser user;
	private int grassLeft;
	private int ticks;
	private double currentMultiplier;
	
	public GrassField(FarmingUser user) {
		this.user = user;
	}
	
	@Override
	public void runTick() {
		if (++ ticks >= settings.getGrassResetTicks()) {
			reset();
		}
	}
	
	public void onGrassBroken() {
		if (-- grassLeft == 0) {
			currentMultiplier = Math.max(currentMultiplier * settings.getGrassIncreaseMultiplierPerfect(), settings.getGrassMaxMultiplier());
			TitleHelper.send(user.getOnlinePlayer(), , null)
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
}
