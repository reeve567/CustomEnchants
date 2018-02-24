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
// on 5:45 PM

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

public class CommonSC {
	
	private static ArrayList<Prize> prizes = new ArrayList<Prize>();
	private static HashMap<Player, Inventory> inventories = new HashMap<Player, Inventory>();
	private static Inventory baseInventory = Bukkit.createInventory(null, 27, Rarities.COMMON.getLabel());
	
	static {
		for (Enchants ces : Enchants.values()) {
			if (ces.getRarity().equals(Rarities.COMMON)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GRAY + "64 Diamonds", new ItemStack(Material.DIAMOND, 64)));
		prizes.add(new Prize(ChatColor.GRAY + "32 Diamonds", new ItemStack(Material.DIAMOND, 32)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "5000", new ItemStack(Material.DOUBLE_PLANT, 5)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "2500", new ItemStack(Material.DOUBLE_PLANT, 2)));
		prizes.add(new Prize(Souls.COMMON.getItem().getItemMeta().getDisplayName(), Souls.COMMON.getItem()));
		prizes.add(new Prize(Souls.UNCOMMON.getItem().getItemMeta().getDisplayName(), Souls.UNCOMMON.getItem()));
		prizes.add(new Prize(ChatColor.GOLD + "Bat Spawner", new ItemStack(Material.MOB_SPAWNER, 1)));
		prizes.add(new Prize(ChatColor.GOLD + "Diamond Package", new ItemStack(Material.DIAMOND_AXE, 1)));
		prizes.add(new Prize(ChatColor.GREEN + "5 Creeper spawn eggs", new ItemStack(Material.MONSTER_EGG, 5, (short) 50)));
		prizes.add(new Prize(ChatColor.RED + "64 TNT", new ItemStack(Material.TNT, 64)));
		prizes.add(new Prize(ChatColor.BLUE + "Shark", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		
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
