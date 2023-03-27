package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class PumpkinBuilder extends DirectionalFarmBuilder {

	PumpkinBuilder() {
		super(Material.PUMPKIN);
	}

	@Override
	protected Material getCropAt(int row, int column, int height) {
		return (row ^ column) % 2 == 0 ? Material.PUMPKIN : Material.ATTACHED_PUMPKIN_STEM;
	}

	@Override
	protected Material getTerrainAt(int row, int column) {
		return Material.GRASS_BLOCK;
	}
}
