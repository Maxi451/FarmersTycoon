package it.tristana.farmingtycoon.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import it.tristana.farmingtycoon.database.FarmingUser;

public class CommandGo extends FarmSubCommand {

	public CommandGo(FarmCommand main, String name, String permission) {
		super(main, name, permission);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		if (args.length < 2 || !main.isAdmin(player)) {
			teleportToIslandOf(player, usersManager.getUser(player));
			return;
		}
		
		Player other = Bukkit.getPlayerExact(args[1]);
		if (other != null) {
			teleportToIslandOf(player, usersManager.getUser(other));
			return;
		}
		
		new Thread(() -> {
			OfflinePlayer offline = Bukkit.getOfflinePlayer(args[1]);
			main.getPlugin().get.getUniqueId()
		}).start();
	}
	
	@Override
	protected boolean requiresPlayer() {
		return true;
	}

	@Override
	protected String getHelp() {
		return settingsCommands.getCommandGoHelp();
	}
	
	private void teleportToIslandOf(Player player, FarmingUser user) {
		player.teleport(user.getIsland().toLocation());
	}
}
