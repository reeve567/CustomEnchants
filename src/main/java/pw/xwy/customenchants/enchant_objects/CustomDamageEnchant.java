package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomDamageEnchant extends CustomEnchant {
	public CustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public CustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	public abstract void event(EntityDamageByEntityEvent e);
	
}
