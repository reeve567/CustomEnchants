package org.koalakode.reeve.CustomEnchants.Listeners;
// made by reeve
// on 12:56 AM

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

import java.util.ArrayList;
import java.util.List;

public class SprintListener implements Listener {

	static List<Player> sprinting = new ArrayList<Player>();


	@EventHandler
	public void onToggle(PlayerToggleSprintEvent e) {
		if (e.isSprinting()) {
			if (!sprinting.contains(e.getPlayer())) {
				sprinting.add(e.getPlayer());
			}
		}
		else {
			if (sprinting.contains(e.getPlayer())) {
				sprinting.remove(e.getPlayer());
			}
		}
	}

}
