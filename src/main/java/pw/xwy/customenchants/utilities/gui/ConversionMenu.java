////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 6/17/18 12:13 PM                            /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities.gui;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.clickable_inventory.ClickableInventory;
import pw.xwy.clickable_inventory.ClickableItem;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;
import pw.xwy.customenchants.utilities.ExperienceManager;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.utilities.menu.EnchantUtility;
import pw.xwy.utils.CustomItem;

public class ConversionMenu {

	private static ClickableInventory inventory;

	public ConversionMenu(JavaPlugin plugin) {
		inventory = new ClickableInventory(plugin, null, 27, "&7Convert XP to Enchants");
	}

	public void setItems() {
		inventory.setBackground(new CustomItem(Material.BLACK_STAINED_GLASS_PANE).setName(" "));
		setSlot(400, Rarity.COMMON, 9);
		setSlot(800, Rarity.UNCOMMON, 11);
		setSlot(2000, Rarity.RARE, 13);
		setSlot(4500, Rarity.MYSTICAL, 15);
		setSlot(10000, Rarity.HYDRO, 17);
	}

	public static Inventory get() {
		return inventory.getInventory();
	}

	public static ItemStack getBook(ACustomEnchant e) {
		return EnchantUtility.bookGive(e.getCommandLabel(), false);
	}

	private void setSlot(int xp, Rarity rarity, int slot) {
		inventory.setSlot(new ClickableItem(new CustomItem(rarity.getStainedGlass()).setName(rarity.getLabel()).setLore("&7Exchange " + xp + " for an enchantment")) {
			@Override
			public void onClick(InventoryClickEvent inventoryClickEvent) {
				exchange(inventoryClickEvent.getWhoClicked(), rarity, xp);
			}
		}, slot);
	}

	private void exchange(HumanEntity player, Rarity rarity, int xp) {
		if (player.getInventory().firstEmpty() != -1) {
			ExperienceManager manager = new ExperienceManager((Player) player);
			if (manager.getTotalExperience() >= xp) {
				manager.setTotalExperience(manager.getTotalExperience() - xp);
				player.getInventory().addItem(getBook(CustomEnchants.manager.getRandomEnchant(rarity)));
			}
		} else {
			player.sendMessage(Messages.fullInventory.get());
		}

	}

	public void openInventory(Player player) {
		player.openInventory(inventory.getInventory());
	}

}
