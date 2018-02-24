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
