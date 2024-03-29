package pw.xwy.customenchants.utilities.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;

import java.util.ArrayList;
import java.util.List;

public class EnchantUtility {
	
	public static ItemStack bookGive(String n, boolean perfect) {
		
		List<String> desc = new ArrayList<>();
		if (perfect) {
			desc.add("");
			desc.add("§aSuccess: §f<number>%".replaceAll("<number>", "100"));
			desc.add("§cDestroy: §f<number>%".replaceAll("<number>", "0"));
			desc.add("");
		} else {
			desc.add("");
			desc.add("§aSuccess: §f<number>%".replaceAll("<number>", "" + EnchantDrop.getRandomNumberFrom(1, 100)));
			desc.add("§cDestroy: §f<number>%".replaceAll("<number>", "" + EnchantDrop.getRandomNumberFrom(0, 100)));
			desc.add("");
		}
		
		ACustomEnchant customEnchant = CustomEnchants.manager.getEnchantsByLabel().get(n);
		
		if (customEnchant != null) {
			desc.add(customEnchant.getRarity().getLabel());
			desc.add("");
			desc.add(ChatColor.WHITE + customEnchant.getSets().getName() + " Enchant");
			return getItem(customEnchant.getName(), desc);
		}
		
		return new ItemStack(Material.BOOK, 1);
	}
	
	public static boolean cmdCheck(String c, String s) {
		
		return s.equalsIgnoreCase(c);
	}
	
	public static ItemStack getItem(String name, List<String> desc) {
		
		ItemStack item = new ItemStack(Material.BOOK, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public static ItemStack getItem(String name, Material mat, List<String> desc) {
		
		ItemStack item = new ItemStack(mat, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		itemMeta.setLore(desc);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
