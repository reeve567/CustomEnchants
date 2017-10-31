package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 8:18 PM

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pw.xwy.CustomEnchants.Enums.CustomEnchants;
import pw.xwy.CustomEnchants.Enums.Messages;
import pw.xwy.CustomEnchants.Enums.Rarities;
import pw.xwy.CustomEnchants.Enums.Souls;
import pw.xwy.CustomEnchants.Main;
import pw.xwy.CustomEnchants.SoulCrates.*;
import pw.xwy.CustomEnchants.Util.CratesUtil;
import pw.xwy.CustomEnchants.Util.MainUtil;

import java.util.ArrayList;

public class GorixClick implements Listener {
	
	static int r;
	static int j;
	private Economy econ = Main.getEcononomy();
	
	static Inventory openCommon(Player player) {
		Inventory inv = CommonSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, CommonSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < CommonSC.getPrizes().size() + 1) {
				CratesUtil.putPrize(inv, i, r + j, CommonSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtil.putPrize(inv, i, 1, CommonSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	@EventHandler
	public void onClick(NPCRightClickEvent e) {
		
		if (e.getNPC().getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lGorix"))) {
			if (e.getClicker().getItemInHand().hasItemMeta() && e.getClicker().getItemInHand().getItemMeta().hasDisplayName()) {
				for (Souls s : Souls.values()) {
					if (e.getClicker().getItemInHand().getItemMeta().getDisplayName().equals(s.getItem().getItemMeta().getDisplayName())) {
						
						if (s.getName().equals(Souls.COMMON.getName())) {
							
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, CommonSC.getPrizes().size() - 1);
							
							Prize prize = CommonSC.getPrizes().get(r);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							
							if (prize.getDisplayItem().getType().equals(Material.DOUBLE_PLANT)) {
								if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "2500")) {
									econ.depositPlayer(e.getClicker(), 2500);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "5000")) {
									econ.depositPlayer(e.getClicker(), 5000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
							} else if (prize.getDisplayItem().getType().equals(Material.MONSTER_EGG) ||
									prize.getDisplayItem().getType().equals(Material.DIAMOND)) {
								e.getClicker().getInventory().addItem(new ItemStack(prize.getDisplayItem().getType(), prize.getDisplayItem().getAmount(), prize
										.getDisplayItem().getDurability()));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.BOOK)) {
								e.getClicker().getInventory().addItem(MainUtil.bookGive(prize.getDisplayItem().getItemMeta().getDisplayName(), false));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.MOB_SPAWNER)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + e.getClicker().getName() + " bat 1");
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.COMMON.getItem())) {
								e.getClicker().getInventory().addItem(Souls.COMMON.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.UNCOMMON.getItem())) {
								e.getClicker().getInventory().addItem(Souls.UNCOMMON.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.DIAMOND_AXE)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_HOE));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.INK_SACK)) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit shark " + e.getClicker().getName());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							}
							
