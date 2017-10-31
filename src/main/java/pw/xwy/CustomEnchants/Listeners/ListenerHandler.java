package pw.xwy.CustomEnchants.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pw.xwy.CustomEnchants.SoulCrates.CrateOpen;

public class ListenerHandler {

	private JavaPlugin main;

	public ListenerHandler(JavaPlugin main) {
		this.main = main;
	}


	private void register(Listener Listener) {
		main.getServer().getPluginManager().registerEvents(Listener,main);
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
		BlockListener blockListener = new BlockListener();
		RespawnListener respawnListener = new RespawnListener();
		SprintListener sprintListener = new SprintListener();
		GorixClick gorixClick = new GorixClick();
		JoinListener joinListener = new JoinListener(crateOpen,main);

		register(hitListener);
		register(enchantDrop);
		register(menuClick);
		register(foodListener);
		register(explosionListener);
		register(deathListener);
		register(bowListener);
		register(armorListener);
		register(blockListener);
		register(respawnListener);
		register(sprintListener);
		register(gorixClick);
		register(joinListener);
	}

}
