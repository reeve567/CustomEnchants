////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 7:55 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.menu;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.clickable_inventory.ClickableInventory;
import pw.xwy.clickable_inventory.NonClickableItem;
import pw.xwy.clickable_inventory.OpenInventoryClickableItem;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.utilities.gui.MainMenu;
import pw.xwy.utils.CustomItem;

public class Menu {

	private ClickableInventory inventory;

	public Menu(JavaPlugin plugin, ItemSets type) {
		inventory = new ClickableInventory(plugin, null, 45, "§c§lCustom Enchants");
		inventory.setBackground(new CustomItem(Material.GRAY_STAINED_GLASS_PANE).setName(" "));
		inventory.setSlot(new NonClickableItem(new CustomItem(Material.BOOKSHELF).setName(Rarity.HYDRO.getLabel())), 0);
		inventory.setSlot(new NonClickableItem(new CustomItem(Material.BOOKSHELF).setName(Rarity.MYSTICAL.getLabel())), 9);
		inventory.setSlot(new NonClickableItem(new CustomItem(Material.BOOKSHELF).setName(Rarity.RARE.getLabel())), 18);
		inventory.setSlot(new NonClickableItem(new CustomItem(Material.BOOKSHELF).setName(Rarity.UNCOMMON.getLabel())), 27);
		inventory.setSlot(new NonClickableItem(new CustomItem(Material.BOOKSHELF).setName(Rarity.COMMON.getLabel())), 36);
		inventory.setSlot(new OpenInventoryClickableItem(new CustomItem(Material.RED_WOOL).setName("&9Back"), MainMenu.get()), 44);

		int nextHydro = 1;
		int nextMystical = 10;
		int nextRare = 19;
		int nextUncommon = 28;
		int nextCommon = 37;

		for (ACustomEnchant customEnchant : CustomEnchants.manager.getEnchantsByRealName().values()) {
			if (customEnchant.isEnabled() && customEnchant.containsSet(type)) {
				if (customEnchant.getRarity().equals(Rarity.HYDRO)) {
					inventory.setSlot(new NonClickableItem(new CustomItem(customEnchant.getDisplayItem().getType()).setName(customEnchant.getName()).setCustomLore(customEnchant.getDescription())), nextHydro++);
				} else if (customEnchant.getRarity().equals(Rarity.MYSTICAL)) {
					inventory.setSlot(new NonClickableItem(new CustomItem(customEnchant.getDisplayItem().getType()).setName(customEnchant.getName()).setCustomLore(customEnchant.getDescription())), nextMystical++);
				} else if (customEnchant.getRarity().equals(Rarity.RARE)) {
					inventory.setSlot(new NonClickableItem(new CustomItem(customEnchant.getDisplayItem().getType()).setName(customEnchant.getName()).setCustomLore(customEnchant.getDescription())), nextRare++);
				} else if (customEnchant.getRarity().equals(Rarity.UNCOMMON)) {
					inventory.setSlot(new NonClickableItem(new CustomItem(customEnchant.getDisplayItem().getType()).setName(customEnchant.getName()).setCustomLore(customEnchant.getDescription())), nextUncommon++);
				} else if (customEnchant.getRarity().equals(Rarity.COMMON)) {
					inventory.setSlot(new NonClickableItem(new CustomItem(customEnchant.getDisplayItem().getType()).setName(customEnchant.getName()).setCustomLore(customEnchant.getDescription())), nextCommon++);
				}
			}
		}
	}

	public Inventory getInventory() {
		return inventory.getInventory();
	}

}
