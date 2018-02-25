////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 7:55 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.ItemSets;
import pw.xwy.customenchants.enums.MenuItem;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.utilities.Resources;

import java.util.ArrayList;

import static pw.xwy.customenchants.utilities.MenuUtility.getItem;
import static pw.xwy.customenchants.utilities.MenuUtility.setItem;

public class Menu {
	
	protected Inventory inventory = Bukkit.createInventory(null, 45, Resources.getMenu("MenuTitle"));
	
	Menu(ItemSets type) {
		for (int i = 0; i < 45; i++) {
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, new ArrayList<>());
			topPane.setDurability((short) 7);
			inventory.setItem(i, topPane);
		}
		setItem(Rarities.HYDRO.getLabel(), Material.BOOKSHELF, new ArrayList<>(), 0, inventory);
		setItem(Rarities.MYSTICAL.getLabel(), Material.BOOKSHELF, new ArrayList<>(), 9, inventory);
		setItem(Rarities.RARE.getLabel(), Material.BOOKSHELF, new ArrayList<>(), 18, inventory);
		setItem(Rarities.UNCOMMON.getLabel(), Material.BOOKSHELF, new ArrayList<>(), 27, inventory);
		setItem(Rarities.COMMON.getLabel(), Material.BOOKSHELF, new ArrayList<>(), 36, inventory);
		setItem(Resources.getMenu("BackButton"), Material.BARRIER, new ArrayList<>(), 44, inventory);
		int nextHydro = 1;
		int nextMystical = 10;
		int nextRare = 19;
		int nextUncommon = 28;
		int nextCommon = 37;
		for (MenuItem mi : MenuItem.values()) {
			if (mi.getCustomEnchant().isEnabled() && mi.getCustomEnchant().containsSet(type)) {
				if (mi.getCustomEnchant().getRarity().equals(Rarities.HYDRO)) {
					setItem(mi.getCustomEnchant().getName(), mi.getType(), mi.getDurability(), mi.getDesc(), nextHydro++, inventory);
				} else if (mi.getCustomEnchant().getRarity().equals(Rarities.MYSTICAL)) {
					setItem(mi.getCustomEnchant().getName(), mi.getType(), mi.getDurability(), mi.getDesc(), nextMystical++, inventory);
				} else if (mi.getCustomEnchant().getRarity().equals(Rarities.RARE)) {
					setItem(mi.getCustomEnchant().getName(), mi.getType(), mi.getDurability(), mi.getDesc(), nextRare++, inventory);
				} else if (mi.getCustomEnchant().getRarity().equals(Rarities.UNCOMMON)) {
					setItem(mi.getCustomEnchant().getName(), mi.getType(), mi.getDurability(), mi.getDesc(), nextUncommon++, inventory);
				} else if (mi.getCustomEnchant().getRarity().equals(Rarities.COMMON)) {
					setItem(mi.getCustomEnchant().getName(), mi.getType(), mi.getDurability(), mi.getDesc(), nextCommon++, inventory);
				}
			}
		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
}
