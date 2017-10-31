package pw.xwy.CustomEnchants.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pw.xwy.CustomEnchants.Commands.AdminCommands.CeGive;
import pw.xwy.CustomEnchants.Commands.PlayerCommands.CeMenu;

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
					ceGive.run(sender,args);
				}
			}
			else
				ceMenu.run(sender);
		}
	}
}
