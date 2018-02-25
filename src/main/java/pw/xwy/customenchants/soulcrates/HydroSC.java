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
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;

public class HydroSC extends Crate {
	
	HydroSC() {
		super(Bukkit.createInventory(null, 27, Rarities.HYDRO.getLabel()));
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
	
}