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
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.utilities.MainUtility;
import pw.xwy.customenchants.utilities.MenuUtility;
import pw.xwy.customenchants.utilities.Resources;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
	
	private static Inventory MainMenu = Bukkit.createInventory(null, 54, Resources.getMenu("MenuTitle"));
	
	static {
		
		List<String> desc = new ArrayList<String>();
		
		for (int i = 0; i < 54; i++) {
			desc.clear();
			ItemStack topPane = MenuUtility.getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			MainMenu.setItem(i, topPane);
		}
		
		desc.clear();
		ItemStack Helm = MainUtility.getItem(Resources.getMenu("Helmet"), Material.DIAMOND_HELMET, desc, true);
		ItemStack Chest = MainUtility.getItem(Resources.getMenu("Chestplate"), Material.DIAMOND_CHESTPLATE, desc, true);
		ItemStack Leggings = MainUtility.getItem(Resources.getMenu("Leggings"), Material.DIAMOND_LEGGINGS, desc, true);
		ItemStack Boots = MainUtility.getItem(Resources.getMenu("Boots"), Material.DIAMOND_BOOTS, desc, true);
		
		ItemStack Bow = MainUtility.getItem(Resources.getMenu("Bow"), Material.BOW, desc, true);
		ItemStack Pick = MainUtility.getItem(Resources.getMenu("Pickaxe"), Material.DIAMOND_PICKAXE, desc, true);
		ItemStack Sword = MainUtility.getItem(Resources.getMenu("Sword"), Material.DIAMOND_SWORD, desc, true);
		ItemStack Axe = MainUtility.getItem(Resources.getMenu("Axe"), Material.DIAMOND_AXE, desc, true);
		
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
