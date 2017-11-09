package pw.xwy.CustomEnchants.Schedules;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pw.xwy.CustomEnchants.SoulCrates.HydroSC;
import pw.xwy.CustomEnchants.SoulCrates.Prize;
import pw.xwy.CustomEnchants.Util.CratesUtil;

import java.util.ArrayList;

public class HydroCrate extends BukkitRunnable {
	
	private Player p;
	private ArrayList<Prize> prizes;
	private Inventory inv;
	private int moves = 0;
	private int runs;
	private int rot;
	private boolean log;
	
	public HydroCrate(ArrayList<Prize> prizes, Inventory inv, Player p, int runs, int rot, boolean log) {
		this.p = p;
		this.prizes = prizes;
		this.inv = inv;
		this.runs = runs;
		this.rot = rot;
		this.log = log;
	}
	
	@Override
	public void run() {
		
		moves++;
		
		
		if (!p.isOnline()) {
			if (log) {
				System.out.println(p.getName() + " has left the game during a hydro roll.");
			}
			cancel();
		}
		if (moves >= rot) {
			if (rot == 3) {
				HydroSC.remRunningInventory(p);
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
