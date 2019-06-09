package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomBlockEnchant extends CustomEnchant {
	public CustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public CustomBlockEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	public abstract void event(BlockBreakEvent e);

}
