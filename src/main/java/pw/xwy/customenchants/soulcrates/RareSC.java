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
// on 10:59 AM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;

public class RareSC extends Crate {
	
	RareSC() {
		super(Bukkit.createInventory(null, 27, Rarities.RARE.getLabel()));
		for (Enchants ces : Enchants.values()) {
			if (ces.getRarity().equals(Rarities.RARE)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000", new ItemStack(Material.DOUBLE_PLANT, 10)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "15000", new ItemStack(Material.DOUBLE_PLANT, 15)));
		prizes.add(new Prize(Souls.RARE.getItem().getItemMeta().getDisplayName(), Souls.RARE.getItem()));
		prizes.add(new Prize(Souls.UNCOMMON.getItem().getItemMeta().getDisplayName(), Souls.UNCOMMON.getItem()));
		prizes.add(new Prize(Souls.MYSTICAL.getItem().getItemMeta().getDisplayName(), Souls.MYSTICAL.getItem()));
		prizes.add(new Prize(ChatColor.GREEN + "15 Creeper spawn eggs", new ItemStack(Material.MONSTER_EGG, 15, (short) 50)));
		prizes.add(new Prize(ChatColor.YELLOW + "48 Bottle o Enchanting", new ItemStack(Material.EXP_BOTTLE, 48)));
		prizes.add(new Prize(ChatColor.GRAY + "5 Hoppers", new ItemStack(Material.HOPPER, 5)));
		prizes.add(new Prize(ChatColor.RED + "64 TNT and 5 dispensers and 5 redstone repeaters", new ItemStack(Material.TNT, 64)));
		prizes.add(new Prize(ChatColor.GOLD + "Mineral Package", new ItemStack(Material.EMERALD, 32)));
		prizes.add(new Prize(ChatColor.BLUE + "Kraken", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		
		for (int i = 0; i < 27; i++) {
			baseInventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
		}
	}
	
}