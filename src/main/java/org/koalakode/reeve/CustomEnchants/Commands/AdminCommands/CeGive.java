package org.koalakode.reeve.CustomEnchants.Commands.AdminCommands;
// made by reeve
// on 12:32 PM

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.koalakode.reeve.CustomEnchants.Enums.CustomEnchants;
import org.koalakode.reeve.CustomEnchants.Enums.Messages;
import org.koalakode.reeve.CustomEnchants.Enums.Souls;
import org.koalakode.reeve.CustomEnchants.Listeners.EnchantDrop;

import java.util.ArrayList;
import java.util.List;

import static org.koalakode.reeve.CustomEnchants.Util.MainUtil.bookGive;
import static org.koalakode.reeve.CustomEnchants.Util.MainUtil.cmdCheck;

public class CeGive {

	public void run(CommandSender sender, String[] args) {
		if (sender.hasPermission("ce.admin")) {
			if (args.length >= 3) {
				Player target = null;
				for (Player p: Bukkit.getOnlinePlayers()) {
					if (p.getName().equalsIgnoreCase(args[2])) {
						target = p;
					}
				}
				if (target != null) {
					boolean found = false;

					for (CustomEnchants e: CustomEnchants.values()) {
						if (cmdCheck(e.getLabel(),args[1])) {
							found = true;
							target.getInventory().addItem(bookGive(args[1],false));
							sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have given " + e.getName() + ChatColor.GRAY + " to " +
									                   ChatColor.RED + target.getName());
						}
					}
					for (Souls s: Souls.values()) {
						if (cmdCheck(s.getCommandLabel(),args[1])) {
							found = true;
							target.getInventory().addItem(s.getItem());
							sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have given " + s.getName() + ChatColor.GRAY + " to " +
									                   ChatColor.RED + target.getName());
						}
					}


					if (!found) {
						sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Unknown enchantment: " + args[1]);
					}
				}
				else
					sender.sendMessage(ChatColor.RED + "Player " + ChatColor.AQUA + args[2] + " not found.");
			}
			else if (args.length == 2) {
				if (sender instanceof Player) {
					boolean found = false;
					for (CustomEnchants e : CustomEnchants.values()) {
						if (cmdCheck(e.getLabel(), args[1])) {
							found = true;
							((Player) sender).getInventory().addItem(bookGive(args[1],false));
							sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have received: " + e.getName());
						}
					}
					for (Souls s: Souls.values()) {
						if (cmdCheck(s.getCommandLabel(),args[1])) {
							found = true;
							((Player) sender).getInventory().addItem(s.getItem());
							sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have received: " + s.getName());
						}
					}

					if (!found) {
						sender.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Unknown enchantment/soul: " + args[1]);
					}
				}
				else {
					sender.sendMessage(Messages.senderIsConsole.get());
				}
			}
			else {
				if (sender instanceof Player) {
					sender.sendMessage(ChatColor.GRAY + "/ce give" + ChatColor.RED + " <enchant> [player]");
				}
				else {
					sender.sendMessage(Messages.senderIsConsole.get());
				}
			}
		}
	}



}
