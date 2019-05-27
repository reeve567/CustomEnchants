package pw.xwy.customenchants.utilities.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.RealName;

public class SpeedCheck implements Runnable {
	
	private JavaPlugin main;
	
	public SpeedCheck(JavaPlugin main) {
		
		this.main = main;
		run();
	}
	
	int ItemCheck(ItemStack i) {
		
		if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(RealName.WINDSSPEEDI.getEnchant().getName())) {
			return 1;
		} else if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(RealName.WINDSSPEEDII.getEnchant().getName())) {
			return 2;
		}
		return 0;
	}
	
	@Override
	public void run() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(main, () -> {
			if (Bukkit.getOnlinePlayers().size() > 0) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (ItemCheck(p.getInventory().getBoots()) == 1) {
						((CustomTaskEnchant) RealName.WINDSSPEEDI.getEnchant()).event(p);
					} else if (ItemCheck(p.getInventory().getBoots()) == 2) {
						((CustomTaskEnchant) RealName.WINDSSPEEDII.getEnchant()).event(p);
					}
				}
			}
		}, 0, 40);
	}
	
}
