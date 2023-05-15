package it.tristana.farmingtycoon.farm;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Farmland;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;

sealed class FarmBuilder permits CactusBuilder, DirectionalFarmBuilder, MushroomBuilder, SugarCaneBuilder {

	private static final Main plugin = JavaPlugin.getPlugin(Main.class);

	private static final String[] farmSignKeywords = new String[] {
			"{name}",
			"{level}",
			"{mps}",
			"{total}"	
	};

	private static final int X_OFFSET = 10;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 9;

	private static final int WIDTH = 5;
	private static final int LENGTH = 150;

	private static final BlockFace SIGN_ROTATION = BlockFace.NORTH;

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

	final void build(Island island, int row) {
		World world = island.world();
		int x = getFarmfieldX(island);
		int y = getFarmfieldY(island);
		int z = getFarmfieldZ(island) + row;
		if (row == 0) {
			updateSign(island);
			placeTerrain(world, x, y, z, WIDTH, LENGTH);
		}
		build(world, x, y + 1, z, row, WIDTH);
	}

	final void updateSign(Island island) {
		updateSign(island, 0, 0);
	}

	final void updateSign(Island island, double incomePerSecond, double totalMoney) {
		Block block = getSignLocation(island).getBlock();
		if (block.getType() != Material.OAK_WALL_SIGN) {
			block.setType(Material.OAK_WALL_SIGN, false);
		}

		WallSign data = (WallSign) block.getBlockData();
		data.setFacing(SIGN_ROTATION);
		block.setBlockData(data, false);
		Sign sign = (Sign) block.getState();
		String[] lines = plugin.getSettingsIslands().getFarmSignLines();
		String[] replacements = new String[] {  };
		for (int i = 0; i < lines.length; i ++) {
			lines[i] = CommonsHelper.replaceAll(lines[i], farmSignKeywords, replacements);
		}
	}

	final Location getSignLocation(Island island) {
		return new Location(island.world(), getFarmfieldX(island) - 2, getFarmfieldY(island) + 1, getFarmfieldZ(island) - 2);
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

	private final int getFarmfieldX(Island island) {
		return island.posX() + X_OFFSET + WIDTH * idx;
	}

	private final int getFarmfieldY(Island island) {
		return island.posY() + Y_OFFSET;
	}

	private final int getFarmfieldZ(Island island) {
		return island.posZ() + Z_OFFSET;
	}
}
