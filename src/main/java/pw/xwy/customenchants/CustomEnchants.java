package pw.xwy.customenchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;
import pw.xwy.customenchants.enchant_objects.Config;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.gui.ConversionMenu;
import pw.xwy.customenchants.utilities.gui.MainMenu;

import java.lang.reflect.Field;

public class CustomEnchants extends JavaPlugin {

	public static CustomEnchantManager manager;
	public static CustomEnchants instance;

	public CustomEnchants() {
		instance = this;
	}

	private void registerGlow() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onEnable() {
		registerGlow();

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

		for (ACustomEnchant c : manager.getEnchantsByRealName().values()) {
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

		if (!Bukkit.getOnlinePlayers().isEmpty()) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.hasPermission("Xwy.menu.notify")) {
					p.sendMessage("§7§l«§m------------------------------§7§l»");
					int ceCount = sword + bow + axe + pick + helm + chest + leggings + boots;
					p.sendMessage(Messages.mainPre.get() + "§6CustomEnchants" + ChatColor.GRAY + " have been loaded with " + ceCount + " enchants.");
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
		loadMenus();
		new CustomEnchantsCommand();
	}

	private void loadMenus() {
		MainMenu mainMenu = new MainMenu(this);
		ConversionMenu conversionMenu = new ConversionMenu(this);
		mainMenu.setItems();
		conversionMenu.setItems();
	}

}
