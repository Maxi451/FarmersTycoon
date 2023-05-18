package it.tristana.farmingtycoon.scoreboard;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import it.tristana.commons.scoreboard.BasicScoreboardManager;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsScoreboard;
import it.tristana.farmingtycoon.database.FarmingUser;
import me.clip.placeholderapi.PlaceholderAPI;

public class FarmingScoreboardManager extends BasicScoreboardManager<FarmingUser> {

	private Main plugin;
	private SettingsScoreboard settings;
	
	public FarmingScoreboardManager(Main plugin, SettingsScoreboard settings) {
		this.plugin = plugin;
		this.settings = settings;
		reload();
	}
	
	@Override
	public Collection<Objective> createObjectives(FarmingUser user, Scoreboard scoreboard) {
		Collection<Objective> objectives = new HashSet<>();
		String name = settings.getScoreboardName();
		Objective objective = scoreboard.registerNewObjective(ChatColor.stripColor(name), Criteria.DUMMY, name);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objectives.add(objective);
		return objectives;
	}

	@Override
	protected String getScoreboardName() {
		return settings.getScoreboardName();
	}

	@Override
	protected List<String> getScoreboardLines() {
		return settings.getScoreboardLines();
	}

	@Override
	protected String parseLine(FarmingUser user, String line) {
		return plugin.isPapiEnabled() ? PlaceholderAPI.setPlaceholders(user.getOnlinePlayer(), line) : line;
	}
}
