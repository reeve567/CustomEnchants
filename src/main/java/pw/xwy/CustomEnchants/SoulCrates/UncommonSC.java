package pw.xwy.CustomEnchants.SoulCrates;
// made by reeve
// on 7:44 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.CustomEnchants.Enums.CEnchant;
import pw.xwy.CustomEnchants.Enums.Rarities;
import pw.xwy.CustomEnchants.Enums.Souls;

import java.util.ArrayList;
import java.util.HashMap;

public class UncommonSC {
	
	private static ArrayList<Prize> prizes = new ArrayList<Prize>();
	private static HashMap<Player, Inventory> inventories = new HashMap<Player, Inventory>();
	private static Inventory baseInventory = Bukkit.createInventory(null, 27, Rarities.UNCOMMON.getLabel());
	
	static {
		for (CEnchant ces : CEnchant.values()) {
			if (ces.getRarity().equals(Rarities.UNCOMMON)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000", new ItemStack(Material.DOUBLE_PLANT, 10)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "7500", new ItemStack(Material.DOUBLE_PLANT, 7)));
		prizes.add(new Prize(Souls.RARE.getItem().getItemMeta().getDisplayName(), Souls.RARE.getItem()));
		prizes.add(new Prize(Souls.UNCOMMON.getItem().getItemMeta().getDisplayName(), Souls.UNCOMMON.getItem()));
		prizes.add(new Prize(ChatColor.GOLD + "Ocelot Spawner", new ItemStack(Material.MOB_SPAWNER, 1)));
		prizes.add(new Prize(ChatColor.GOLD + "Pig Spawner", new ItemStack(Material.MOB_SPAWNER, 1)));
		prizes.add(new Prize(ChatColor.GREEN + "10 Creeper spawn eggs", new ItemStack(Material.MONSTER_EGG, 10, (short) 50)));
		prizes.add(new Prize(ChatColor.YELLOW + "32 Bottle o Enchanting", new ItemStack(Material.EXP_BOTTLE, 32)));
		prizes.add(new Prize(ChatColor.GRAY + "2 Hoppers", new ItemStack(Material.HOPPER, 2)));
		prizes.add(new Prize(ChatColor.RED + "64 TNT and 5 dispensers", new ItemStack(Material.TNT, 64)));
		prizes.add(new Prize(ChatColor.GOLD + "Ore Package", new ItemStack(Material.EMERALD_ORE, 32)));
		prizes.add(new Prize(ChatColor.BLUE + "Shark", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		
		for (int i = 0; i < 27; i++) {
			baseInventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
		}
	}
	
	
	public static ArrayList<Prize> getPrizes() {
		return prizes;
	}
	
	public static Inventory getRunningInventory(Player p) {
		return inventories.get(p);
	}
	
	public static boolean isRunningInventory(Player p) {
		return inventories.containsKey(p);
	}
	
	public static void setRunningInventory(Player p, Inventory inv) {
		inventories.put(p, inv);
	}
	
	public static void remRunningInventory(Player p) {
		inventories.remove(p);
	}
	
	public static Inventory getBaseInventory() {
		return baseInventory;
	}
	
	
}
