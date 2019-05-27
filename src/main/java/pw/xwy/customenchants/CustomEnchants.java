////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.obj.Config;
import pw.xwy.customenchants.obj.CustomEnchant;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.gui.ConversionMenu;
import pw.xwy.customenchants.utilities.item.Glow;
import pw.xwy.customenchants.utilities.menu.*;
import pw.xwy.customenchants.utilities.tasks.*;

import java.lang.reflect.Field;

public class CustomEnchants extends JavaPlugin {
	
	public static int ceCount;
	public static CustomEnchantManager manager;
	public static CustomEnchants instance;
	
	public CustomEnchants() {
		instance = this;
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
	
	private void registerGlow() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (Enchantment.isAcceptingRegistrations())
				if (Enchantment.getByName("Glow") != null) {
					Glow glow = new Glow(99);
					Enchantment.registerEnchantment(glow);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void startTasks() {
		new WaterBreathingCheck(this);
		new NightVisionCheck(this);
		new HeartCheck(this);
		new ValorCheck(this);
		new FlashCheck(this);
		new JumpBoostCheck(this);
		new SpeedCheck(this);
	}
	
	public void onEnable() {
		registerGlow();
		
		new MessagesFunctions();
		Config config = new Config(getDataFolder(), "custom-enchants");
		int sword = 0;
		int axe = 0;
		int pick = 0;
		int bow = 0;
		int helm = 0;
		int chest = 0;
		int leggings = 0;
		int boots = 0;
		
		boolean newf = false;
		if (config.getInt("ver") != 1) {
			newf = true;
			config.set("ver", 1);
			config.saveConfig();
		}
		
		manager = new CustomEnchantManager();
		
		for (CustomEnchant c : manager.getEnchantsByRealName().values()) {
			if (newf)
				c.saveDefault(config);
			else
				c.setCustomStuff(config);
			
			if (c.isEnabled()) {
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
		config.saveConfig();
		
		if (Bukkit.getOnlinePlayers().size() > 0) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.hasPermission("Xwy.menu.notify")) {
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "«" + ChatColor.STRIKETHROUGH + "------------------------------" + ChatColor.GRAY + "" + ChatColor.BOLD + "»");
					p.sendMessage(Messages.mainPre.get() + "§6CustomEnchants" + ChatColor.GRAY + " have been loaded with " + (ceCount = sword + bow + axe + pick + helm + chest + leggings + boots) + " enchants.");
					p.sendMessage(Messages.mainPre.get() + "§c" + sword + " sword");
					p.sendMessage(Messages.mainPre.get() + "§c" + bow + " bow");
					p.sendMessage(Messages.mainPre.get() + "§c" + axe + " axe");
					p.sendMessage(Messages.mainPre.get() + "§c" + pick + " pickaxe");
					p.sendMessage(Messages.mainPre.get() + "§c" + helm + " helmet");
					p.sendMessage(Messages.mainPre.get() + "§c" + chest + " chestplate");
					p.sendMessage(Messages.mainPre.get() + "§c" + leggings + " legging");
					p.sendMessage(Messages.mainPre.get() + "§c" + boots + " boot");
					p.sendMessage(Messages.mainPre.get() + "§c" + ceCount + " total");
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "«" + ChatColor.STRIKETHROUGH + "------------------------------" + ChatColor.GRAY + "" + ChatColor.BOLD + "»");
				}
			}
		}
		startTasks();
		loadMenus();
		Bukkit.getPluginManager().registerEvents(new ConversionMenu(), this);
		new CustomEnchantsCommand();
	}
	
}
