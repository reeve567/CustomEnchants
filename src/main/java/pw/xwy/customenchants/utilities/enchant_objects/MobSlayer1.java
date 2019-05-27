package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import pw.xwy.customenchants.obj.CustomDeathEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class MobSlayer1 extends CustomDeathEnchant {
	public MobSlayer1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public MobSlayer1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDeathEvent e) {
		e.setDroppedExp(e.getDroppedExp() * 2);
	}
}
