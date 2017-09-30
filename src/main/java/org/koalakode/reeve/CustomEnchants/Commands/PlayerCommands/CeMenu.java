package org.koalakode.reeve.CustomEnchants.Commands.PlayerCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.koalakode.reeve.CustomEnchants.Enums.Messages;
import org.koalakode.reeve.CustomEnchants.Menu.MainMenu;

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
