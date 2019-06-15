package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomDamageEnchantLoader {
	private List<ACustomDamageEnchant> customDamageEnchants = new ArrayList<>();

	public CustomDamageEnchantLoader() {
		customDamageEnchants.addAll(Arrays.asList(
				new ACustomDamageEnchant("Antiknockback I", ItemSets.LEGGINGS, Rarity.UNCOMMON, "This enchantment reduces the amount of knockback you take.", Material.FIREWORK_STAR) {
					@Override //TODO: RECODE
					public void event(EntityDamageByEntityEvent e) {
						Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> {
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.75);
							e.getEntity().setVelocity(kb);
						}, 2);
					}
				},
				new ACustomDamageEnchant("Antiknockback II", ItemSets.LEGGINGS, Rarity.RARE, "This enchantment reduces the amount of knockback you take.", Material.FIREWORK_STAR) {
					@Override //TODO: RECODE
					public void event(EntityDamageByEntityEvent e) {
						Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> {
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.5);
							e.getEntity().setVelocity(kb);
						}, 2);
					}
				},
				new ACustomDamageEnchant("Antiknockback III", ItemSets.LEGGINGS, Rarity.MYSTICAL, "This enchantment reduces the amount of knockback you take.", Material.FIREWORK_STAR) {
					@Override //TODO: RECODE
					public void event(EntityDamageByEntityEvent e) {
						Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> {
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.25);
							e.getEntity().setVelocity(kb);
						}, 2);
					}
				}
		));
	}

	public List<ACustomDamageEnchant> getCustomDamageEnchants() {
		return customDamageEnchants;
	}
}
