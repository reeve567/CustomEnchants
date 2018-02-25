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
// on 6:53 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.customenchants.utilities.MenuUtility.getItem;
import static pw.xwy.customenchants.utilities.MenuUtility.setItem;

public class LeggingsMenu {
	
	private static Inventory LeggingsMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			LeggingsMenu.setItem(i, topPane);
		}
		
		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will give you 4 seconds of regeneration when you get below 3 hearts.");
		setItem("SelfHealer", Material.RED_MUSHROOM, desc, 1, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you haste if you have the enchant on all pieces of armor.");
		setItem("Flash", Material.GOLD_PICKAXE, desc, 3, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you resistance if you have the enchant on all pieces of armor.");
		setItem("Valor", Material.BEACON, desc, 4, LeggingsMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant prevents you from losing hunger.");
		setItem("AutoFeeder", Material.COOKIE, desc, 10, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable II", Material.DIAMOND_LEGGINGS, desc, 11, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment reduces the amount of knockback you take.");
		setItem("AntiKnockback III", Material.FIREWORK_CHARGE, desc, 12, LeggingsMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable I", Material.DIAMOND_LEGGINGS, desc, 19, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment prevents your EXP from being stolen.");
		setItem("EXPProtector", Material.EXP_BOTTLE, desc, 20, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment reduces the amount of knockback you take.");
		setItem("AntiKnockback II", Material.FIREWORK_CHARGE, desc, 21, LeggingsMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment reduces the amount of knockback you take.");
		setItem("AntiKnockback I", Material.FIREWORK_CHARGE, desc, 28, LeggingsMenu);
		
		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will set an attacker on fire if they hit the wearer.");
		setItem("Molten", Material.LAVA_BUCKET, desc, 37, LeggingsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows the wearer to swim in lava and fire.");
		setItem("Burn-Shield", Material.POTION, 1, desc, 38, LeggingsMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, LeggingsMenu);
	}
	
	public static Inventory get() {
		
		return LeggingsMenu;
	}
	
}
