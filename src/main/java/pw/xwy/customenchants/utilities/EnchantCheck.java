package pw.xwy.customenchants.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.enchant_objects.ECustomTaskEnchant;

public class EnchantCheck {

	private int tick;
	
	public EnchantCheck(JavaPlugin plugin) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,() -> {
			if (!Bukkit.getOnlinePlayers().isEmpty()) {
				tick += 5;
				for (Player p: Bukkit.getOnlinePlayers()) {
					for (ECustomTaskEnchant taskEnchant: ECustomTaskEnchant.values()) {
						if (tick % taskEnchant.getTickWait() == 0) {
							if (taskEnchant.check(p)) {
								taskEnchant.event(p);
							}
						}
					}
				}
			}
		},0,5);
	}

}
