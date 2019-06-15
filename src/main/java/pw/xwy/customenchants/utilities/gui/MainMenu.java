////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.gui;
// made by reeve
// on 1:07 PM

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.clickable_inventory.ClickableInventory;
import pw.xwy.clickable_inventory.OpenInventoryClickableItem;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.menu.Menu;
import pw.xwy.utils.CustomItem;

public class MainMenu {

	private static ClickableInventory inventory;
	private JavaPlugin plugin;

	public MainMenu(JavaPlugin plugin) {
		inventory = new ClickableInventory(plugin, null, 54, "§c§lCustom Enchants");
		this.plugin = plugin;
	}

	public void setItems() {
		inventory.setBackground(new CustomItem(Material.GRAY_STAINED_GLASS_PANE).setName(" "));

		setSlot(Material.DIAMOND_HELMET, 13);
		setSlot(Material.DIAMOND_PICKAXE, 20);
		setSlot(Material.DIAMOND_CHESTPLATE, 22);
		setSlot(Material.DIAMOND_SWORD, 24);
		setSlot(Material.DIAMOND_AXE, 29);
		setSlot(Material.DIAMOND_LEGGINGS, 31);
		setSlot(Material.BOW, 33);
		setSlot(Material.DIAMOND_BOOTS, 40);
		inventory.setSlot(new OpenInventoryClickableItem(new CustomItem(Material.GREEN_STAINED_GLASS_PANE).setName("&eEXP Conversion"), ConversionMenu.get()));
	}

	public static Inventory get() {
		return inventory.getInventory();
	}

	private void setSlot(Material material, int slot) {
		ItemSets set = ItemSets.getSet(material);
		inventory.setSlot(new OpenInventoryClickableItem(new CustomItem(material).setName("&5" + set.getName() + " Enchantments"), new Menu(plugin,set).getInventory()), slot);
	}

}
