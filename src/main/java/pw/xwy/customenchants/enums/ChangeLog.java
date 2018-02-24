////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.enums;

import org.bukkit.ChatColor;
import pw.xwy.customenchants.Main;

public enum ChangeLog {
	LINE1("&7Current Version: &d" + Main.getMain().getDescription().getVersion()),
	LINE2("&7Enchants Enabled: &d" + Main.getMain().ceCount),
	LINE3("&7Latest Update: &7Redid menu system inner workings, and added a disable enchants feature");
	
	private String changes;
	
	ChangeLog(String s) {
		changes = s;
	}
	
	
	public String get() {
		return ChatColor.translateAlternateColorCodes('&', changes);
	}
}
