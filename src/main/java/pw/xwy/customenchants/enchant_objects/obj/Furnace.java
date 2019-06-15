package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import pw.xwy.customenchants.enchant_objects.CustomBowDeathEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class Furnace extends CustomBowDeathEnchant {
	public Furnace(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public Furnace(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
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
	
	@Override
	public void event(EntityDeathEvent e) {
		Entity killed = e.getEntity();
		EntityDamageEvent ev_killed = killed.getLastDamageCause(); // We need to find the last cause of damage before the death.
		if (ev_killed instanceof EntityDamageByEntityEvent) { // If it is a Entity, who killed him, the Event can be casted.
			EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) ev_killed;
			if (event.getDamager().hasMetadata("Furnace")) {
				changeDrops(e);
			}
		}
	}
	
	@Override
	public void launch(ProjectileLaunchEvent e) {
		e.getEntity().setMetadata("Furnace", new FixedMetadataValue(CustomEnchants.instance, ((Player) e.getEntity().getShooter()).getName()));
	}
	
}
