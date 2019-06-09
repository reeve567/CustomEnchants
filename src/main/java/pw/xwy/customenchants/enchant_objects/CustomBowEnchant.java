package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomBowEnchant extends CustomDamageEnchant {
	public CustomBowEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public CustomBowEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	public abstract void launch(ProjectileLaunchEvent e);
}
