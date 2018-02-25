////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.menus;
// made by reeve
// on 1:07 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.utilities.MainUtility;
import pw.xwy.customenchants.utilities.MenuUtility;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
	
	private static Inventory MainMenu = Bukkit.createInventory(null, 54, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		
		List<String> desc = new ArrayList<String>();
		
		for (int i = 0; i < 54; i++) {
			desc.clear();
			ItemStack topPane = MenuUtility.getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			MainMenu.setItem(i, topPane);
		}
		
		
		desc.clear();
		ItemStack Helm = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Helmet Enchantments", Material.DIAMOND_HELMET, desc, true);
		ItemStack Chest = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Chestplate Enchantments", Material.DIAMOND_CHESTPLATE, desc, true);
		ItemStack Leggings = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Leggings Enchantments", Material.DIAMOND_LEGGINGS, desc, true);
		ItemStack Boots = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Boots Enchantments", Material.DIAMOND_BOOTS, desc, true);
		
		ItemStack Bow = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Bow Enchantments", Material.BOW, desc, true);
		ItemStack Pick = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Pickaxe Enchantments", Material.DIAMOND_PICKAXE, desc, true);
		ItemStack Sword = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Sword Enchantments", Material.DIAMOND_SWORD, desc, true);
		ItemStack Axe = MainUtility.getItem(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Axe Enchantments", Material.DIAMOND_AXE, desc, true);
		
		MainMenu.setItem(13, Helm);
		MainMenu.setItem(20, Pick);
		MainMenu.setItem(22, Chest);
		MainMenu.setItem(24, Sword);
		MainMenu.setItem(29, Axe);
		MainMenu.setItem(31, Leggings);
		MainMenu.setItem(33, Bow);
		MainMenu.setItem(40, Boots);
		
		
	}
	
	public static Inventory get() {
		
		return MainMenu;
	}
	
	
}
