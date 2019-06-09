package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class GuardiansBlock extends CustomDamageEnchant {
	public GuardiansBlock(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public GuardiansBlock(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (((Player) e.getEntity()).isBlocking())
			e.setDamage(e.getDamage() / 2);
	}
}
