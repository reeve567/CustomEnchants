package org.koalakode.reeve.CustomEnchants.Menu;
// made by reeve
// on 1:20 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static org.koalakode.reeve.CustomEnchants.Menu.Utils.getItem;
import static org.koalakode.reeve.CustomEnchants.Menu.Utils.setItem;

public class BowMenu {

	private static Inventory BowMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");

	public static Inventory get() {

		return BowMenu;
	}

	static {
		List<String> desc = new ArrayList<String>();


		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			BowMenu.setItem(i, topPane);
		}


		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Shooting an arrow with this enchant");
		desc.add(ChatColor.AQUA + "launches 4 projectiles while on the");
		desc.add(ChatColor.AQUA + "correct mode.");
		setItem("ShotgunBow", Material.ARROW, desc, 1, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Arrows will launch you towards where they");
		desc.add(ChatColor.AQUA + "land, if on the correct mode.");
		setItem("GrapplingBow", Material.WEB, desc, 2, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "With this enchant, all you have to do");
		desc.add(ChatColor.AQUA + "is right click to shoot an arrow, if");
		desc.add(ChatColor.AQUA + "on the correct mode.");
		setItem("RifleBow", Material.FIREWORK, desc, 3, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 4, BowMenu);


		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives your arrows a chance to");
		desc.add(ChatColor.AQUA + "do double damage.");
		setItem("ExplosiveArrow", Material.GOLD_INGOT, desc, 10, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives your arrows a chance to");
		desc.add(ChatColor.AQUA + "explode on impact.");
		setItem("RPG", Material.TNT, desc, 11, BowMenu);

		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, BowMenu);

		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives your arrows a chance to");
		desc.add(ChatColor.AQUA + "give the player it hit slowness.");
		setItem("FrozenArrow", Material.ICE, desc, 28, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives your arrows a chance to");
		desc.add(ChatColor.AQUA + "smite the player it hit.");
		setItem("Voltage", Material.BLAZE_POWDER, desc, 29, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you arrows a chance to");
		desc.add(ChatColor.AQUA + "poison the player it hit.");
		setItem("PoisonArrow", Material.SKULL_ITEM, 2, desc, 30, BowMenu);

		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, BowMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows your arrows to cook the");
		desc.add(ChatColor.AQUA + "meat of animals that it kills.");
		setItem("Furnace", Material.GRILLED_PORK, desc, 31, BowMenu);


		desc.clear();
		setItem(ChatColor.BLUE + "Back",Material.NETHER_STAR,desc,44,BowMenu);
	}
}
