package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Starved3 extends CustomDamageEnchant {
	public Starved3(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Starved3(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && ((Player) e.getDamager()).getFoodLevel() > 0) {
			int num = EnchantDrop.getRandomNumberFrom(1, 100);
			if (num <= 35) {
				((Player) e.getDamager()).setFoodLevel(((Player) e.getDamager()).getFoodLevel() - 1);
			}
		}
	}
}
