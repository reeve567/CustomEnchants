package pw.xwy.customenchants.schedules;
// made by reeve
// on 10:36 PM

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.enums.Enchants;

public class Speed implements Runnable {
	
	private JavaPlugin main;
	
	public Speed(JavaPlugin main) {
		
		this.main = main;
		run();
	}
	
	int ItemCheck(ItemStack i) {
		
		if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(Enchants.WINDSSPEEDI.getName())) {
			return 1;
		} else if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(Enchants.WINDSSPEEDII.getName())) {
			return 2;
		}
		return 0;
	}
	
	
	@Override
	public void run() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			@Override
			public void run() {
				
				if (Bukkit.getOnlinePlayers().size() > 0) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (ItemCheck(p.getInventory().getBoots()) == 1) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
						} else if (ItemCheck(p.getInventory().getBoots()) == 2) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1));
						}
					}
				}
			}
		}, 20L, 0);
	}
	
}
