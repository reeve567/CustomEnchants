package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class ACustomDamageEnchant extends ACustomEnchant implements ICustomDamageEnchant {
	public ACustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public ACustomDamageEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}
}
