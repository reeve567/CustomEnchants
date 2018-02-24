package pw.xwy.customenchants.schedules;
// made by reeve
// on 12:08 AM

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pw.xwy.customenchants.enums.Enchants;
import pw.xwy.customenchants.enums.Messages;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.Main;
import pw.xwy.customenchants.utilities.MainUtil;

import java.util.ArrayList;

public class RewardPlayer extends BukkitRunnable {
	
	private Inventory inv;
	private Player p;
	private Souls soul;
	private Economy econ;
	
	public RewardPlayer(Inventory inv, Player p, Souls soul) {
		econ = Main.getEcononomy();
		this.inv = inv;
		this.p = p;
		this.soul = soul;
	}
	
	
	@Override
	public void run() {
		ItemStack i = inv.getItem(13);
		if (i != null && i.hasItemMeta() && i.getItemMeta().hasDisplayName()) {
			if (inv.getName().equalsIgnoreCase(Rarities.COMMON.getLabel())) {
				
				if (i.getType().equals(Material.DOUBLE_PLANT)) {
					if (i.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "2500")) {
						econ.depositPlayer(p, 2500);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else if (i.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "5000")) {
						econ.depositPlayer(p, 5000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
				} else if (i.getType().equals(Material.MONSTER_EGG) ||
						i.getType().equals(Material.DIAMOND)) {
					p.getInventory().addItem(new ItemStack(i.getType(), i.getAmount(), i.getDurability()));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.BOOK)) {
					p.getInventory().addItem(MainUtil.bookGive(i.getItemMeta().getDisplayName(), false));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.MOB_SPAWNER)) {
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + p.getName() + " bat 1");
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.COMMON.getItem())) {
					p.getInventory().addItem(Souls.COMMON.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.UNCOMMON.getItem())) {
					p.getInventory().addItem(Souls.UNCOMMON.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.DIAMOND_AXE)) {
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE));
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_HOE));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.INK_SACK)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit shark " + p.getName());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				}
				
				
			} else if (inv.getName().equalsIgnoreCase(Rarities.UNCOMMON.getLabel())) {
				if (i.getType().equals(Material.MOB_SPAWNER)) {
					if (i.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ocelot Spawner")) {
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + p.getName() + " ocelot 1");
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else {
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + p.getName() + " pig 1");
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
					
				} else if (i.getType().equals(Material.DOUBLE_PLANT)) {
					if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "7500")) {
						econ.depositPlayer(p, 7500);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else if (i.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000")) {
						econ.depositPlayer(p, 10000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
					
				} else if (i.equals(soul.getItem())) {
					p.getInventory().addItem(soul.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.RARE.getItem())) {
					p.getInventory().addItem(Souls.RARE.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.BOOK)) {
					p.getInventory().addItem(MainUtil.bookGive(i.getItemMeta().getDisplayName(), false));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.HOPPER)) {
					p.getInventory().addItem(new ItemStack(Material.HOPPER, 2));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.MONSTER_EGG) || i.getType().equals(Material.EXP_BOTTLE)) {
					p.getInventory().addItem(new ItemStack(i.getType(), i.getAmount(), i.getDurability()));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.TNT)) {
					p.getInventory().addItem(new ItemStack(Material.TNT, 64));
					p.getInventory().addItem(new ItemStack(Material.DISPENSER, 5));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.INK_SACK)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit shark " + p.getName());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.EMERALD_ORE)) {
					p.getInventory().addItem(new ItemStack(Material.DIAMOND_ORE, 32));
					p.getInventory().addItem(new ItemStack(Material.EMERALD_ORE, 32));
					p.getInventory().addItem(new ItemStack(Material.IRON_ORE, 32));
					p.getInventory().addItem(new ItemStack(Material.GOLD_ORE, 32));
					p.getInventory().addItem(new ItemStack(Material.COAL_ORE, 32));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				}
				
			} else if (inv.getName().equalsIgnoreCase(Rarities.RARE.getLabel())) {
				if (i.getType().equals(Material.DOUBLE_PLANT)) {
					if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "15000")) {
						econ.depositPlayer(p, 15000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000")) {
						econ.depositPlayer(p, 10000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
					
				} else if (i.equals(soul.getItem())) {
					p.getInventory().addItem(soul.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.MYSTICAL.getItem())) {
					p.getInventory().addItem(Souls.MYSTICAL.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.UNCOMMON.getItem())) {
					p.getInventory().addItem(Souls.UNCOMMON.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.BOOK)) {
					p.getInventory().addItem(MainUtil.bookGive(i.getItemMeta().getDisplayName(), false));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.HOPPER)) {
					p.getInventory().addItem(new ItemStack(Material.HOPPER, 5));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.MONSTER_EGG) || i.getType().equals(Material.EXP_BOTTLE)) {
					p.getInventory().addItem(new ItemStack(i.getType(), i.getAmount(), i.getDurability()));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.TNT)) {
					p.getInventory().addItem(new ItemStack(Material.TNT, 64));
					p.getInventory().addItem(new ItemStack(Material.DISPENSER, 5));
					p.getInventory().addItem(new ItemStack(Material.DIODE, 5));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.INK_SACK)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit kraken " + p.getName());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.EMERALD)) {
					p.getInventory().addItem(new ItemStack(Material.DIAMOND, 32));
					p.getInventory().addItem(new ItemStack(Material.EMERALD, 32));
					p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 32));
					p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 32));
					p.getInventory().addItem(new ItemStack(Material.COAL, 32));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				}
			} else if (inv.getName().equalsIgnoreCase(Rarities.MYSTICAL.getLabel())) {
				if (i.getType().equals(Material.DOUBLE_PLANT)) {
					if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "17500")) {
						econ.depositPlayer(p, 17500);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "20000")) {
						econ.depositPlayer(p, 20000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
					
				} else if (i.equals(soul.getItem())) {
					p.getInventory().addItem(soul.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.RARE.getItem())) {
					p.getInventory().addItem(Souls.RARE.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.equals(Souls.UNCOMMON.getItem())) {
					p.getInventory().addItem(Souls.UNCOMMON.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.BOOK)) {
					p.getInventory().addItem(MainUtil.bookGive(i.getItemMeta().getDisplayName(), true));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.HOPPER)) {
					p.getInventory().addItem(new ItemStack(Material.HOPPER, 10));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.MONSTER_EGG) || i.getType().equals(Material.EXP_BOTTLE)) {
					p.getInventory().addItem(new ItemStack(i.getType(), i.getAmount(), i.getDurability()));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.INK_SACK)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit kraken " + p.getName());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.NETHER_STAR)) {
					ArrayList<Enchants> common = new ArrayList<>();
					for (Enchants ce : Enchants.values()) {
						if (ce.getRarity().equals(Rarities.COMMON)) {
							common.add(ce);
						}
					}
					Enchants c = common.get(EnchantDrop.getRandomNumberFrom(0, common.size() - 1));
					p.getInventory().addItem(MainUtil.bookGive(c.getName(), false));
					ArrayList<Enchants> uncommon = new ArrayList<>();
					for (Enchants ce : Enchants.values()) {
						if (ce.getRarity().equals(Rarities.UNCOMMON)) {
							uncommon.add(ce);
						}
					}
					Enchants u = uncommon.get(EnchantDrop.getRandomNumberFrom(0, uncommon.size() - 1));
					p.getInventory().addItem(MainUtil.bookGive(u.getName(), false));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				}
			} else if (inv.getName().equalsIgnoreCase(Rarities.HYDRO.getLabel())) {
				if (i.getType().equals(Material.DOUBLE_PLANT)) {
					if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "50000")) {
						econ.depositPlayer(p, 50000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					} else if (i
							.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "25000")) {
						econ.depositPlayer(p, 25000);
						p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
					}
					
				} else if (i.equals(Souls.MYSTICAL.getItem())) {
					p.getInventory().addItem(Souls.MYSTICAL.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getItemMeta().getDisplayName().equals(Rarities.COMMON.name() + ChatColor.GRAY + ", " + Rarities.UNCOMMON.name() + ChatColor.GRAY + " and " + Rarities.RARE.name() + ChatColor.GRAY + " Souls")) {
					p.getInventory().addItem(Souls.COMMON.getItem());
					p.getInventory().addItem(Souls.UNCOMMON.getItem());
					p.getInventory().addItem(Souls.RARE.getItem());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.BOOK)) {
					p.getInventory().addItem(MainUtil.bookGive(i.getItemMeta().getDisplayName(), true));
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.INK_SACK)) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit orca " + p.getName());
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				} else if (i.getType().equals(Material.MOB_SPAWNER)) {
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + p.getName() + " blaze 1");
					p.sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + i.getItemMeta().getDisplayName());
				}
				
			}
		}
	}
}
