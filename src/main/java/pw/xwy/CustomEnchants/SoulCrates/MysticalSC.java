package pw.xwy.CustomEnchants.SoulCrates;
// made by reeve
// on 1:05 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.CustomEnchants.Enums.CustomEnchants;
import pw.xwy.CustomEnchants.Enums.Rarities;
import pw.xwy.CustomEnchants.Enums.Souls;

import java.util.ArrayList;
import java.util.HashMap;

public class MysticalSC {
	
	private static ArrayList<Prize> prizes = new ArrayList<Prize>();
	private static HashMap<Player, Inventory> inventories = new HashMap<Player, Inventory>();
	private static Inventory baseInventory = Bukkit.createInventory(null, 27, Rarities.MYSTICAL.getLabel());
	
	static {
		for (CustomEnchants ces : CustomEnchants.values()) {
			if (ces.getRarity().equals(Rarities.MYSTICAL)) {
				prizes.add(new Prize(ces.getName(), new ItemStack(Material.BOOK)));
			}
		}
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "20000", new ItemStack(Material.DOUBLE_PLANT, 20)));
		prizes.add(new Prize(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "17500", new ItemStack(Material.DOUBLE_PLANT, 17)));
		prizes.add(new Prize(Souls.RARE.getItem().getItemMeta().getDisplayName(), Souls.RARE.getItem()));
		prizes.add(new Prize(Souls.UNCOMMON.getItem().getItemMeta().getDisplayName(), Souls.UNCOMMON.getItem()));
		prizes.add(new Prize(Souls.MYSTICAL.getItem().getItemMeta().getDisplayName(), Souls.MYSTICAL.getItem()));
		prizes.add(new Prize(ChatColor.GREEN + "22 Creeper spawn eggs", new ItemStack(Material.MONSTER_EGG, 22, (short) 50)));
		prizes.add(new Prize(ChatColor.YELLOW + "64 Bottle o Enchanting", new ItemStack(Material.EXP_BOTTLE, 64)));
		prizes.add(new Prize(ChatColor.GRAY + "10 Hoppers", new ItemStack(Material.HOPPER, 5)));
		prizes.add(new Prize(ChatColor.BLUE + "Kraken", new ItemStack(Material.INK_SACK, 1, (short) 4)));
		prizes.add(new Prize(ChatColor.DARK_PURPLE + "Mystical Package", new ItemStack(Material.NETHER_STAR)));
		
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
