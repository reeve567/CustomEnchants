package org.koalakode.reeve.CustomEnchants.Enums;

import org.bukkit.ChatColor;

public enum Messages {
	prefix(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Gorix " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "»» "),
	senderIsConsole(prefix.get() + ChatColor.RED + "You must be a player to do this!"),
	itemBroke(prefix.get() + ChatColor.GRAY + "Whoops, looks like your item broke.  Better luck next time!"),
	itemSuccess(prefix.get() + ChatColor.GRAY + ChatColor.GRAY + "Binding the enchantment to this item was successful!"),
	itemUnsuccessful(prefix.get() + ChatColor.GRAY + "Binding the enchant to this item was unsuccessful, and the book was lost."),
	rektMessage(prefix.get() + ChatColor.GRAY + "Double damage!"),
	cursed(prefix.get() + ChatColor.GRAY + "Your opponent was cursed!"),
	launched(prefix.get() + ChatColor.GRAY + "weeeee"),
	frozen(prefix.get() + ChatColor.GRAY + "Your target was hit with a chill."),
	smited(prefix.get() + ChatColor.GRAY + "Your target was smitten"),
	fifsecCooldown(Messages.prefix.get() + ChatColor.GRAY + "You can only shoot this every 15 seconds!"),
	noAmmo(Messages.prefix.get() + ChatColor.GRAY + "Not enough ammo."),
	poisoned(Messages.prefix.get() + ChatColor.GRAY + "Your target was poisoned."),
	noSoul(Messages.prefix.get() + ChatColor.GRAY + "This is not a soul, bring me a soul and I will grant you a reward."),
	mainPre(ChatColor.GRAY + "   " + ChatColor.BOLD + "»  ")
	;

	private final String value;

	Messages(String s) {
		value = s;
	}

	public String get() {
		return value;
	}
}
