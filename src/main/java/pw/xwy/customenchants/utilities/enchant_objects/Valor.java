package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Valor extends CustomTaskEnchant {
	public Valor(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Valor(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void event(Player p) {
		if (p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		}
		p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45, 0));
	}
}
