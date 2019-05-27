package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.obj.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Miner2 extends CustomDamageEnchant {
	public Miner2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Miner2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		e.setDamage(e.getDamage() * 3);
	}
}
