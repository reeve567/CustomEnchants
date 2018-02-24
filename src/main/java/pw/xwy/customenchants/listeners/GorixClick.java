////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.listeners;
// made by reeve
// on 8:18 PM

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.enums.Messages;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;
import pw.xwy.customenchants.Main;
import pw.xwy.customenchants.soulcrates.*;
import pw.xwy.customenchants.utilities.CratesUtility;

public class GorixClick implements Listener {
	
	static int r;
	static int j;
	private JavaPlugin main;
	private Economy econ = Main.getEcononomy();
	
	GorixClick(JavaPlugin main) {
		this.main = main;
	}
	
	static Inventory openCommon() {
		Inventory inv = CommonSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, CommonSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < CommonSC.getPrizes().size() + 1) {
				CratesUtility.putPrize(inv, i, r + j, CommonSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtility.putPrize(inv, i, 1, CommonSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	static Inventory openUncommon() {
		Inventory inv = UncommonSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, UncommonSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < UncommonSC.getPrizes().size() + 1) {
				CratesUtility.putPrize(inv, i, r + j, UncommonSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtility.putPrize(inv, i, 1, UncommonSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	static Inventory openRare() {
		Inventory inv = RareSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, RareSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < RareSC.getPrizes().size() + 1) {
				CratesUtility.putPrize(inv, i, r + j, RareSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtility.putPrize(inv, i, 1, RareSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	static Inventory openMystical() {
		Inventory inv = MysticalSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, MysticalSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < MysticalSC.getPrizes().size() + 1) {
				CratesUtility.putPrize(inv, i, r + j, MysticalSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtility.putPrize(inv, i, 1, MysticalSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	static Inventory openHydro() {
		Inventory inv = HydroSC.getBaseInventory();
		r = EnchantDrop.getRandomNumberFrom(0, HydroSC.getPrizes().size() - 1);
		j = 0;
		
		int i = 9;
		
		while (i < 18) {
			if (r + j < HydroSC.getPrizes().size() + 1) {
				CratesUtility.putPrize(inv, i, r + j, HydroSC.getPrizes());
				j++;
			} else {
				j = 0;
				r = 1;
				CratesUtility.putPrize(inv, i, 1, HydroSC.getPrizes());
			}
			i++;
		}
		
		return inv;
	}
	
	@EventHandler
	public void onClick(NPCRightClickEvent e) {
		
		if (e.getNPC().getName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lRubix"))) {
			if (e.getClicker().getItemInHand().hasItemMeta() && e.getClicker().getItemInHand().getItemMeta().hasDisplayName()) {
				for (Souls s : Souls.values()) {
					if (e.getClicker().getItemInHand().getItemMeta().getDisplayName().equals(s.getItem().getItemMeta().getDisplayName())) {
						
						CrateOpen crateOpen = new CrateOpen(main);
						
						if (s.getName().equals(Souls.COMMON.getName())) {
							
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, CommonSC.getPrizes().size() - 1);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							Inventory inv = openCommon();
							e.getClicker().openInventory(inv);
							crateOpen.openCrate(e.getClicker(), inv, Rarities.COMMON, r + j);
							
						} else if (s.getName().equals(Souls.UNCOMMON.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, UncommonSC.getPrizes().size() - 1);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							Inventory inv = openUncommon();
							e.getClicker().openInventory(inv);
							crateOpen.openCrate(e.getClicker(), inv, Rarities.UNCOMMON, r + j);
							
						} else if (s.getName().equals(Souls.RARE.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, RareSC.getPrizes().size() - 1);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							Inventory inv = openRare();
							e.getClicker().openInventory(inv);
							crateOpen.openCrate(e.getClicker(), inv, Rarities.RARE, r + j);
							
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
							
							/*
							 */
							Inventory inv = openMystical();
							e.getClicker().openInventory(inv);
							crateOpen.openCrate(e.getClicker(), inv, Rarities.MYSTICAL, r + j);
							
							
						} else if (s.getName().equals(Souls.HYDRO.getName())) {
							if (e.getClicker().getInventory().firstEmpty() == -1) {
								e.getClicker().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "Your inventory is full!");
								return;
							}
							
							int r = EnchantDrop.getRandomNumberFrom(0, HydroSC.getPrizes().size() - 1);
							
							if (e.getClicker().getItemInHand().getAmount() > 1) {
								e.getClicker().getItemInHand().setAmount(e.getClicker().getItemInHand().getAmount() - 1);
							} else {
								e.getClicker().setItemInHand(null);
							}
							
							Inventory inv = openHydro();
							e.getClicker().openInventory(inv);
							crateOpen.openCrate(e.getClicker(), inv, Rarities.HYDRO, r + j);
							
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
