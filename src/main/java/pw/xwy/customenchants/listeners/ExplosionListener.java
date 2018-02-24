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
// on 9:34 PM

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class ExplosionListener implements Listener {
	
	@EventHandler
	public void onExplode(BlockExplodeEvent e) {
		if (HitListener.playerMadeExplosion) {
			e.blockList().clear();
			HitListener.playerMadeExplosion = false;
		}
	}
	
}
