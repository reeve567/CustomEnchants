package pw.xwy.CustomEnchants.Enums;

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
