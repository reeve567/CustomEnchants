package pw.xwy.customenchants.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.obj.CustomEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public abstract class CustomVanillaEnchant extends CustomEnchant {
	public CustomVanillaEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public CustomVanillaEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	public abstract void apply(ItemStack itemInteractedWith, Player player);

}
