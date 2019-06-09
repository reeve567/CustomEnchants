package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.CustomEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class SmokeScreen2 extends CustomEnchant {


	public SmokeScreen2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public SmokeScreen2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player && e.getEntity() instanceof Player)) {
			return;
		}

		int r = EnchantDrop.getRandomNumberFrom(1, 100);
		if (r <= 85) {
			((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0));
		}
	}
}
