package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 4:27 PM

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.CustomEnchants.Enums.CEnchant;

import java.util.List;

public class FeedListener implements Listener {
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			ItemStack legs = player.getInventory().getLeggings();
			if (legs != null) {
				if (legs.hasItemMeta()) {
					if (legs.getItemMeta().hasLore()) {
						List<String> lore = legs.getItemMeta().getLore();
						if (lore.contains(CEnchant.AUTOFEEDER.getName())) {
							e.setFoodLevel(20);
						}
					}
				}
			}
		}
	}
	
}
