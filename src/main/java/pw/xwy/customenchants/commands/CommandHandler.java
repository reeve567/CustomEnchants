////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.xwy.Factions.objects.faction.XPlayer;
import pw.xwy.customenchants.commands.admin.CeGive;
import pw.xwy.customenchants.commands.player.CeMenu;
import pw.xwy.customenchants.enums.ChangeLog;

public class CommandHandler {
	
	private CeMenu ceMenu;
	private CeGive ceGive;
	
	private boolean argCheck(String sent) {
		return "give".equalsIgnoreCase(sent);
	}
	
	public void Init() {
		ceMenu = new CeMenu();
		ceGive = new CeGive();
	}
	
	public void command(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("ce")) {
			if (args.length > 0) {
				if (argCheck(args[0])) {
					ceGive.run(sender, args);
				} else if (args[0].equalsIgnoreCase("version")) {
					XPlayer player = XPlayer.getXPlayer((Player) sender);
					player.sendMessages(ChangeLog.getStrings());
				}
			} else ceMenu.run(sender);
		}
	}
}
