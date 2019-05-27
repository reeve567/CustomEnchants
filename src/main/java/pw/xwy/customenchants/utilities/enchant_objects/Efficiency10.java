package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.obj.CustomVanillaEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Efficiency10 extends CustomVanillaEnchant {
	public Efficiency10(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public Efficiency10(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	@Override
	public void apply(ItemStack itemInteractedWith, Player player) {
		if (itemInteractedWith.getItemMeta().hasEnchant(Enchantment.DIG_SPEED)) {
			if (itemInteractedWith.getItemMeta().getEnchantLevel(Enchantment.DIG_SPEED) >= 10)
				return;
		}
		itemInteractedWith.removeEnchantment(Enchantment.DIG_SPEED);
		itemInteractedWith.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
		player.sendMessage(Messages.itemSuccess.get());
		player.setItemOnCursor(null);
	}
}
