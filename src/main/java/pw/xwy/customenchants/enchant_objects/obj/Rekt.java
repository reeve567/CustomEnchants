package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Rekt extends CustomDamageEnchant {

	public Rekt(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (EnchantDrop.getRandomNumberFrom(1, 100) <= 10) {
			e.setDamage(e.getDamage() * 2);
			e.getDamager().sendMessage(Messages.rektMessage.get());
		}
	}
}
