package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.obj.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Thor extends CustomDamageEnchant {

	public Thor(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (EnchantDrop.getRandomNumberFrom(1, 100) <= 10) {
			e.getDamager().getLocation().getWorld().strikeLightning(e.getEntity().getLocation());
			StormCaller.summoner = (Player) e.getDamager();
		}
	}
}
