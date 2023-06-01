package it.tristana.farmingtycoon.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.farm.Farm;
import it.tristana.farmingtycoon.farm.FarmType;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class UpgradeListener implements Listener {

	private UsersManager<FarmingUser> usersManager;
	private IslandsManager islandsManager;
	
	public UpgradeListener(UsersManager<FarmingUser> usersManager, IslandsManager islandsManager) {
		this.usersManager = usersManager;
		this.islandsManager = islandsManager;
	}
	
	@EventHandler
	public void on(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof ItemFrame itemFrame)) {
			return;
		}
		
		event.setCancelled(true);
		FarmingUser user = usersManager.getUser(event.getPlayer());
		if (!user.isLoaded() || islandsManager.getIsland(itemFrame.getLocation()) != user.getIsland()) {
			return;
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
