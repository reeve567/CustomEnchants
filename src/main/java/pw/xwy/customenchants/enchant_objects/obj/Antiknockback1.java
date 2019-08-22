package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Antiknockback1 extends CustomDamageEnchant {
	public Antiknockback1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Antiknockback1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void event(EntityDamageByEntityEvent e) {
		Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> {
			Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.75);
			e.getEntity().setVelocity(kb);
		}, 1);
	}
}