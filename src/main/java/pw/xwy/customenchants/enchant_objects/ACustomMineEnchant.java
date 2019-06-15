package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class ACustomMineEnchant extends ACustomEnchant implements ICustomMineEnchant {
	public ACustomMineEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public ACustomMineEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}
}
