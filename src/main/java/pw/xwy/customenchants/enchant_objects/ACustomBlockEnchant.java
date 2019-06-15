package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class ACustomBlockEnchant extends ACustomEnchant implements ICustomBlockEnchant {
	ACustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	ACustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}
}
