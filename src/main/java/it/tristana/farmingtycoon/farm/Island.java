package it.tristana.farmingtycoon.farm;

import it.tristana.farmingtycoon.database.FarmingUser;

public record Island(FarmingUser user, int posX, int posY, int posZ) {}
