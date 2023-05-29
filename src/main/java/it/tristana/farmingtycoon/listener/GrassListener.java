package it.tristana.farmingtycoon.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.command.FarmCommand;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class GrassListener implements Listener {

	private final UsersManager<FarmingUser> usersManager;
	private final IslandsManager islandsManager;

	public GrassListener(UsersManager<FarmingUser> usersManager, IslandsManager islandsManager) {
		this.usersManager = usersManager;
		this.islandsManager = islandsManager;
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

		if (block.getType() == Material.GRASS) {
			island.user().getGrassField().onGrassBroken();
			return;
		}
		
		if (!event.getPlayer().hasPermission(FarmCommand.ADMIN_PERMS)) {
			event.setCancelled(true);
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
		if (user.tryToPay(farm.getNextBuyPrice())) {
			farm.buy();
			CommonsHelper.broadcast("Bought " + type.name());
			return;
		}

		CommonsHelper.broadcast("No money");
	}
}
