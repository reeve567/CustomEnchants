package pw.xwy.CustomEnchants.Enums;
// made by reeve
// on 6:58 PM


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pw.xwy.CustomEnchants.Util.Glow;

import java.util.ArrayList;

public enum Souls {
	COMMON(Rarities.COMMON, "CommonKey"),
	UNCOMMON(Rarities.UNCOMMON, "UncommonKey"),
	RARE(Rarities.RARE, "RareKey"),
	MYSTICAL(Rarities.MYSTICAL, "MysticalKey"),
	HYDRO(Rarities.HYDRO, "HydroKey");
	
	private final String name;
	private final String commandLabel;
	private final ItemStack item;
	
	Souls(Rarities name, String commandLabel) {
		this.name = name.getLabel() + " Key";
		this.commandLabel = commandLabel;
		
		ItemStack it = new ItemStack(Material.NETHER_STAR);
		ItemMeta im = it.getItemMeta();
		im.setDisplayName(this.name);
		ArrayList<String> lores = new ArrayList<>();
		lores.add(ChatColor.GRAY + "Redeem this from Rubix for a prize.");
		im.setLore(lores);
		im.addEnchant(new Glow(999), 1, true);
		it.setItemMeta(im);
		this.item = it;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCommandLabel() {
		return commandLabel;
	}
	
	public ItemStack getItem() {
		return item;
	}
}
