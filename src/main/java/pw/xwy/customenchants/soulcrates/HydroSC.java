////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.soulcrates;
// made by reeve
// on 1:28 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;

import java.util.ArrayList;
import java.util.HashMap;

public class HydroSC {
	
	private static ArrayList<Prize> prizes = new ArrayList<Prize>();
	private static HashMap<Player, Inventory> inventories = new HashMap<Player, Inventory>();
	private static Inventory baseInventory = Bukkit.createInventory(null, 27, Rarities.HYDRO.getLabel());
	
	static {
		for (Enchants ces : Enchants.values()) {
			if (ces.getRarity().equals(Rarities.HYDRO)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "25000", new ItemStack(Material.DOUBLE_PLANT, 25)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "50000", new ItemStack(Material.DOUBLE_PLANT, 30)));
		prizes.add(new Prize(Souls.MYSTICAL.getItem().getItemMeta().getDisplayName(), Souls.MYSTICAL.getItem()));
		prizes.add(new Prize(Rarities.COMMON.name() + ChatColor.GRAY + ", " + Rarities.UNCOMMON.name() + ChatColor.GRAY + " and " + Rarities.RARE.name() + ChatColor.GRAY + " Souls", new ItemStack(Souls.MYSTICAL.getItem())));
		prizes.add(new Prize(ChatColor.BLUE + "Orca", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		prizes.add(new Prize(ChatColor.DARK_PURPLE + "Blaze Spawner", new ItemStack(Material.MOB_SPAWNER)));
		
		for (int i = 0; i < 27; i++) {
			baseInventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
		}
	}
	
	
	public static ArrayList<Prize> getPrizes() {
		return prizes;
	}
	
	public static Inventory getRunningInventory(Player p) {
		return inventories.get(p);
	}
	
	public static boolean isRunningInventory(Player p) {
		return inventories.containsKey(p);
	}
	
	public static void setRunningInventory(Player p, Inventory inv) {
		inventories.put(p, inv);
	}
	
	public static void remRunningInventory(Player p) {
		inventories.remove(p);
	}
	
	public static Inventory getBaseInventory() {
		return baseInventory;
	}
	
}
