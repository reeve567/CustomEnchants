package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import pw.xwy.customenchants.enchant_objects.CustomDeathEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class MobSlayer2 extends CustomDeathEnchant {
	public MobSlayer2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public MobSlayer2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDeathEvent e) {
		e.setDroppedExp(e.getDroppedExp() * 3);
	}
}
