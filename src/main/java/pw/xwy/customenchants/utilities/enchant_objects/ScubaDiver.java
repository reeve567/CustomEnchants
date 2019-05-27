package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class ScubaDiver extends CustomTaskEnchant {
	public ScubaDiver(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public ScubaDiver(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void event(Player p) {
		if (p.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
			p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		}
		p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 45, 0));
	}
}
