package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.FixedMetadataValue;
import pw.xwy.customenchants.enchant_objects.CustomBowEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.customenchants.listeners.EnchantDrop;

public class Voltage extends CustomBowEnchant {
	public Voltage(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public Voltage(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	@Override
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof Player) {
			Arrow arrow = (Arrow) e.getDamager();
			Player p = (Player) arrow.getShooter();
			if (arrow.hasMetadata("Voltage")) {
				int num = EnchantDrop.getRandomNumberFrom(1, 100);
				if (num <= 20) {
					e.getEntity().getLocation().getWorld().strikeLightning(e.getEntity().getLocation());
					e.getDamager().sendMessage(Messages.smited.get());
				}
			}
		}
	}
	
	@Override
	public void launch(ProjectileLaunchEvent e) {
		e.getEntity().setMetadata("Voltage", new FixedMetadataValue(CustomEnchants.instance, ((Player) e.getEntity().getShooter()).getName()));
	}
}
