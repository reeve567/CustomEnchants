package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomBlockEnchant extends ACustomEnchant {
	public CustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public CustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}

	public abstract void event(BlockBreakEvent e);

}
