package it.tristana.farmingtycoon.database;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.database.BasicUser;
import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.interfaces.Tickable;
import it.tristana.commons.interfaces.shop.BalanceHolder;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.GrassField;
import it.tristana.farmingtycoon.farm.Island;

public class FarmingUser extends BasicUser implements BalanceHolder, Tickable {

	private static final Main plugin = JavaPlugin.getPlugin(Main.class);
	
	private volatile double money;
	private volatile Island island;
	private volatile Farm[] farms;
	private volatile GrassField grassField;

	private volatile boolean isLoaded;

	public FarmingUser(OfflinePlayer player) {
		super(player);
	}

	@Override
	public void runTick() {
		if (!isLoaded) {
			return;
		}

		for (Farm farm : farms) {
			farm.runTick();
		}
		grassField.runTick();
	}

	@Override
	public void giveMoney(double money) {
		this.money += money;
	}

	@Override
	public double getMoney() {
		return money;
	}

	@Override
	public boolean tryToPay(double money) {
		boolean flag = this.money > money;
		if (flag) {
			this.money -= money;
		}
		return flag;
	}

	public synchronized void load(double money, Island island, Farm[] farms, GrassField grassField) {
		if (isLoaded) {
			return;
		}

		this.money = money;
		this.island = island;
		this.farms = farms;
		this.grassField = grassField;
		isLoaded = true;
		Bukkit.getScheduler().runTask(plugin, () -> {
			FarmType.asList().forEach(type -> type.update(island));
		});
		
		CommonsHelper.broadcast("&aIsland created for " + player.getName());
	}
	
	public Island getIsland() {
		return island;
	}
	
	public Farm fromFarmType(FarmType type) {
		return farms[type.ordinal()];
	}
	
	public GrassField getGrassField() {
		return grassField;
	}
	
	Farm[] getFarms() {
		return farms;
	}
}
