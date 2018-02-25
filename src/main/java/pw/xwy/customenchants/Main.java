////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.commands.CommandHandler;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.enums.Messages;
import pw.xwy.customenchants.listeners.ListenerHandler;
import pw.xwy.customenchants.menus.SwordMenu;
import pw.xwy.customenchants.schedules.*;
import pw.xwy.customenchants.utilities.ConfigCheck;
import pw.xwy.customenchants.utilities.Glow;
import pw.xwy.customenchants.utilities.MessagesFunctions;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	private static Main main;
	private static Economy econ = null;
	public static int ceCount;
	private CommandHandler commandHandler;
	
	public static Economy getEcononomy() {
		return econ;
	}
	
	public static Main getMain() {
		return main;
	}
	
	private void registerGlow() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Glow glow = new Glow(70);
			Enchantment.registerEnchantment(glow);
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			System.out.println(1);
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			System.out.println(2);
			return false;
		}
		econ = rsp.getProvider();
		System.out.println(3);
		return econ != null;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		commandHandler.command(sender, command, label, args);
		return true;
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "<-------------------------------------->");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + getDescription().getName() + " Disabled.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + getDescription().getName() + " made by Xwy.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Current Version: " + ChatColor.GRAY + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "<-------------------------------------->");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		
	}
	
	@Override
	public void onEnable() {
		
		if (!setupEconomy()) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		new MessagesFunctions(this);
		new SwordMenu();
		ListenerHandler listnerHandler = new ListenerHandler(this);
		commandHandler = new CommandHandler();
		commandHandler.Init();
		main = this;
		listnerHandler.Init();
		registerGlow();
		new WaterBreathing(this);
		new NightVision(this);
		new HeartCheck(this);
		new ValorCheck(this);
		new FlashCheck(this);
		new JumpBoost(this);
		new Speed(this);
		ConfigCheck configCheck = new ConfigCheck(this);
		if (configCheck.Init()) {
			System.out.println("setup completed");
		}
		
		int ce = 0;
		
		int sword = 0;
		int axe = 0;
		int pick = 0;
		int bow = 0;
		int helm = 0;
		int chest = 0;
		int leggings = 0;
		int boots = 0;
		
		for (Enchants c : Enchants.values()) {
			if (c.getAmount() > 0) {
				ce += c.getAmount();
				if (c.checkSets(Material.DIAMOND_SWORD)) {
					sword++;
				}
				if (c.checkSets(Material.DIAMOND_AXE)) {
					axe++;
				}
				if (c.checkSets(Material.DIAMOND_PICKAXE)) {
					pick++;
				}
				if (c.checkSets(Material.BOW)) {
					bow++;
				}
				if (c.checkSets(Material.DIAMOND_HELMET)) {
					helm++;
				}
				if (c.checkSets(Material.DIAMOND_CHESTPLATE)) {
					chest++;
				}
				if (c.checkSets(Material.DIAMOND_LEGGINGS)) {
					leggings++;
				}
				if (c.checkSets(Material.DIAMOND_BOOTS)) {
					boots++;
				}
			}
		}
		
		if (Bukkit.getOnlinePlayers().size() > 0) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.hasPermission("Xwy.ce.notify")) {
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "«" + ChatColor.STRIKETHROUGH + "------------------------------" + ChatColor.GRAY + "" + ChatColor.BOLD + "»");
					p.sendMessage("");
					p.sendMessage(Messages.mainPre.get() + ChatColor.GOLD + "CustomEnchants " + ChatColor.GRAY + "has been loaded.");
					p.sendMessage(Messages.mainPre.get() + ChatColor.GRAY + "This plugin was made by " + ChatColor.GOLD + "Xwy" + ChatColor.GRAY + ", if you got it from someone else, notify the source in case they are not aware this is a premium plugin.");
					p.sendMessage(Messages.mainPre.get() + ChatColor.GRAY + "Current version: " + ChatColor.GOLD + getDescription().getVersion());
					p.sendMessage("");
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "«" + ChatColor.STRIKETHROUGH + "------------------------------" + ChatColor.GRAY + "" + ChatColor.BOLD + "»");
					p.sendMessage(Messages.mainPre.get() + ChatColor.GOLD + "CustomEnchants" + ChatColor.GRAY + " has been loaded with " + ce + " enchants.");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + sword + " sword");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + bow + " bow");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + axe + " axe");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + pick + " pickaxe");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + helm + " helmet");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + chest + " chestplate");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + leggings + " legging");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + boots + " boot");
					p.sendMessage(Messages.mainPre.get() + ChatColor.RED + "" + (ceCount = sword + bow + axe + pick + helm + chest + leggings + boots) + " total");
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "«" + ChatColor.STRIKETHROUGH + "------------------------------" + ChatColor.GRAY + "" + ChatColor.BOLD + "»");
				}
			}
		}
		
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "<-------------------------------------->");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + getDescription().getName() + " Enabled.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + getDescription().getName() + " made by Xwy.");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Current Version: " + ChatColor.GRAY + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "<-------------------------------------->");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("");
		
	}
}
