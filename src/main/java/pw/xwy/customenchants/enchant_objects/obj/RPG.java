package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import pw.xwy.customenchants.enchant_objects.CustomBowEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.listeners.DamageListener;
import pw.xwy.customenchants.listeners.EnchantDrop;

public class RPG extends CustomBowEnchant {
	public RPG(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public RPG(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof Player) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.hasMetadata("RPG")) {
				int num = EnchantDrop.getRandomNumberFrom(1, 100);
				if (num <= 15) {
					DamageListener.playerMadeExplosion = true;
					e.getEntity().getLocation().getWorld().createExplosion(e.getEntity().getLocation(), 5);
				}
			}
		}
	}
	
	@Override
	public void launch(ProjectileLaunchEvent e) {
	
	}
}
