////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.enums;

import org.bukkit.ChatColor;

public enum Rarities {
	COMMON(ChatColor.GREEN + "Common"),
	UNCOMMON(ChatColor.DARK_GREEN + "Uncommon"),
	RARE(ChatColor.BLUE + "Rare"),
	MYSTICAL(ChatColor.DARK_PURPLE + "Mystical"),
	HYDRO(ChatColor.DARK_BLUE + "Hydro"),
	ADMIN(ChatColor.AQUA + "Admin");
	
	private final String label;
	
	Rarities(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}