////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.enums;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum Rarity {
	COMMON(ChatColor.GREEN, "Common", Material.LIME_STAINED_GLASS_PANE),
	UNCOMMON(ChatColor.DARK_GREEN, "Uncommon", Material.GREEN_STAINED_GLASS_PANE),
	RARE(ChatColor.BLUE, "Rare", Material.BLUE_STAINED_GLASS_PANE),
	MYSTICAL(ChatColor.DARK_PURPLE, "Mystical", Material.PURPLE_STAINED_GLASS_PANE),
	HYDRO(ChatColor.GOLD, "Legendary", Material.YELLOW_STAINED_GLASS_PANE),
	ADMIN(ChatColor.AQUA, "Admin", Material.LIGHT_BLUE_STAINED_GLASS_PANE);

	private final String label;
	private final ChatColor color;
	private final Material stainedGlass;

	Rarity(ChatColor color, String label, Material stainedGlass) {
		this.color = color;
		this.label = label;
		this.stainedGlass = stainedGlass;
	}

	public String getLabel() {
		return color + label;
	}

	public ChatColor getColor() {
		return color;
	}

	public Material getStainedGlass() {
		return stainedGlass;
	}
}
