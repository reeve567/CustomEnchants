package org.koalakode.reeve.CustomEnchants.Schedules;
// made by reeve
// on 10:36 PM

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.koalakode.reeve.CustomEnchants.Enums.CustomEnchants;

public class NightVision implements Runnable {
	private JavaPlugin main;

	public NightVision(JavaPlugin main) {
		this.main = main;
		run();
	}

	boolean ItemCheck(ItemStack i) {

		if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(CustomEnchants.GLOWING.getName())) {
			return true;
		}
		return false;
	}


	@Override
	public void run() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			@Override
			public void run() {
				if (Bukkit.getOnlinePlayers().size() > 0) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (ItemCheck(p.getInventory().getHelmet())) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 40, 0));
						}
					}
				}
			}
		},20L,0);
	}

}