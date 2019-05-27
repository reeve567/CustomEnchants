package pw.xwy.customenchants.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomDeathEnchant extends CustomEnchant {

	public CustomDeathEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem,disable);
	}

	public CustomDeathEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability,disable);
	}

	public abstract void event(EntityDeathEvent e);
}
