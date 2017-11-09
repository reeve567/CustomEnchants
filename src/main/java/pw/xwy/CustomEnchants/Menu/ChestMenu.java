package pw.xwy.CustomEnchants.Menu;
// made by reeve
// on 7:17 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static pw.xwy.CustomEnchants.Menu.Utils.getItem;
import static pw.xwy.CustomEnchants.Menu.Utils.setItem;

public class ChestMenu {
	
	private static Inventory ChestMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			ChestMenu.setItem(i, topPane);
		}
		
		desc.clear();
		setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will give you 4 seconds of resistance when you get below 3 hearts.");
		setItem("Reinforced", Material.GOLDEN_APPLE, desc, 1, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you haste if you have the enchant on all pieces of armor.");
		setItem("Flash", Material.GOLD_PICKAXE, desc, 3, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you resistance if you have the enchant on all pieces of armor.");
		setItem("Valor", Material.BEACON, desc, 4, ChestMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant has a chance of exploding, damaging everything nearby except the wearer.");
		setItem("Detonate", Material.TNT, desc, 10, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant has a chance to make your attacker hungry.");
		setItem("Starved III", Material.RAW_FISH, 3, desc, 11, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable II", Material.DIAMOND_CHESTPLATE, desc, 12, ChestMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant has a chance to make your attacker hungry.");
		setItem("Starved I & II", Material.RAW_FISH, 3, desc, 19, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		setItem("Unstable I", Material.DIAMOND_CHESTPLATE, desc, 20, ChestMenu);
		
		desc.clear();
		setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant either gives the wearer strength when hit, or wither.");
		setItem("BattleRoar", Material.REDSTONE_TORCH_ON, desc, 28, ChestMenu);
		
		desc.clear();
		setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will set an attacker on fire if they hit the wearer.");
		setItem("Molten", Material.LAVA_BUCKET, desc, 37, ChestMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows the wearer to swim in lava and fire.");
		setItem("Burn-Shield", Material.POTION, 1, desc, 38, ChestMenu);
		
		desc.clear();
		setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, ChestMenu);
	}
	
	public static Inventory get() {
		
		return ChestMenu;
	}
	
}
