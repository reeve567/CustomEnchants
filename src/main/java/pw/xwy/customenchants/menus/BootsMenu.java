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
// on 6:36 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.utilities.MenuUtility;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.customenchants.utilities.MenuUtility.setItem;

public class BootsMenu {
	
	private static Inventory BootsMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = MenuUtility.getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			BootsMenu.setItem(i, topPane);
		}
		
		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, BootsMenu);
		
		/*desc.clear();
		desc.add(ChatColor.AQUA + "When faction members are near you, your damage is increased.");
		MenuUtility.setItem("Leadership", Material.GOLD_HELMET, desc, 1, BootsMenu);*/
		
		desc.clear();
		desc.add(ChatColor.AQUA + "When you hit to one and a half hearts or below, you get a speed boost for 3 seconds.");
		setItem("SuperSpeed", Material.GOLD_BOOTS, desc, 1, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you haste if you have the enchant on all pieces of armor.");
		setItem("Flash", Material.GOLD_PICKAXE, desc, 3, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you resistance if you have the enchant on all pieces of armor.");
		setItem("Valor", Material.BEACON, desc, 4, BootsMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable II", Material.DIAMOND_BOOTS, desc, 10, BootsMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable I", Material.DIAMOND_BOOTS, desc, 19, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer JumpBoost I infinitely.");
		setItem("MoonGravity", Material.GOLDEN_CARROT, desc, 20, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer Speed II infinitely.");
		setItem("Wind's Speed II", Material.SUGAR, desc, 21, BootsMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, BootsMenu);
		
		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will set an attacker on fire if they hit the wearer.");
		setItem("Molten", Material.LAVA_BUCKET, desc, 37, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows the wearer to swim in lava and fire.");
		setItem("Burn-Shield", Material.POTION, 1, desc, 38, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer Speed I infinitely.");
		setItem("Wind's Speed I", Material.SUGAR, desc, 39, BootsMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, BootsMenu);
		
	}
	
	public static Inventory get() {
		
		return BootsMenu;
	}
	
}
