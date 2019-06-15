package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.CustomDeathEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class AnimalCooker extends CustomDeathEnchant {
	public AnimalCooker(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public AnimalCooker(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	@Override
	public void event(EntityDeathEvent e) {
		changeDrops(e);
	}

	private void changeDrops(EntityDeathEvent e) {

		for (ItemStack it : e.getDrops()) {
			if (it.getType().equals(Material.BEEF)) {
				it.setType(Material.COOKED_BEEF);
			} else if (it.getType().equals(Material.PORKCHOP)) {
				it.setType(Material.COOKED_PORKCHOP);
			} else if (it.getType().equals(Material.CHICKEN)) {
				it.setType(Material.COOKED_CHICKEN);
			}
		}
	}
}
