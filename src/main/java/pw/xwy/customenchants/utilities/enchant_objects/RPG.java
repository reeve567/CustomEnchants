package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import pw.xwy.customenchants.obj.CustomBowEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.listeners.DamageListener;
import pw.xwy.customenchants.listeners.EnchantDrop;

public class RPG extends CustomBowEnchant {
	public RPG(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public RPG(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
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
