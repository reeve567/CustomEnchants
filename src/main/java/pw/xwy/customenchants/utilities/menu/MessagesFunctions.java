package pw.xwy.customenchants.utilities.menu;

import org.bukkit.ChatColor;
import pw.xwy.customenchants.utilities.enums.Messages;

public class MessagesFunctions {
	
	
	public static String modeChanged(String mode) {
		return Messages.prefix.get() + ChatColor.GRAY + "Bow firing mode changed to " + ChatColor.GREEN + mode;
	}
	
}
