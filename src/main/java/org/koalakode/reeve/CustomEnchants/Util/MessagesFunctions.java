package org.koalakode.reeve.CustomEnchants.Util;
// made by reeve
// on 5:32 PM

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static org.koalakode.reeve.CustomEnchants.Enums.Messages.prefix;

public class MessagesFunctions {

	private JavaPlugin main;

	public MessagesFunctions(JavaPlugin main) {
		this.main = main;
	}

	public static String modeChanged(String mode) {
		return prefix.get() + ChatColor.GRAY + "Bow firing mode changed to " + ChatColor.GREEN + mode;
	}

}
