////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.soulcrates;
// made by reeve
// on 9:16 PM

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.enums.Rarities;
import pw.xwy.customenchants.enums.Souls;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.schedules.crates.*;

import java.util.ArrayList;

public class CrateOpen {
	
	private JavaPlugin main;
	
	public CrateOpen(JavaPlugin main) {
		
		this.main = main;
	}
	
	public void openCrate(final Player p, final Inventory inv, Rarities type, int runs) {
		
		if (type.equals(Rarities.COMMON)) {
			final ArrayList<Prize> prizes = CommonSC.getPrizes();
			
			int r = EnchantDrop.getRandomNumberFrom(30, 50);
			int ra = EnchantDrop.getRandomNumberFrom(9, 12);
			
			CommonSC.setRunningInventory(p, inv);
			
			new CommonCrate(prizes, inv, p, runs, 10, false).runTaskTimer(main, 0, 7);
			new CommonCrate(prizes, inv, p, runs + 10, r, false).runTaskTimer(main, 70L, 4L);
			new CommonCrate(prizes, inv, p, runs + 10 + r, ra, false).runTaskTimer(main, 70 + (4 * r), 7);
			new CommonCrate(prizes, inv, p, runs + 10 + ra + r, 3, true).runTaskTimer(main, 70 + (7 * ra) + (4 * r), 12);
			
			new RewardPlayer(inv, p, Souls.COMMON).runTaskLater(main, 70 + (7 * ra) + (4 * r) + 36);
		} else if (type.equals(Rarities.UNCOMMON)) {
			final ArrayList<Prize> prizes = UncommonSC.getPrizes();
			
			int r = EnchantDrop.getRandomNumberFrom(30, 50);
			int ra = EnchantDrop.getRandomNumberFrom(9, 12);
			
			UncommonSC.setRunningInventory(p, inv);
			
			new UncommonCrate(prizes, inv, p, runs, 10, false).runTaskTimer(main, 0, 7);
			new UncommonCrate(prizes, inv, p, runs + 10, r, false).runTaskTimer(main, 70L, 4L);
			new UncommonCrate(prizes, inv, p, runs + 10 + r, ra, false).runTaskTimer(main, 70 + (4 * r), 7);
			new UncommonCrate(prizes, inv, p, runs + 10 + ra + r, 3, true).runTaskTimer(main, 70 + (7 * ra) + (4 * r), 12);
			
			new RewardPlayer(inv, p, Souls.UNCOMMON).runTaskLater(main, 70 + (7 * ra) + (4 * r) + 36);
		} else if (type.equals(Rarities.RARE)) {
			final ArrayList<Prize> prizes = RareSC.getPrizes();
			
			int r = EnchantDrop.getRandomNumberFrom(30, 50);
			int ra = EnchantDrop.getRandomNumberFrom(9, 12);
			
			RareSC.setRunningInventory(p, inv);
			
			new RareCrate(prizes, inv, p, runs, 10, false).runTaskTimer(main, 0, 7);
			new RareCrate(prizes, inv, p, runs + 10, r, false).runTaskTimer(main, 70L, 4L);
			new RareCrate(prizes, inv, p, runs + 10 + r, ra, false).runTaskTimer(main, 70 + (4 * r), 7);
			new RareCrate(prizes, inv, p, runs + 10 + ra + r, 3, true).runTaskTimer(main, 70 + (7 * ra) + (4 * r), 12);
			
			new RewardPlayer(inv, p, Souls.MYSTICAL).runTaskLater(main, 70 + (7 * ra) + (4 * r) + 36);
		} else if (type.equals(Rarities.MYSTICAL)) {
			final ArrayList<Prize> prizes = MysticalSC.getPrizes();
			
			int r = EnchantDrop.getRandomNumberFrom(30, 50);
			int ra = EnchantDrop.getRandomNumberFrom(9, 12);
			
			MysticalSC.setRunningInventory(p, inv);
			
			new MysticalCrate(prizes, inv, p, runs, 10, false).runTaskTimer(main, 0, 7);
			new MysticalCrate(prizes, inv, p, runs + 10, r, false).runTaskTimer(main, 70L, 4L);
			new MysticalCrate(prizes, inv, p, runs + 10 + r, ra, false).runTaskTimer(main, 70 + (4 * r), 7);
			new MysticalCrate(prizes, inv, p, runs + 10 + ra + r, 3, true).runTaskTimer(main, 70 + (7 * ra) + (4 * r), 12);
			
			new RewardPlayer(inv, p, Souls.MYSTICAL).runTaskLater(main, 70 + (7 * ra) + (4 * r) + 36);
		} else if (type.equals(Rarities.HYDRO)) {
			final ArrayList<Prize> prizes = HydroSC.getPrizes();
			
			int r = EnchantDrop.getRandomNumberFrom(30, 50);
			int ra = EnchantDrop.getRandomNumberFrom(9, 12);
			
			HydroSC.setRunningInventory(p, inv);
			
			new HydroCrate(prizes, inv, p, runs, 10, false).runTaskTimer(main, 0, 7);
			new HydroCrate(prizes, inv, p, runs + 10, r, false).runTaskTimer(main, 70L, 4L);
			new HydroCrate(prizes, inv, p, runs + 10 + r, ra, false).runTaskTimer(main, 70 + (4 * r), 7);
			new HydroCrate(prizes, inv, p, runs + 10 + ra + r, 3, true).runTaskTimer(main, 70 + (7 * ra) + (4 * r), 12);
			
			new RewardPlayer(inv, p, Souls.HYDRO).runTaskLater(main, 70 + (7 * ra) + (4 * r) + 36);
		}
	}
	
	
}
