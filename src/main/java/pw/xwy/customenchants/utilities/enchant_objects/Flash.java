package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.RealName;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Flash extends CustomTaskEnchant {
	
	public Flash(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	private boolean ItemCheck(ItemStack i) {
		return i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(RealName.FLASH.getEnchant().getName());
	}
	
	@Override
	// Check back in 35 ticks
	public void event(Player player) {
		if (ItemCheck(player.getInventory().getHelmet()) &&
				ItemCheck(player.getInventory().getChestplate()) &&
				ItemCheck(player.getInventory().getLeggings()) &&
				ItemCheck(player.getInventory().getBoots())) {
			if (player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
				player.removePotionEffect(PotionEffectType.FAST_DIGGING);
			}
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 45, 0));
		}
	}
}
