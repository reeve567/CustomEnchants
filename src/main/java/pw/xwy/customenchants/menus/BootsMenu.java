package pw.xwy.customenchants.menu;
// made by reeve
// on 6:36 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BootsMenu {
	
	private static Inventory BootsMenu = Bukkit.createInventory(null, 45, ChatColor.RED + "" + ChatColor.BOLD + "Custom Enchants");
	
	static {
		List<String> desc = new ArrayList<String>();
		
		
		for (int i = 0; i < 45; i++) {
			desc.clear();
			ItemStack topPane = Utils.getItem(" ", Material.STAINED_GLASS_PANE, desc);
			topPane.setDurability((short) 7);
			BootsMenu.setItem(i, topPane);
		}
		
		
		desc.clear();
		Utils.setItem(ChatColor.DARK_BLUE + "Hydro", Material.EMERALD, desc, 0, BootsMenu);
		
		/*desc.clear();
		desc.add(ChatColor.AQUA + "When faction members are near you, your damage is increased.");
		Utils.setItem("Leadership", Material.GOLD_HELMET, desc, 1, BootsMenu);*/
		
		desc.clear();
		desc.add(ChatColor.AQUA + "When you hit to one and a half hearts or below, you get a speed boost for 3 seconds.");
		Utils.setItem("SuperSpeed", Material.GOLD_BOOTS, desc, 1, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "Dying with this enchant on an item");
		desc.add(ChatColor.AQUA + "has a chance of keeping it on respawn");
		Utils.setItem("Soulbound", Material.GOLDEN_APPLE, 1, desc, 2, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you haste if you have the enchant on all pieces of armor.");
		Utils.setItem("Flash", Material.GOLD_PICKAXE, desc, 3, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives you resistance if you have the enchant on all pieces of armor.");
		Utils.setItem("Valor", Material.BEACON, desc, 4, BootsMenu);
		
		desc.clear();
		Utils.setItem(ChatColor.DARK_PURPLE + "Mystical", Material.DIAMOND, desc, 9, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		Utils.setItem("Unstable II", Material.DIAMOND_BOOTS, desc, 10, BootsMenu);
		
		desc.clear();
		Utils.setItem(ChatColor.BLUE + "Rare", Material.GOLD_INGOT, desc, 18, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant decreases the speed at which armor durability decreases.");
		Utils.setItem("Unstable I", Material.DIAMOND_BOOTS, desc, 19, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer JumpBoost I infinitely.");
		Utils.setItem("MoonGravity", Material.GOLDEN_CARROT, desc, 20, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer Speed II infinitely.");
		Utils.setItem("Wind's Speed II", Material.SUGAR, desc, 21, BootsMenu);
		
		desc.clear();
		Utils.setItem(ChatColor.DARK_GREEN + "Uncommon", Material.IRON_INGOT, desc, 27, BootsMenu);
		
		desc.clear();
		Utils.setItem(ChatColor.GREEN + "Common", Material.COAL, desc, 36, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant will set an attacker on fire if they hit the wearer.");
		Utils.setItem("Molten", Material.LAVA_BUCKET, desc, 37, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant allows the wearer to swim in lava and fire.");
		Utils.setItem("Burn-Shield", Material.POTION, 1, desc, 38, BootsMenu);
		
		desc.clear();
		desc.add(ChatColor.AQUA + "This enchant gives the wearer Speed I infinitely.");
		Utils.setItem("Wind's Speed I", Material.SUGAR, desc, 39, BootsMenu);
		
		desc.clear();
		Utils.setItem(ChatColor.BLUE + "Back", Material.NETHER_STAR, desc, 44, BootsMenu);
		
	}
	
	public static Inventory get() {
		
		return BootsMenu;
	}
	
	
}
