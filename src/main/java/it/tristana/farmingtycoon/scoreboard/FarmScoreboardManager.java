package it.tristana.farmingtycoon.scoreboard;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import it.tristana.commons.scoreboard.BasicScoreboardManager;
import it.tristana.farmingtycoon.config.SettingsScoreboard;
import it.tristana.farmingtycoon.database.FarmingUser;

public class FarmScoreboardManager extends BasicScoreboardManager<FarmingUser> {

	private SettingsScoreboard settings;
	
	public FarmScoreboardManager(SettingsScoreboard settings) {
		this.settings = settings;
	}
	
	@Override
	public Collection<Objective> createObjectives(FarmingUser user, Scoreboard scoreboard) {
		Collection<Objective> objectives = new HashSet<>();
		Objective objective = scoreboard.registerNewObjective("farmingtycoon", Criteria.DUMMY, settings.getScoreboardName());
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
		return line;
	}
}
