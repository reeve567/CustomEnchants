package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 11:45 PM

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.CustomEnchants.Enums.Rarities;
import pw.xwy.CustomEnchants.SoulCrates.CommonSC;
import pw.xwy.CustomEnchants.SoulCrates.CrateOpen;

public class JoinListener implements Listener {
	
	private CrateOpen crateOpen;
	private JavaPlugin main;
	
	JoinListener(CrateOpen crateOpen, JavaPlugin main) {
		this.crateOpen = crateOpen;
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		if (CommonSC.isRunningInventory(e.getPlayer())) {
			Bukkit.getScheduler().runTaskLater(main, new Runnable() {
				@Override
				public void run() {
					crateOpen.openCrate(e.getPlayer(), GorixClick.openCommon(), Rarities.COMMON, GorixClick.r + GorixClick.j);
				}
			}, 1);
		}
	}
	
}
