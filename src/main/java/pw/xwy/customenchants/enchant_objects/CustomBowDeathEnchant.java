package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomBowDeathEnchant extends CustomDeathEnchant {
	public CustomBowDeathEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public CustomBowDeathEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	public abstract void launch(ProjectileLaunchEvent e);
}
