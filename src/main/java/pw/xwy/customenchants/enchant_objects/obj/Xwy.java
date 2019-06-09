package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageEvent;
import pw.xwy.customenchants.enchant_objects.CustomEnviromentalDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Xwy extends CustomEnviromentalDamageEnchant {
	
	public Xwy(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	@Override
	public void event(EntityDamageEvent e) {
		e.setCancelled(true);
	}
}
