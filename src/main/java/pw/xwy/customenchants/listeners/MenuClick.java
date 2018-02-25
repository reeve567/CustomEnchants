////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.listeners;
// made by reeve
// on 8:59 PM

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.menus.*;
import pw.xwy.customenchants.utilities.Resources;

public class MenuClick implements Listener {
	
	@EventHandler
	public void MenuClicked(InventoryClickEvent e) {
		
		ItemStack clicked = e.getCurrentItem();
		
		if (e.getInventory().getName().equalsIgnoreCase(Resources.getMenu("MenuTitle")) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.HYDRO.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.MYSTICAL.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.RARE.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.UNCOMMON.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.COMMON.getLabel())) {
			e.setCancelled(true);
			if (clicked != null) {
				if (clicked.hasItemMeta()) {
					if (clicked.getItemMeta().hasDisplayName()) {
						if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Helmet")))
							e.getWhoClicked().openInventory(HelmMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Chestplate")))
							e.getWhoClicked().openInventory(ChestMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Leggings")))
							e.getWhoClicked().openInventory(LeggingsMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Boots")))
							e.getWhoClicked().openInventory(BootsMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Sword")))
							e.getWhoClicked().openInventory(SwordMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Bow")))
							e.getWhoClicked().openInventory(BowMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Pickaxe")))
							e.getWhoClicked().openInventory(PickMenu.get().getInventory());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Resources.getMenu("Axe")))
							e.getWhoClicked().openInventory(AxeMenu.get().getInventory());
						else if (e.getSlot() == 44)
							e.getWhoClicked().openInventory(MainMenu.get());
					}
				}
			}
		}
	}
}
