package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.CustomVanillaEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Fortune5 extends CustomVanillaEnchant {
	public Fortune5(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Fortune5(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void apply(ItemStack itemInteractedWith, Player player) {
		if (itemInteractedWith.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
			if (itemInteractedWith.getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS) == 5)
				return;
		}
		itemInteractedWith.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
		itemInteractedWith.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
		player.setItemOnCursor(null);
		player.sendMessage(Messages.itemSuccess.get());
		
	}
}
