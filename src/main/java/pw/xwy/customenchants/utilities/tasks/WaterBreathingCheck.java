package pw.xwy.customenchants.utilities.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.RealName;

public class WaterBreathingCheck implements Runnable {

	private JavaPlugin main;

	public WaterBreathingCheck(JavaPlugin main) {
		this.main = main;
		run();
	}

	@Override
	public void run() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(main, () -> {
			if (Bukkit.getOnlinePlayers().size() > 0) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (ItemCheck(p.getInventory().getHelmet())) {
						((CustomTaskEnchant) RealName.SCUBADIVER.getEnchant()).event(p);
					}
				}
			}
		}, 0, 40);
	}

	boolean ItemCheck(ItemStack i) {
		if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(RealName.SCUBADIVER.getEnchant().getName())) {
			return true;
		}
		return false;
	}
}
