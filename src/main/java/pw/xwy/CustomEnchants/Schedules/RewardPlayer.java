package pw.xwy.CustomEnchants.Schedules;
// made by reeve
// on 12:08 AM

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pw.xwy.CustomEnchants.Enums.Souls;
import pw.xwy.CustomEnchants.Util.MainUtil;

public class RewardPlayer extends BukkitRunnable {

	private Inventory inv;
	private Player p;
	private Souls soul;

	public RewardPlayer(Inventory inv, Player p, Souls soul) {

		this.inv = inv;
		this.p = p;
		this.soul = soul;
	}


	@Override
	public void run() {

		for (ItemStack i : p.getInventory()) {

			if (i != null && i.hasItemMeta() && i.getItemMeta().hasDisplayName()) {
				if (i.getItemMeta().getDisplayName().equals(Souls.COMMON.getName())) {
					if (inv.getItem(13).getType().equals(Material.BOOK)) {
						p.getInventory().addItem(MainUtil.bookGive(inv.getItem(13).getItemMeta().getDisplayName(),false));
					} else {
						p.sendMessage("uh");
					}
				} else {
					p.sendMessage("no common");
				}
			}
		}

	}
}
