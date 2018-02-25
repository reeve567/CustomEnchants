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
// on 7:44 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.CEnchant;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;

public class UncommonSC extends Crate {
	
	public UncommonSC() {
		super(Bukkit.createInventory(null, 27, Rarities.UNCOMMON.getLabel()));
		for (CEnchant ces : CEnchant.values()) {
			if (ces.getRarity().equals(Rarities.UNCOMMON)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000", new ItemStack(Material.DOUBLE_PLANT, 10)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "7500", new ItemStack(Material.DOUBLE_PLANT, 7)));
		prizes.add(new Prize(Souls.RARE.getItem().getItemMeta().getDisplayName(), Souls.RARE.getItem()));
		prizes.add(new Prize(Souls.UNCOMMON.getItem().getItemMeta().getDisplayName(), Souls.UNCOMMON.getItem()));
		prizes.add(new Prize(ChatColor.GOLD + "Ocelot Spawner", new ItemStack(Material.MOB_SPAWNER, 1)));
		prizes.add(new Prize(ChatColor.GOLD + "Pig Spawner", new ItemStack(Material.MOB_SPAWNER, 1)));
		prizes.add(new Prize(ChatColor.GREEN + "10 Creeper spawn eggs", new ItemStack(Material.MONSTER_EGG, 10, (short) 50)));
		prizes.add(new Prize(ChatColor.YELLOW + "32 Bottle o Enchanting", new ItemStack(Material.EXP_BOTTLE, 32)));
		prizes.add(new Prize(ChatColor.GRAY + "2 Hoppers", new ItemStack(Material.HOPPER, 2)));
		prizes.add(new Prize(ChatColor.RED + "64 TNT and 5 dispensers", new ItemStack(Material.TNT, 64)));
		prizes.add(new Prize(ChatColor.GOLD + "Ore Package", new ItemStack(Material.EMERALD_ORE, 32)));
		prizes.add(new Prize(ChatColor.BLUE + "Shark", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		
		for (int i = 0; i < 27; i++) {
			baseInventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
		}
	}
	
}
