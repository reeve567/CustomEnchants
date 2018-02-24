package pw.xwy.customenchants.schedules;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pw.xwy.customenchants.soulcrates.Prize;
import pw.xwy.customenchants.soulcrates.UncommonSC;
import pw.xwy.customenchants.utilities.CratesUtil;

import java.util.ArrayList;

public class UncommonCrate extends BukkitRunnable {
	
	private Player p;
	private ArrayList<Prize> prizes;
	private Inventory inv;
	private int moves = 0;
	private int runs;
	private int rot;
	private boolean log;
	
	public UncommonCrate(ArrayList<Prize> prizes, Inventory inv, Player p, int runs, int rot, boolean log) {
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
				System.out.println(p.getName() + " has left the game during a uncommon roll.");
			}
			cancel();
		}
		if (moves >= rot) {
			if (rot == 3) {
				UncommonSC.remRunningInventory(p);
			}
			cancel();
		}
		
		ArrayList<ItemStack> items = new ArrayList<>();
		
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
