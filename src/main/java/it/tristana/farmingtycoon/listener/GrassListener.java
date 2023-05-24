package it.tristana.farmingtycoon.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class GrassListener implements Listener {

	private final UsersManager<FarmingUser> usersManager;
	private final IslandsManager islandsManager;
	private final SettingsFarm settings;

	public GrassListener(UsersManager<FarmingUser> usersManager, IslandsManager islandsManager, SettingsFarm settings) {
		this.usersManager = usersManager;
		this.islandsManager = islandsManager;
		this.settings = settings;
	}

	@EventHandler
	public void on(BlockBreakEvent event) {
		Block block = event.getBlock();
		Location pos = block.getLocation();
		if (pos.getWorld() != islandsManager.getIslandsWorld()) {
			return;
		}

		Island island = islandsManager.getIsland(pos);
		if (island == null) {
			event.setCancelled(true);
			return;
		}

		Player player = event.getPlayer();
		CommonsHelper.broadcast(String.format("&b%s&r broke %s in %s's island", player.getName(), block.getType().name(), island.user().getPlayer().getName()));
		if (block.getType() == Material.GRASS) {

		}
	}

	@EventHandler
	public void on(PlayerInteractEvent event) {
		if (event.getAction() == Action.PHYSICAL) {
			event.setCancelled(true);
			return;
		}

		Block block = event.getClickedBlock();
		if (block == null || block.getType() != Material.OAK_WALL_SIGN) {
			return;
		}

		Location pos = block.getLocation();
		Island island = islandsManager.getIsland(pos);
		if (island == null) {
			return;
		}

		FarmingUser user = usersManager.getUser(event.getPlayer());
		if (island.user() != user) {
			return;
		}

		FarmType type = FarmType.fromSign(island, pos);
		if (type == null) {
			return;
		}

		Farm farm = user.fromFarmType(type);
		if (user.tryToPay(farm.getNextUpgradePrice())) {
			farm.upgrade();
			CommonsHelper.broadcast("Bought " + type.name());
			return;
		}

		CommonsHelper.broadcast("No money");
	}

	@EventHandler
	public void on(BlockFadeEvent event) {
		event.setCancelled(true);
	}
}
