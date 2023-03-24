package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class CactusBuilder extends FarmBuilder {

	@Override
	Material getCropAt(int row, int column, int height) {
		return (row ^ column) % 2 == 0 ? Material.CACTUS : Material.AIR;
	}

	@Override
	Material getTerrainAt(int row, int column) {
		return Material.SAND;
	}
}
