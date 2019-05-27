package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import pw.xwy.customenchants.obj.CustomEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Autofeeder extends CustomEnchant {
	public Autofeeder(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Autofeeder(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	public void event(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}
}
