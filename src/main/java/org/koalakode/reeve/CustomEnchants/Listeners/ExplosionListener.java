package org.koalakode.reeve.CustomEnchants.Listeners;
// made by reeve
// on 9:34 PM

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionListener implements Listener {

	@EventHandler
	public void onExplode(BlockExplodeEvent e) {
		if (HitListener.playerMadeExplosion) {
			e.blockList().clear();
			HitListener.playerMadeExplosion = false;
		}
	}

}
