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
// on 6:22 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.utilities.MenuUtility;

import java.util.ArrayList;
import java.util.List;

public class PickMenu {
	
	private static Inventory PickMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = MenuUtility.getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			PickMenu.setItem(i, topPane);
		}
		
		
		desc.clear();
		MenuUtility.setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, PickMenu);
		
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows your pickaxe to");
		desc.add(ChatColor.AQUA + "mine in a 3x3 area.");
		MenuUtility.setItem("ExplosivePick", Material.FIREBALL, desc, 1, PickMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		MenuUtility.setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, PickMenu);
		
		desc.clear();
		MenuUtility.setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, PickMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant brings great fortune to many");
		MenuUtility.setItem("Fortune V", Material.DIAMOND_PICKAXE, desc, 10, PickMenu);
		
		desc.clear();
		MenuUtility.setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, PickMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "When you destroy a block with this, you");
		desc.add(ChatColor.AQUA + "get the molten products of that block.");
		MenuUtility.setItem("Smelting", Material.GOLD_INGOT, desc, 19, PickMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Mined blocks go straight to your inventory.");
		MenuUtility.setItem("Magnet", Material.HOPPER, desc, 20, PickMenu);
		
		desc.clear();
		MenuUtility.setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, PickMenu);
		
		desc.clear();
		MenuUtility.setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, PickMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant increases the amount of blocks you");
		desc.add(ChatColor.AQUA + "can mine without repairing.");
		MenuUtility.setItem("Hardened", Material.WOOD_PICKAXE, desc, 37, PickMenu);
		
		desc.clear();
		MenuUtility.setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, PickMenu);
	}
	
	public static Inventory get() {
		
		return PickMenu;
	}
	
}
