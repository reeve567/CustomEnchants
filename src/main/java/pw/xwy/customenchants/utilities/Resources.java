////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 10:26 PM                            /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.utilities;

import org.bukkit.ChatColor;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {
	
	public static String getMenu(String s) {
		ResourceBundle bundle = ResourceBundle.getBundle("menu", Locale.getDefault());
		return ChatColor.translateAlternateColorCodes('&', bundle.getString(s));
	}
	
}
