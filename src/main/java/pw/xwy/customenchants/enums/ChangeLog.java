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
import pw.xwy.customenchants.CustomEnchants;

import java.util.ArrayList;
import java.util.List;

public enum ChangeLog {
	TOP(""),
	LINE1("&7Current Version: &d" + CustomEnchants.getCustomEnchants().getDescription().getVersion()),
	LINE2("&7Enchants Enabled: &d" + CustomEnchants.ceCount),
	LINE3("&7Latest Update: &7Redid menu system inner workings, and added a disable enchants feature-"),
	BOTTOM("");
	private String changes;
	
	ChangeLog(String s) {
		changes = s;
	}
	
	public static List<String> getStrings() {
		ArrayList<String> strings = new ArrayList<>();
		for (ChangeLog changeLog : ChangeLog.values()) {
			strings.add(changeLog.get());
		}
		return strings;
	}
	
	public String get() {
		return ChatColor.translateAlternateColorCodes('&', changes);
	}
}
