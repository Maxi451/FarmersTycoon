package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class MelonBuilder extends DirectionalFarmBuilder {

	MelonBuilder() {
		super(Material.MELON);
	}

	@Override
	protected Material getCropAt(int row, int column, int height) {
		return (row ^ column) % 2 == 0 ? Material.MELON : Material.ATTACHED_MELON_STEM;
	}

	@Override
	protected Material getTerrainAt(int row, int column) {
		return Material.GRASS_BLOCK;
	}
}
