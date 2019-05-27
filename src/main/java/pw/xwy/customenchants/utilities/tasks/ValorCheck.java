package pw.xwy.customenchants.utilities.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.obj.CustomTaskEnchant;
import pw.xwy.customenchants.RealName;

public class ValorCheck implements Runnable {
	
	private JavaPlugin main;
	
	public ValorCheck(JavaPlugin main) {
		
		this.main = main;
	}
	
	private boolean ItemCheck(ItemStack i) {
		return i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(RealName.VALOR.getEnchant().getName());
	}
	
	@Override
	public void run() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(main, () -> {
			
			if (Bukkit.getOnlinePlayers().size() > 0) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (ItemCheck(p.getInventory().getHelmet()) &&
							ItemCheck(p.getInventory().getChestplate()) &&
							ItemCheck(p.getInventory().getLeggings()) &&
							ItemCheck(p.getInventory().getBoots())) {
						((CustomTaskEnchant) RealName.VALOR.getEnchant()).event(p);
					}
				}
			}
		}, 0, 40);
	}
}
