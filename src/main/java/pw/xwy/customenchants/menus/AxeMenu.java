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
// on 7:43 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.utilities.MenuUtility;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.customenchants.utilities.MenuUtility.getItem;
import static pw.xwy.customenchants.utilities.MenuUtility.setItem;

public class AxeMenu {
	
	private static Inventory AxeMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			AxeMenu.setItem(i, topPane);
		}
		
		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to give the opponent weakness for 4 seconds.");
		setItem("Demon's Weaknesses II", Material.EYE_OF_ENDER, desc, 1, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to give the opponent blindness for 5 seconds.");
		setItem("SmokeScreen III", Material.COAL, 1, desc, 2, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to give the opponent Mining Fatigue for 8 seconds.");
		setItem("Cursed", Material.WOOD_PICKAXE, desc, 3, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 4, AxeMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to give the opponent weakness for 2 seconds.");
		setItem("Demon's Weaknesses I", Material.EYE_OF_ENDER, desc, 10, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to give the opponent blindness for 4 seconds at II and 2 seconds at I.");
		setItem("SmokeScreen I & II", Material.COAL, 1, desc, 11, AxeMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to deal double damage.");
		setItem("Rekt", Material.DIAMOND_PICKAXE, desc, 19, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant ensures you salvage");
		desc.add(ChatColor.AQUA + "an enemy player's head.");
		setItem("Decapitate", Material.SKULL_ITEM, 3, desc, 20, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Mining the bottom log in a tree will drop all the wood.");
		setItem("Lumberjack", Material.LOG, 0, desc, 21, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Damages the opponents armor more than normal.");
		setItem("Armor Destructor", Material.LEATHER_CHESTPLATE, desc, 22, AxeMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, AxeMenu);
		
		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, AxeMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Has a chance to smite the opponent when you hit them.");
		setItem("Thor", Material.GOLD_AXE, desc, 37, AxeMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, AxeMenu);
		
	}
	
	public static Inventory get() {
		
		return AxeMenu;
	}
}