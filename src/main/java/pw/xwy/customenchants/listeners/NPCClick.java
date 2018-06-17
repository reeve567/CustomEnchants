////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 6/17/18 2:08 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.listeners;

import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pw.xwy.customenchants.menus.MainMenu;

public class NPCClick implements Listener {
	
	@EventHandler
	public void onRightClick(NPCRightClickEvent e) {
		onClick(e);
	}
	
	@EventHandler
	public void onLeftClick(NPCLeftClickEvent e) {
		onClick(e);
	}
	
	private void onClick(NPCClickEvent e) {
		if (e.getNPC().getName().contains("CE Menu") || e.getNPC().getName().contains("CustomEnchants")) {
			e.getClicker().openInventory(MainMenu.get());
		}
	}
	
}
