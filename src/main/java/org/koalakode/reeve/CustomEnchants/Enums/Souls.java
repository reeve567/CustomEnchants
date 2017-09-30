package org.koalakode.reeve.CustomEnchants.Enums;
// made by reeve
// on 6:58 PM


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.koalakode.reeve.CustomEnchants.Util.Glow;

import java.util.ArrayList;

public enum Souls {
	COMMON(Rarities.COMMON,"CommonSoul"),
	UNCOMMON(Rarities.UNCOMMON,"UncommonSoul"),
	RARE(Rarities.RARE,"RareSoul"),
	MYSTICAL(Rarities.MYSTICAL,"MysticalSoul"),
	HYDRO(Rarities.HYDRO,"HydroSoul")

	;

	private final String name;
	private final String commandLabel;
	private final ItemStack item;

	Souls(Rarities name, String commandLabel) {
		this.name = name.getLabel() + " Soul";
		this.commandLabel = commandLabel;

		ItemStack it = new ItemStack(Material.FIREBALL);
		ItemMeta im = it.getItemMeta();
		im.setDisplayName(this.name);
		ArrayList<String> lores = new ArrayList<String>();
		lores.add(ChatColor.GRAY + "Redeem this from Gorix for a prize.");
		im.setLore(lores);
		im.addEnchant(new Glow(999),1,true);
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
