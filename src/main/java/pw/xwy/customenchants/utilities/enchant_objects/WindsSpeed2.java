package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class WindsSpeed2 extends CustomTaskEnchant {
	public WindsSpeed2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public WindsSpeed2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	@Override
	public void event(Player player) {
		if (player.hasPotionEffect(PotionEffectType.SPEED)) {
			player.removePotionEffect(PotionEffectType.SPEED);
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 45, 1));
	}
}
