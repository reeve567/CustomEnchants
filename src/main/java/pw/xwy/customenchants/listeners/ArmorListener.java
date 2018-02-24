////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.listeners;
// made by reeve
// on 9:00 PM

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import pw.xwy.customenchants.enums.Enchants;

public class ArmorListener implements Listener {
	
	@EventHandler
	public void onDamage(PlayerItemDamageEvent e) {
		
		if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore()) {
			for (String s : e.getItem().getItemMeta().getLore()) {
				if (s.equalsIgnoreCase(Enchants.UNSTABLEI.getName())) {
					int n = EnchantDrop.getRandomNumberFrom(1, 100);
					if (n <= 20) {
						e.setCancelled(true);
					}
				} else if (s.equalsIgnoreCase(Enchants.UNSTABLEII.getName())) {
					int n = EnchantDrop.getRandomNumberFrom(1, 100);
					if (n <= 40) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
}
