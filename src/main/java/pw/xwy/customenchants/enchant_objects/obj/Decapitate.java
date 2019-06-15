package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.CustomDeathEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.utils.PlayerSkull;

import java.util.List;

public class Decapitate extends CustomDeathEnchant {

	public Decapitate(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public Decapitate(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	@Override
	// TODO: Setup for entities, and add chance
	public void event(EntityDeathEvent e) {

		if (e.getEntity() instanceof Player) {
			List<ItemStack> drops = e.getDrops();
			drops.add(new PlayerSkull((Player) e.getEntity()));
		}
	}
}
