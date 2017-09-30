package org.koalakode.reeve.CustomEnchants.Schedules;
// made by reeve
// on 10:18 PM

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.koalakode.reeve.CustomEnchants.SoulCrates.CommonSC;
import org.koalakode.reeve.CustomEnchants.SoulCrates.Prize;
import org.koalakode.reeve.CustomEnchants.Util.CratesUtil;

import java.util.ArrayList;

public class CommonCrate extends BukkitRunnable {

	private Player p;
	private ArrayList<Prize> prizes;
	private Inventory inv;
	private JavaPlugin main;
	private int moves = 0;
	private int runs;
	private int rot;
	private boolean log;

	public CommonCrate(ArrayList<Prize> prizes, Inventory inv, Player p, JavaPlugin main,int runs,int rot,boolean log) {
		this.p = p;
		this.prizes = prizes;
		this.inv = inv;
		this.main = main;
		this.runs = runs;
		this.rot = rot;
		this.log = log;
	}

	@Override
	public void run() {

		moves++;


		if (!p.isOnline()) {
			if (log) {
				System.out.println(p.getName() + " has left the game during a common roll.");
			}
			cancel();
		}
		if (moves >= rot) {
			if (rot == 3) {
				CommonSC.remRunningInventory(p);
			}
			cancel();
		}

		ArrayList<ItemStack> items = new ArrayList<ItemStack>();

		for (int i = 9; i < 18; i++) {
			items.add(inv.getItem(i));
		}

		if (runs - 1 >= prizes.size()) {
			runs = 1;
		}

		ArrayList<ItemStack> movedItems = CratesUtil.movePrizes(items, prizes, runs);

		for (int i = 9; i < 18; i++) {
			inv.setItem(i, movedItems.get(i - 9));
		}

		p.openInventory(inv);
		runs++;
	}

}
