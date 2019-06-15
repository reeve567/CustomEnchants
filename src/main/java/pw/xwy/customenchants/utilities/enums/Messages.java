////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.enums;

public enum Messages {
	prefix("§6§lSystem §8§l»» "),
	senderIsConsole(prefix.get() + "§cYou must be a player to do this!"),
	itemBroke(prefix.get() + "§7Whoops, looks like your item broke.  Better luck next time!"),
	itemSuccess(prefix.get() + "§7Binding the enchantment to this item was successful!"),
	itemUnsuccessful(prefix.get() + "§7Binding the enchant to this item was unsuccessful, and the book was lost."),
	rektMessage(prefix.get() + "§7Double damage!"),
	cursed(prefix.get() + "§7Your opponent was cursed!"),
	launched(prefix.get() + "§7weeeee"),
	frozen(prefix.get() + "§7Your target was hit with a chill."),
	smited(prefix.get() + "§7Your target was smitten"),
	fifsecCooldown(prefix.get() + "§7You can only shoot this every 15 seconds!"),
	fullInventory(prefix.get() + "§cYour inventory is full!"),
	noAmmo(prefix.get() + "§cNot enough ammo."),
	poisoned(prefix.get() + "§7Your target was poisoned."),
	noSoul(prefix.get() + "§7This is not a key, bring me a key and I will grant you a reward."),
	mainPre("§7§l»  ");
	
	private final String value;
	
	Messages(String s) {
		value = s;
	}
	
	public String get() {
		return value;
	}
}
