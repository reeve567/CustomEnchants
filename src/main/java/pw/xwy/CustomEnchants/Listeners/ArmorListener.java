package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 9:00 PM

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import pw.xwy.CustomEnchants.Enums.CustomEnchants;

public class ArmorListener implements Listener {

	@EventHandler
	public void onDamage(PlayerItemDamageEvent e) {

		if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore()) {
			for (String s:e.getItem().getItemMeta().getLore()) {
				if (s.equalsIgnoreCase(CustomEnchants.UNSTABLEI.getName())) {
					int n = EnchantDrop.getRandomNumberFrom(1,100);
					if (n <= 20) {
						e.setCancelled(true);
					}
				}
				else if (s.equalsIgnoreCase(CustomEnchants.UNSTABLEII.getName())) {
					int n = EnchantDrop.getRandomNumberFrom(1,100);
					if (n <= 40) {
						e.setCancelled(true);
					}
				}
			}
		}
	}

}
