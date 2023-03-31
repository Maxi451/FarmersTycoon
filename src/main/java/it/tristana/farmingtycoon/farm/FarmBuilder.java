package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Farmland;

sealed class FarmBuilder permits CactusBuilder, DirectionalFarmBuilder, MushroomBuilder, SugarCaneBuilder {

	private static final int X_OFFSET = 10;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 9;

	private static final int WIDTH = 5;
	private static final int LENGTH = 150;

	protected Material terrain;
	protected Material crop;
	private int idx;

	FarmBuilder() {
		this(Material.STONE, Material.STONE);
	}

	FarmBuilder(Material terrain, Material crop) {
		this.terrain = terrain;
		this.crop = crop;
	}

	final void build(World world, Island island, int row) {
		int x = island.posX() + X_OFFSET + WIDTH * idx;
		int y = island.posY() + Y_OFFSET;
		int z = island.posZ() + Z_OFFSET + row;
		if (row == 0) {
			placeTerrain(world, x, y, z, WIDTH, LENGTH);
		}
		build(world, x, y + 1, z, row, WIDTH);
	}

	final void setIndex(int idx) {
		this.idx = idx;
	}

	final void placeTerrain(World world, int x, int y, int z, int width, int length) {
		for (int i = x; i < x + width; i ++) {
			for (int ii = z; ii < z + length; ii ++) {
				Block block = world.getBlockAt(i, y, ii);
				block.setType(getTerrainAt(ii - z, i - x));
				BlockData blockData = block.getBlockData();
				if (blockData instanceof Farmland farmland) {
					farmland.setMoisture(farmland.getMaximumMoisture());
					setData(block, farmland);
				}
			}
		}
	}

	final void build(World world, int x, int y, int z, int row, int width) {
		int height = getCropHeight();
		for (int i = x; i < x + width; x ++) {
			for (int iii = y; iii < y + height; iii ++) {
				Block block = world.getBlockAt(i, iii, z);
				block.setType(getCropAt(row, i - x, iii - y), false);
				checkAge(block);
			}
		}

		for (int i = x; i < x + width; x ++) {
			for (int iii = y; iii < y + height; iii ++) {
				checkDirection(world.getBlockAt(i, iii, z));
			}
		}
	}

	final void checkDirection(Block block) {
		BlockData data = block.getBlockData();
		if (data instanceof Directional directional) {
			updateDirection(block, directional);
			setData(block, directional);
		}
	}

	final void checkAge(Block block) {
		BlockData data = block.getBlockData();
		if (data instanceof Ageable ageable) {
			ageable.setAge(ageable.getMaximumAge());
			setData(block, ageable);
		}
	}

	final void setData(Block block, BlockData data) {
		BlockState state = block.getState();
		state.setBlockData(data);
		state.update(true, false);
	}

	Material getTerrainAt(int row, int column) {
		return terrain;
	}

	Material getCropAt(int row, int column, int height) {
		return crop;
	}

	int getCropHeight() {
		return 1;
	}

	void updateDirection(Block block, Directional directional) {}
}
