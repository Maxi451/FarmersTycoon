package it.tristana.farmingtycoon.farm;

import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.interfaces.Tickable;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.database.FarmingUser;

public class GrassField implements Tickable {

	private static final SettingsFarm settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();
	
	private FarmingUser user;
	private int ticks;
	
	public GrassField(FarmingUser user) {
		this.user = user;
	}
	
	@Override
	public void runTick() {
		
	}
}
