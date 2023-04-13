package it.tristana.farmingtycoon.farm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EditSessionBuilder;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.ConfigIslandCounter;
import it.tristana.farmingtycoon.config.SettingsIslands;
import it.tristana.farmingtycoon.database.FarmingUser;

public class IslandsManager {

	private final Main plugin;
	private final SettingsIslands settings;
	private final ConfigIslandCounter configIslandCounter;
	private IslandPos previous;

	public IslandsManager(Main plugin, SettingsIslands settings, ConfigIslandCounter configIslandCounter) {
		this.plugin = plugin;
		this.settings = settings;
		this.configIslandCounter = configIslandCounter;
		// No sanity control is performed over this: the program
		// must fail if this is wrong, changed by the administrator
		this.previous = new IslandPos(Integer.parseInt(configIslandCounter.getString(ConfigIslandCounter.X)), Integer.parseInt(configIslandCounter.getString(ConfigIslandCounter.Z)));
	}

	public Location generate(FarmingUser user) {
		Location pos = nextIsland();
		File file = plugin.getSchematic(settings.getDefaultSchematicName());
		if (!file.exists()) {
			throw new RuntimeException("Could not find the schematic file " + file.getAbsolutePath());
		}

		ClipboardFormat format = ClipboardFormats.findByFile(file);
		try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
			Clipboard clipboard = reader.read();
			EditSessionBuilder builder = WorldEdit.getInstance().newEditSessionBuilder().world(null);
			try (EditSession editSession = builder.build()) {
				Operation operation = new ClipboardHolder(clipboard)
						.createPaste(editSession)
						.to(BlockVector3.at(pos.getBlockX(), pos.getBlockY(), pos.getBlockZ()))
						.ignoreAirBlocks(true)
						.build();
				Operations.complete(operation);
			}
		} catch (Exception e) {
			CommonsHelper.consoleInfo("&cCouldn't paste the worldedit schematic!");
			plugin.writeThrowableOnErrorsFile(e);
		}

		return pos;
	}

	public Location fromIslandPos(IslandPos pos) {
		int distance = settings.getIslandsDistance();
		return new Location(settings.getWorld(), pos.x() * distance, getIslandsHeight(), pos.z() * distance);
	}

	public IslandPos fromLocation(Location location) {
		if (location.getWorld() != settings.getWorld()) {
			return null;
		}

		int distance = settings.getIslandsDistance();
		return new IslandPos(location.getBlockX() / distance, location.getBlockZ() / distance);
	}

	public int getIslandsHeight() {
		return settings.getIslandsHeight();
	}
	
	public World getIslandsWorld() {
		return settings.getWorld();
	}

	private Location nextIsland() {
		updatePos();
		updateConfig();
		return fromIslandPos(previous);
	}

	private void updateConfig() {
		configIslandCounter.set(ConfigIslandCounter.X, Integer.toString(previous.x()));
		configIslandCounter.set(ConfigIslandCounter.Z, Integer.toString(previous.z()));
		try {
			configIslandCounter.save();
		} catch (IOException e) {
			CommonsHelper.consoleInfo("&cCouldn't save the last generated island location! Check the errors file");
			plugin.writeThrowableOnErrorsFile(e);
		}
	}

	private void updatePos() {
		int x = previous.x();
		int z = previous.z();
		if (x < z) {
			if (x * -1 < z) {
				previous = new IslandPos(x + 1, z);
				return;
			}

			previous = new IslandPos(x, z + 1);
			return;
		}

		if (x > z) {
			if (x * -1 >= z) {
				previous = new IslandPos(x - 1, z);
				return;
			}

			previous = new IslandPos(x, z - 1);
			return;
		}

		if (x <= 0) {
			previous = new IslandPos(x, z + 1);
			return;
		}

		previous = new IslandPos(x, z - 1);
		return;
	}
}
