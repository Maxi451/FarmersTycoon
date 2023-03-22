package it.tristana.farmingtycoon.database;

import org.bukkit.OfflinePlayer;

import it.tristana.commons.database.BasicUser;
import it.tristana.commons.interfaces.shop.BalanceHolder;

public class FarmingUser extends BasicUser implements BalanceHolder {

	private double money;

	public FarmingUser(OfflinePlayer player) {
		super(player);
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
}
