package pw.xwy.CustomEnchants.Commands.PlayerCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pw.xwy.CustomEnchants.Enums.Messages;
import pw.xwy.CustomEnchants.Menu.MainMenu;

// made by reeve
// on 5:29 PM
public class CeMenu {


	public void run(CommandSender sender) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Inventory inv = MainMenu.get();
			player.openInventory(inv);
		}
		else
			sender.sendMessage(Messages.senderIsConsole.get());
	}
}