							//	Inventory inv = openCommon(e.getClicker());
							//	e.getClicker().openInventory(inv);
							//	crateOpen.openCrate(e.getClicker(),inv, Rarities.COMMON,r+j);
							
						} else if (s.getName().equals(Souls.UNCOMMON.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, UncommonSC.getPrizes().size() - 1);
							
							Prize prize = UncommonSC.getPrizes().get(r);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							
							if (prize.getDisplayItem().getType().equals(Material.MOB_SPAWNER)) {
								if (prize.getDisplayItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ocelot Spawner")) {
									Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + e.getClicker().getName() + " ocelot 1");
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else {
									Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + e.getClicker().getName() + " pig 1");
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
								
							} else if (prize.getDisplayItem().getType().equals(Material.DOUBLE_PLANT)) {
								if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "7500")) {
									econ.depositPlayer(e.getClicker(), 7500);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000")) {
									econ.depositPlayer(e.getClicker(), 10000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
								
							} else if (prize.getDisplayItem().equals(s.getItem())) {
								e.getClicker().getInventory().addItem(s.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.RARE.getItem())) {
								e.getClicker().getInventory().addItem(Souls.RARE.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.BOOK)) {
								e.getClicker().getInventory().addItem(MainUtil.bookGive(prize.getDisplayItem().getItemMeta().getDisplayName(), false));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.HOPPER)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.HOPPER, 2));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.MONSTER_EGG) || prize.getDisplayItem().getType().equals(Material.EXP_BOTTLE)) {
								e.getClicker().getInventory().addItem(new ItemStack(prize.getDisplayItem().getType(), prize.getDisplayItem().getAmount(), prize.getDisplayItem().getDurability()));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.TNT)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.TNT, 64));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DISPENSER, 5));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.INK_SACK)) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit shark " + e.getClicker().getName());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.EMERALD_ORE)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND_ORE, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.EMERALD_ORE, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.IRON_ORE, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.GOLD_ORE, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.COAL_ORE, 32));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							}
						} else if (s.getName().equals(Souls.RARE.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, RareSC.getPrizes().size() - 1);
							
							Prize prize = RareSC.getPrizes().get(r);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							
							if (prize.getDisplayItem().getType().equals(Material.DOUBLE_PLANT)) {
								if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "15000")) {
									econ.depositPlayer(e.getClicker(), 15000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "10000")) {
									econ.depositPlayer(e.getClicker(), 10000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
								
							} else if (prize.getDisplayItem().equals(s.getItem())) {
								e.getClicker().getInventory().addItem(s.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.MYSTICAL.getItem())) {
								e.getClicker().getInventory().addItem(Souls.MYSTICAL.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.UNCOMMON.getItem())) {
								e.getClicker().getInventory().addItem(Souls.UNCOMMON.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.BOOK)) {
								e.getClicker().getInventory().addItem(MainUtil.bookGive(prize.getDisplayItem().getItemMeta().getDisplayName(), false));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.HOPPER)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.HOPPER, 5));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.MONSTER_EGG) || prize.getDisplayItem().getType().equals(Material.EXP_BOTTLE)) {
								e.getClicker().getInventory().addItem(new ItemStack(prize.getDisplayItem().getType(), prize.getDisplayItem().getAmount(), prize.getDisplayItem().getDurability()));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.TNT)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.TNT, 64));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DISPENSER, 5));
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIODE, 5));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.INK_SACK)) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit kraken " + e.getClicker().getName());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.EMERALD)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.DIAMOND, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.EMERALD, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.IRON_INGOT, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 32));
								e.getClicker().getInventory().addItem(new ItemStack(Material.COAL, 32));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							}
						} else if (s.getName().equals(Souls.MYSTICAL.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, MysticalSC.getPrizes().size() - 1);
							
							Prize prize = MysticalSC.getPrizes().get(r);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							
							if (prize.getDisplayItem().getType().equals(Material.DOUBLE_PLANT)) {
								if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "17500")) {
									econ.depositPlayer(e.getClicker(), 17500);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "20000")) {
									econ.depositPlayer(e.getClicker(), 20000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
								
							} else if (prize.getDisplayItem().equals(s.getItem())) {
								e.getClicker().getInventory().addItem(s.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.RARE.getItem())) {
								e.getClicker().getInventory().addItem(Souls.RARE.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().equals(Souls.UNCOMMON.getItem())) {
								e.getClicker().getInventory().addItem(Souls.UNCOMMON.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.BOOK)) {
								e.getClicker().getInventory().addItem(MainUtil.bookGive(prize.getDisplayItem().getItemMeta().getDisplayName(), true));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.HOPPER)) {
								e.getClicker().getInventory().addItem(new ItemStack(Material.HOPPER, 10));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.MONSTER_EGG) || prize.getDisplayItem().getType().equals(Material.EXP_BOTTLE)) {
								e.getClicker().getInventory().addItem(new ItemStack(prize.getDisplayItem().getType(), prize.getDisplayItem().getAmount(), prize.getDisplayItem().getDurability()));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.INK_SACK)) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit kraken " + e.getClicker().getName());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.NETHER_STAR)) {
								ArrayList<CustomEnchants> common = new ArrayList<CustomEnchants>();
								for (CustomEnchants ce : CustomEnchants.values()) {
									if (ce.getRarity().equals(Rarities.COMMON)) {
										common.add(ce);
									}
								}
								CustomEnchants c = common.get(EnchantDrop.getRandomNumberFrom(0, common.size() - 1));
								e.getClicker().getInventory().addItem(MainUtil.bookGive(c.getName(), false));
								ArrayList<CustomEnchants> uncommon = new ArrayList<CustomEnchants>();
								for (CustomEnchants ce : CustomEnchants.values()) {
									if (ce.getRarity().equals(Rarities.UNCOMMON)) {
										uncommon.add(ce);
									}
								}
								CustomEnchants u = uncommon.get(EnchantDrop.getRandomNumberFrom(0, uncommon.size() - 1));
								e.getClicker().getInventory().addItem(MainUtil.bookGive(u.getName(), false));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							}
						} else if (s.getName().equals(Souls.HYDRO.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, HydroSC.getPrizes().size() - 1);
							
							Prize prize = HydroSC.getPrizes().get(r);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							
							if (prize.getDisplayItem().getType().equals(Material.DOUBLE_PLANT)) {
								if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "50000")) {
									econ.depositPlayer(e.getClicker(), 50000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								} else if (prize.getDisplayItem()
										.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "$" + ChatColor.DARK_GREEN + "25000")) {
									econ.depositPlayer(e.getClicker(), 25000);
									e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
								}
								
							} else if (prize.getDisplayItem().equals(Souls.MYSTICAL.getItem())) {
								e.getClicker().getInventory().addItem(Souls.MYSTICAL.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getItemMeta().getDisplayName().equals(Rarities.COMMON.name() + ChatColor.GRAY + ", " + Rarities.UNCOMMON.name() + ChatColor.GRAY + " and " + Rarities.RARE.name() + ChatColor.GRAY + " Souls")) {
								e.getClicker().getInventory().addItem(Souls.COMMON.getItem());
								e.getClicker().getInventory().addItem(Souls.UNCOMMON.getItem());
								e.getClicker().getInventory().addItem(Souls.RARE.getItem());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.BOOK)) {
								e.getClicker().getInventory().addItem(MainUtil.bookGive(prize.getDisplayItem().getItemMeta().getDisplayName(), true));
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.INK_SACK)) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit orca " + e.getClicker().getName());
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							} else if (prize.getDisplayItem().getType().equals(Material.MOB_SPAWNER)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ss give " + e.getClicker().getName() + " blaze 1");
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You have won " + prize.getDisplayItem().getItemMeta().getDisplayName());
							}
						}
						return;
						
					}
				}
				e.getClicker().sendMessage(Messages.noSoul.get());
			} else {
				e.getClicker().sendMessage(Messages.noSoul.get());
			}
		}
	}
}
