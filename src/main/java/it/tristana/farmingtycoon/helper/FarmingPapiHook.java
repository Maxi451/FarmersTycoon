package it.tristana.farmingtycoon.helper;

import static java.lang.String.valueOf;

import it.tristana.commons.hooks.BasicPapiHook;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.database.FarmingUser;

public final class FarmingPapiHook extends BasicPapiHook<Main, FarmingUser> {

	public FarmingPapiHook(Main plugin, UsersManager<FarmingUser> usersManager) {
		super(plugin, usersManager);
	}

	/**
	 * Available placeholders:
	 * <ul>
	 * 	<li>%ft_player%</li>
	 * 	<li>%ft_money%</li>
	 * </ul>
	 */

	@Override
	protected String parsePlaceholder(FarmingUser user, String identifier) {
		switch (identifier) {
		case "player":
			return valueOf(user.getPlayer().getName());
		case "money":
			return NumberFormat.format(user.getMoney());
		default:
			break;
		}

		return null;
	}

	@Override
	public String getIdentifier() {
		return "ft";
	}
	
	@Override
	public boolean register() {
		return super.register();
	}
}