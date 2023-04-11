package it.tristana.farmingtycoon.database;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

import it.tristana.commons.database.BasicUser;
import it.tristana.commons.interfaces.Tickable;
import it.tristana.commons.interfaces.shop.BalanceHolder;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.Island;

public class FarmingUser extends BasicUser implements BalanceHolder, Tickable {

	private volatile double money;
	private volatile Location island;
	private volatile Farm[] farms;

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

	public synchronized void load(double money, Location island, Farm[] farms) {
		if (isLoaded) {
			return;
		}

		this.money = money;
		this.island = island;
		this.farms = farms;
		isLoaded = true;
	}
	
	public Island getIsland() {
		return island;
	}
}
