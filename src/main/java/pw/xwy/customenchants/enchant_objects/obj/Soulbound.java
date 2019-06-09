package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.CustomDeathEnchant;
import pw.xwy.customenchants.RealName;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Soulbound extends CustomDeathEnchant {

	public HashMap<Player, List<ItemStack>> keptItems = new HashMap<>();

	public Soulbound(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}

	@Override
	public void event(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}

		List<ItemStack> keeps = new ArrayList<>();
		Iterator<ItemStack> iter = e.getDrops().iterator();
		while (iter.hasNext()) {
			ItemStack i = iter.next();
			if (i.hasItemMeta() && i.getItemMeta().hasLore()) {
				if (i.getItemMeta().getLore().contains(RealName.SOULBOUND.getEnchant().getName())) {
					if (EnchantDrop.getRandomNumberFrom(1, 100) <= 10) {
						keeps.add(i);
						iter.remove();
					}
				}
			}
		}
		keptItems.put((Player) e.getEntity(), keeps);
	}

}
