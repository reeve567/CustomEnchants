package pw.xwy.CustomEnchants.Menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.CustomEnchants.Menu.Utils.getItem;
import static pw.xwy.CustomEnchants.Menu.Utils.setItem;

public class SwordMenu {

	private static Inventory SwordMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");


	public static Inventory get() {

		return SwordMenu;
	}

	static {
		List<String> desc = new ArrayList<String>();


		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			SwordMenu.setItem(i, topPane);
		}


		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "on your sword will heal you for half");
		desc.add(ChatColor.AQUA + "the damage you do.");
		setItem("Vampire", Material.PUMPKIN, desc, 1, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "has a chance to wither the opponent");
		desc.add(ChatColor.AQUA + "for 2 seconds at level I and 4 at II.");
		setItem("Wither I and II", Material.SKULL_ITEM, 1, desc, 2, SwordMenu);
		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "has a chance to inflict weakness on");
		desc.add(ChatColor.AQUA + "the enemy for 2 seconds at level I");
		desc.add(ChatColor.AQUA + "and 4 at II.");
		setItem("Demon's weaknesses I and II", Material.EYE_OF_ENDER, desc, 3, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "has a chance to blind the opponent");
		desc.add(ChatColor.AQUA + "for 5 seconds.");
		setItem("SmokeScreen III", Material.COAL, 1, desc, 4, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy while sprinting");
		desc.add(ChatColor.AQUA + "increases your damage.");
		setItem("Charge", Material.GLOWSTONE_DUST, desc, 5, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 6, SwordMenu);


		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "inflicts 3 seconds of nausea.");
		setItem("Dizzy", Material.JACK_O_LANTERN, desc, 10, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy with this enchant");
		desc.add(ChatColor.AQUA + "has a chance to blind the opponent");
		desc.add(ChatColor.AQUA + "for 2 seconds at level I and 4");
		desc.add(ChatColor.AQUA + "at II.");
		setItem("SmokeScreen I and II", Material.COAL, 1, desc, 11, SwordMenu);
		desc.clear();
		desc.add(ChatColor.AQUA + "Taking damage while blocking with");
		desc.add(ChatColor.AQUA + "this enchant reduces damage by 50%");
		setItem("Guardian's Block", Material.GOLD_SWORD, desc, 12, SwordMenu);


		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant ensures you salvage");
		desc.add(ChatColor.AQUA + "an enemy player's head.");
		setItem("Decapitate", Material.SKULL_ITEM, 3, desc, 19, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "When you hit someone with this,");
		desc.add(ChatColor.AQUA + "it has a chance of stealing their EXP.");
		setItem("EXPThief", Material.EXP_BOTTLE, desc, 20, SwordMenu);


		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment has a chance to give");
		desc.add(ChatColor.AQUA + "the opponent slowness for 5 seconds.");
		setItem("FrozenBlade", Material.ICE, desc, 21, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant increases your damage");
		desc.add(ChatColor.AQUA + "during combos.");
		setItem("Demon's Blade", Material.REDSTONE, desc, 22, SwordMenu);
		desc.clear();
		desc.add(ChatColor.AQUA + "Killing mobs with this enchantment");
		desc.add(ChatColor.AQUA + "yields a higher amount of XP.");
		setItem("MobSlayer III", Material.SPIDER_EYE, desc, 23, SwordMenu);


		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "This enchantment doubles damage to");
		desc.add(ChatColor.AQUA + "hostile mobs.");
		setItem("HostileDamage", Material.SKULL_ITEM, 2, desc, 28, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Killing mobs with this enchantment");
		desc.add(ChatColor.AQUA + "yields a higher amount of XP.");
		setItem("MobSlayer II", Material.SPIDER_EYE, desc, 29, SwordMenu);

		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting an enemy has a chance to");
		desc.add(ChatColor.AQUA + "smite them with lightning.");
		setItem("StormCaller", Material.NETHER_STAR, desc, 37, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Hitting a mob has a chance to slow");
		desc.add(ChatColor.AQUA + "it's movement speed.");
		setItem("Paralyze", Material.ROTTEN_FLESH, desc, 38, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Killing mobs with this enchantment");
		desc.add(ChatColor.AQUA + "yields a high amount of XP.");
		setItem("MobSlayer I", Material.SPIDER_EYE, desc, 39, SwordMenu);

		desc.clear();
		desc.add(ChatColor.AQUA + "Killing mobs will cook their meat automatically.");
		setItem("AnimalCooker", Material.COOKED_BEEF, desc, 40, SwordMenu);

		desc.clear();
		setItem(ChatColor.BLUE + "Back",Material.NETHER_STAR,desc,44,SwordMenu);

	}
}