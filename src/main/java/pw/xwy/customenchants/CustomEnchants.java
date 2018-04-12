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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.factions.XFactionsCore;
import pw.xwy.customenchants.commands.CommandHandler;
import pw.xwy.customenchants.enums.CEnchant;
import pw.xwy.customenchants.enums.Messages;
import pw.xwy.customenchants.listeners.ListenerHandler;
import pw.xwy.customenchants.menus.*;
import pw.xwy.customenchants.schedules.*;
import pw.xwy.customenchants.soulcrates.*;
import pw.xwy.customenchants.utilities.ConfigCheck;
import pw.xwy.customenchants.utilities.Glow;
import pw.xwy.customenchants.utilities.MessagesFunctions;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class CustomEnchants extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");
	public static int ceCount;
	private static CustomEnchants customEnchants;
	private static Economy econ = null;
	public static boolean useFactions;
	private CommandHandler commandHandler;
	
	public static CustomEnchants getCustomEnchants() {
		return customEnchants;
	}
	
	public static Economy getEcononomy() {
		return econ;
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
		
		useFactions = useFactions();
		
		new MessagesFunctions(this);
		ListenerHandler listnerHandler = new ListenerHandler(this);
		commandHandler = new CommandHandler();
		commandHandler.Init();
		customEnchants = this;
		listnerHandler.Init();
		registerGlow();
		loadCrates();
		disableEnchants();
		startTasks();
		loadMenus();
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
		
		for (CEnchant c : CEnchant.values()) {
			if (c.isEnabled() && c.getAmount() > 0) {
				ce += c.getAmount();
				if (c.checkSets(Material.DIAMOND_SWORD)) sword++;
				if (c.checkSets(Material.DIAMOND_AXE)) axe++;
				if (c.checkSets(Material.DIAMOND_PICKAXE)) pick++;
				if (c.checkSets(Material.BOW)) bow++;
				if (c.checkSets(Material.DIAMOND_HELMET)) helm++;
				if (c.checkSets(Material.DIAMOND_CHESTPLATE)) chest++;
				if (c.checkSets(Material.DIAMOND_LEGGINGS)) leggings++;
				if (c.checkSets(Material.DIAMOND_BOOTS)) boots++;
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
	
	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
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
		} catch (IllegalArgumentException ignored) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadCrates() {
		new HydroSC();
		new MysticalSC();
		new RareSC();
		new UncommonSC();
		new CommonSC();
	}
	
	private void disableEnchants() {
		final CEnchant[] toDisable = {};
		for (CEnchant ce : toDisable) {
			ce.disable();
		}
	}
	
	private void startTasks() {
		if (CEnchant.SCUBADIVER.isEnabled()) new WaterBreathing(this);
		if (CEnchant.GLOWING.isEnabled()) new NightVision(this);
		if (CEnchant.HEARTBOOST.isEnabled()) new HeartCheck(this);
		if (CEnchant.VALOR.isEnabled()) new ValorCheck(this);
		if (CEnchant.FLASH.isEnabled()) new FlashCheck(this);
		if (CEnchant.MOONGRAVITY.isEnabled()) new JumpBoost(this);
		if (CEnchant.WINDSSPEEDI.isEnabled() || CEnchant.WINDSSPEEDII.isEnabled()) new Speed(this);
	}
	
	private void loadMenus() {
		new AxeMenu();
		new BootsMenu();
		new BowMenu();
		new ChestMenu();
		new HelmMenu();
		new LeggingsMenu();
		new PickMenu();
		new SwordMenu();
	}
	
	private boolean useFactions() {
		try {
			Plugin plugin = Bukkit.getPluginManager().getPlugin("XFactions-Core");
			if (plugin == null || !(plugin instanceof XFactionsCore)) {
				return false;
			}
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}
}
