package it.tristana.farmingtycoon.farm;

import org.bukkit.Location;
import org.bukkit.World;

import it.tristana.farmingtycoon.database.FarmingUser;

public record Island(FarmingUser user, World world, int posX, int posY, int posZ) {
	
	public Location toLocation() {
		return new Location(world, posX, posY, posZ);
	}
	
	public Location getSpawnpoint() {
		return toLocation().add(13.5, 3, 4.5);
	}
}
