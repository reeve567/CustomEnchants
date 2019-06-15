package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.CustomVanillaEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Efficiency9 extends CustomVanillaEnchant {
	public Efficiency9(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Efficiency9(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void apply(ItemStack itemInteractedWith, Player player) {
		if (itemInteractedWith.getItemMeta().hasEnchant(Enchantment.DIG_SPEED)) {
			if (itemInteractedWith.getItemMeta().getEnchantLevel(Enchantment.DIG_SPEED) >= 9)
				return;
		}
		itemInteractedWith.removeEnchantment(Enchantment.DIG_SPEED);
		itemInteractedWith.addUnsafeEnchantment(Enchantment.DIG_SPEED, 9);
		player.sendMessage(Messages.itemSuccess.get());
		player.setItemOnCursor(null);
	}
}
