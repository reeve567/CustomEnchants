package pw.xwy.CustomEnchants.Menu;
// made by reeve
// on 1:12 PM

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Utils {
	
	
	public static ItemStack getItem(String name, Material etype, List<String> desc) {
		
		ItemStack item = new ItemStack(etype, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public static ItemStack getItem(String name, Material etype, int durability, List<String> desc) {
		
		ItemStack item = new ItemStack(etype, 1, (short) durability);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public static void setItem(String name, Material etype, List<String> desc, int slot, Inventory inv) {
		
		ItemStack i = getItem(ChatColor.GRAY + name, etype, desc);
		inv.setItem(slot, i);
	}
	
	public static void setItem(String name, Material etype, int durability, List<String> desc, int slot, Inventory inv) {
		
		ItemStack i = getItem(ChatColor.GRAY + name, etype, durability, desc);
		inv.setItem(slot, i);
	}
	
	
}
