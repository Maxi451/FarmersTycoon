package it.tristana.farmingtycoon.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.database.FarmingUser;

public class CommandGo extends FarmSubCommand {

	private final Main plugin;

	public CommandGo(FarmCommand main, String name, String permission) {
		super(main, name, permission);
		this.plugin = main.getPlugin();
	}

	@Override
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
			@SuppressWarnings("deprecation")
			OfflinePlayer offline = Bukkit.getOfflinePlayer(args[1]);
			FarmingUser user = plugin.getStorage().getUser(offline, false);
			if (user == null) {
				CommonsHelper.info(sender, settingsMessages.getNotExistingPlayer());
				return;
			}

			Bukkit.getScheduler().runTask(plugin, () -> teleportToIslandOf(player, user));
		}).start();
	}

	@Override
	protected boolean requiresPlayer() {
		return true;
	}

	@Override
	protected String getHelp() {
		return settingsMessages.getCommandGoHelp();
	}

	private void teleportToIslandOf(Player player, FarmingUser user) {
		if (!user.isLoaded()) {
			CommonsHelper.info(player, settingsMessages.getCreatingIsland());
			return;
		}

		player.teleport(user.getIsland().getSpawnpoint());
	}
}
