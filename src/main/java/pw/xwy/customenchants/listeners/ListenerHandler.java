////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.customenchants.soulcrates.CrateOpen;

public class ListenerHandler {
	
	private JavaPlugin main;
	
	public ListenerHandler(JavaPlugin main) {
		this.main = main;
	}
	
	public void Init() {
		CrateOpen crateOpen = new CrateOpen(main);
		HitListener hitListener = new HitListener(main);
		EnchantDrop enchantDrop = new EnchantDrop();
		MenuClick menuClick = new MenuClick();
		FeedListener foodListener = new FeedListener();
		ExplosionListener explosionListener = new ExplosionListener();
		DeathListener deathListener = new DeathListener();
		BowListener bowListener = new BowListener(main);
		ArmorListener armorListener = new ArmorListener();
		//BlockListener blockListener = new BlockListener();
		RespawnListener respawnListener = new RespawnListener();
		SprintListener sprintListener = new SprintListener();
		GorixClick gorixClick = new GorixClick(main);
		JoinListener joinListener = new JoinListener(crateOpen, main);
		register(hitListener);
		register(enchantDrop);
		register(menuClick);
		register(foodListener);
		register(explosionListener);
		register(deathListener);
		register(bowListener);
		register(armorListener);
		//register(blockListener);
		register(respawnListener);
		register(sprintListener);
		register(gorixClick);
		register(joinListener);
	}
	
	private void register(Listener Listener) {
		main.getServer().getPluginManager().registerEvents(Listener, main);
	}
	
}
