package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Molten extends CustomDamageEnchant {
	public Molten(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Molten(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() instanceof Skeleton) {
				Skeleton sk = (Skeleton) arrow.getShooter();
				sk.setFireTicks(e.getDamager().getFireTicks() + 100);

			} else if (arrow.getShooter() instanceof Player) {
				Player pl = (Player) arrow.getShooter();
				pl.setFireTicks(e.getDamager().getFireTicks() + 100);
			}
		} else {
			e.getDamager().setFireTicks(e.getDamager().getFireTicks() + 100);
		}
	}
}
