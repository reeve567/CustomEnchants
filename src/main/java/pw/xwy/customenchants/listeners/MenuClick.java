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

public class MenuClick implements Listener {
	
	@EventHandler
	public void MenuClicked(InventoryClickEvent e) {
		
		ItemStack clicked = e.getCurrentItem();
		
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants") ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.HYDRO.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.MYSTICAL.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.RARE.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.UNCOMMON.getLabel()) ||
				e.getInventory().getName().equalsIgnoreCase(Rarities.COMMON.getLabel())) {
			e.setCancelled(true);
			if (clicked != null) {
				if (clicked.hasItemMeta()) {
					if (clicked.getItemMeta().hasDisplayName()) {
						if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Helmet Enchantments"))
							e.getWhoClicked().openInventory(HelmMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Chestplate Enchantments"))
							e.getWhoClicked().openInventory(ChestMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Leggings Enchantments"))
							e.getWhoClicked().openInventory(LeggingsMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Boots Enchantments"))
							e.getWhoClicked().openInventory(BootsMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Sword Enchantments"))
							e.getWhoClicked().openInventory(SwordMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Bow Enchantments"))
							e.getWhoClicked().openInventory(BowMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Pickaxe Enchantments"))
							e.getWhoClicked().openInventory(PickMenu.get());
						else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Axe Enchantments"))
							e.getWhoClicked().openInventory(AxeMenu.get());
						else if (e.getSlot() == 44)
							e.getWhoClicked().openInventory(MainMenu.get());
					}
				}
			}
		}
	}
}
