package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomBowBlockEnchant extends CustomEnchant {
	public CustomBowBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public CustomBowBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	public abstract void launch(ProjectileLaunchEvent e);

	public abstract void event(ProjectileHitEvent e);

}
