package org.koalakode.reeve.CustomEnchants.Enums;
// made by reeve
// on 6:47 PM

import org.bukkit.ChatColor;

public enum Gorix {
	GORIX(ChatColor.RED + "" + ChatColor.BOLD + "Gorix"),
	COMMONCRATE(Rarities.COMMON.getLabel() + " Crate"),

	;

	private final String value;

	Gorix(String value) {
		this.value = value;
	}

	public String get() {
		return value;
	}
}
