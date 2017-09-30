package org.koalakode.reeve.CustomEnchants.Util;
// made by reeve
// on 6:20 PM

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.koalakode.reeve.CustomEnchants.Enums.Rarities;
import org.koalakode.reeve.CustomEnchants.Enums.Souls;
import org.koalakode.reeve.CustomEnchants.SoulCrates.Prize;

import java.util.ArrayList;

public class CratesUtil {

	public static void openCrate(Player p, ItemStack key) {
		for (Souls s: Souls.values()) {
			if (s.getItem().getItemMeta().getDisplayName().equals(key.getItemMeta().getDisplayName())) {

			}
		}


	}



	public static ArrayList<ItemStack> movePrizes(ArrayList<ItemStack> items, ArrayList<Prize> prizes, int putItems) {

		items.remove(0);
		if (putItems - 1 < prizes.size()) {
			items.add(prizes.get(putItems - 1).getDisplayItem());
		}
		return items;
	}

	public static void putPrize(Inventory inv, int slot, int putItems, ArrayList<Prize> prizes) {
		inv.setItem(slot, prizes.get(putItems - 1).getDisplayItem());
	}


}
