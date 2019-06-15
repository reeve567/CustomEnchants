package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomDamageEnchant extends ACustomEnchant {
	public CustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public CustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public abstract void event(EntityDamageByEntityEvent e);
	
}
