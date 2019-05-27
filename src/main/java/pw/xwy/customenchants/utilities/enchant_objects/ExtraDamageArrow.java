package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.FixedMetadataValue;
import pw.xwy.customenchants.obj.CustomBowEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.listeners.EnchantDrop;

public class ExtraDamageArrow extends CustomBowEnchant {
	public ExtraDamageArrow(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public ExtraDamageArrow(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof Player) {
			Arrow arrow = (Arrow) e.getDamager();
			Player p = (Player) arrow.getShooter();
			if (arrow.hasMetadata("Explosive")) {
				int num = EnchantDrop.getRandomNumberFrom(1, 100);
				if (num <= 70) {
					e.setDamage(e.getDamage() * 2);
				}
			}
		}
	}
	
	@Override
	public void launch(ProjectileLaunchEvent e) {
		e.getEntity().setMetadata("Explosive", new FixedMetadataValue(CustomEnchants.instance, ((Player) e.getEntity().getShooter()).getName()));
	}
}
