package it.tristana.farmingtycoon.farm;

import org.bukkit.World;

import it.tristana.farmingtycoon.database.FarmingUser;

public record Island(FarmingUser user, World world, int posX, int posY, int posZ) {}