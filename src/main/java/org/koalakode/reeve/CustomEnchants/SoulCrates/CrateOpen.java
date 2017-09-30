package org.koalakode.reeve.CustomEnchants.SoulCrates;
// made by reeve
// on 9:16 PM

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.koalakode.reeve.CustomEnchants.Enums.Rarities;
import org.koalakode.reeve.CustomEnchants.Enums.Souls;
import org.koalakode.reeve.CustomEnchants.Listeners.EnchantDrop;
import org.koalakode.reeve.CustomEnchants.Schedules.CommonCrate;
import org.koalakode.reeve.CustomEnchants.Schedules.RewardPlayer;

import java.util.ArrayList;

public class CrateOpen {

	private JavaPlugin main;

	public CrateOpen(JavaPlugin main) {

		this.main = main;
	}

	public void openCrate(final Player p, final Inventory inv, Rarities type,int runs) {

		if (type.equals(Rarities.COMMON)) {
			final ArrayList<Prize> prizes = CommonSC.getPrizes();

			int r = EnchantDrop.getRandomNumberFrom(30,50);
			int ra = EnchantDrop.getRandomNumberFrom(9,12);

			CommonSC.setRunningInventory(p,inv);

			new CommonCrate(prizes,inv,p,main,runs,10,false).runTaskTimer(main,0,7);
			new CommonCrate(prizes,inv,p,main,runs+10,r,false).runTaskTimer(main,70L,4L);
			new CommonCrate(prizes,inv,p,main,runs+10+r,ra,false).runTaskTimer(main,70+(4*r),7);
			new CommonCrate(prizes,inv,p,main,runs+10+ra+r,3,true).runTaskTimer(main,70+(7*ra)+(4*r),12);

			new RewardPlayer(inv,p, Souls.COMMON).runTaskLater(main,70+(7*ra) + (4*r) + 36);

		}
	}


}
