package it.tristana.farmingtycoon.command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import it.tristana.commons.helper.CommonsHelper;

public class CommandMoney extends FarmSubCommand {

	public CommandMoney(FarmCommand main, String name, String permission) {
		super(main, name, permission);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		Player target = Bukkit.getPlayerExact(args[1]);
		if (target == null) {
			CommonsHelper.info(sender, settingsMessages.getPlayerOffline());
			return;
		}
		
		double money;
		try {
			money = Double.parseDouble(args[2]);
		} catch (NumberFormatException e) {
			CommonsHelper.info(sender, settingsMessages.getNotADouble());
			return;
		}

		usersManager.getUser(target).giveMoney(money);
		CommonsHelper.info(sender, settingsMessages.getCommandMoneyExecuted());
	}

	@Override
	protected boolean requiresPlayer() {
		return false;
	}

	@Override
	protected int getMinRequiredParameters() {
		return 2;
	}

	@Override
	protected String getAdditionalHelpParameters() {
		return "<player> <money>";
	}

	@Override
	protected String getHelp() {
		return settingsMessages.getCommandMoneyHelp();
	}
}
