package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Cursed extends CustomDamageEnchant {


	public Cursed(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Cursed(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		int r = EnchantDrop.getRandomNumberFrom(1, 100);
		if (r > 85) {
			if (e.getEntity() instanceof Player) {
				((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 160, 0));
				e.getDamager().sendMessage(Messages.cursed.get());
			}
		}

	}
}
