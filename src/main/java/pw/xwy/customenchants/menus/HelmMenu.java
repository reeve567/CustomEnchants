package pw.xwy.customenchants.menu;
// made by reeve
// on 7:31 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.customenchants.menus.Utils.getItem;
import static pw.xwy.customenchants.menus.Utils.setItem;

public class HelmMenu {
	
	private static Inventory HelmMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			HelmMenu.setItem(i, topPane);
		}
		
		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant makes the wearer immune to wither.");
		setItem("Guardian", Material.YELLOW_FLOWER, desc, 1, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant makes the wearer immune to poison.");
		setItem("Medicine", Material.BROWN_MUSHROOM, desc, 2, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant adds 4 hearts to the player's max health.");
		setItem("HeartBoost", Material.REDSTONE_BLOCK, desc, 3, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you haste if you have the enchant on all pieces of armor.");
		setItem("Flash", Material.GOLD_PICKAXE, desc, 4, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you resistance if you have the enchant on all pieces of armor.");
		setItem("Valor", Material.BEACON, desc, 5, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, HelmMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable II", Material.DIAMOND_HELMET, desc, 10, HelmMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable I", Material.DIAMOND_HELMET, desc, 19, HelmMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, HelmMenu);
		
		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will set an attacker on fire if they hit the wearer.");
		setItem("Molten", Material.LAVA_BUCKET, desc, 37, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows the wearer to swim in lava and fire.");
		setItem("Burn-Shield", Material.POTION, 1, desc, 38, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer infinite night vision.");
		setItem("Glowing", Material.GLOWSTONE, desc, 39, HelmMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer infinite water breathing.");
		setItem("ScubaDiver", Material.RAW_FISH, 0, desc, 40, HelmMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, HelmMenu);
	}
	
	public static Inventory get() {
		
		return HelmMenu;
	}
	
}
