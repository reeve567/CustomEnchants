////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities;
// made by reeve
// on 12:16 AM

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.listeners.EnchantDrop;

import java.util.ArrayList;
import java.util.List;

public class MainUtility {
	
	public static ItemStack bookGive(String n, boolean perfect) {
		
		List<String> desc = new ArrayList<String>();
		if (perfect) {
			desc.add("");
			desc.add(ChatColor.GREEN + "Success: " + EnchantDrop.getRandomNumberFrom(50, 100) + "%");
			desc.add(ChatColor.RED + "Destroy: " + EnchantDrop.getRandomNumberFrom(0, 100) + "%");
			desc.add("");
		} else {
			desc.add("");
			desc.add(ChatColor.GREEN + "Success: " + EnchantDrop.getRandomNumberFrom(1, 100) + "%");
			desc.add(ChatColor.RED + "Destroy: " + EnchantDrop.getRandomNumberFrom(0, 100) + "%");
			desc.add("");
		}
		
		for (Enchants e : Enchants.values()) {
			if (cmdCheck(e.getLabel(), n) || cmdCheck(e.getName(), n)) {
				if (n.equalsIgnoreCase("Xwy")) {
					desc.clear();
					desc.add("");
					desc.add(ChatColor.GREEN + "Success: " + 100 + "%");
					desc.add(ChatColor.RED + "Destroy: " + 1 + "%");
					desc.add("");
					desc.add(Enchants.XWY.getRarity().getLabel());
					desc.add("");
					desc.add(Enchants.XWY.getLoreLbl());
					return getItem(Enchants.XWY.getName(), desc);
				}
				desc.add(e.getRarity().getLabel());
				desc.add("");
				desc.add(ChatColor.WHITE + e.getLoreLbl() + " Enchant");
				return getItem(e.getName(), desc);
			}
		}
		return new ItemStack(Material.BOOK, 1);
	}
	
	public static boolean cmdCheck(String c, String s) {
		
		return s.equalsIgnoreCase(c);
	}
	
	public static ItemStack getItem(String name, List<String> desc) {
		
		ItemStack item = new ItemStack(Material.BOOK, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public static ItemStack getItem(String name, Material mat, List<String> desc, boolean glow) {
		
		ItemStack item = new ItemStack(mat, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.addEnchant(new Glow(999), 1, true);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
