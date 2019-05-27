package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.obj.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Wither1 extends CustomDamageEnchant {
	public Wither1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Wither1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (EnchantDrop.getRandomNumberFrom(1, 100) <= 15) {
			if (e.getEntity() instanceof Player) {
				((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 40, 0));
			}
		}
	}
}
