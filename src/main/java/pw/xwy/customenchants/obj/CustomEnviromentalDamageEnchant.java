package pw.xwy.customenchants.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageEvent;
import pw.xwy.customenchants.obj.CustomEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomEnviromentalDamageEnchant extends CustomEnchant {
	public CustomEnviromentalDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public CustomEnviromentalDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	public abstract void event(EntityDamageEvent e);
}
