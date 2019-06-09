package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomTaskEnchant extends CustomEnchant {

	public CustomTaskEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public CustomTaskEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	public abstract void event(Player player);

}
