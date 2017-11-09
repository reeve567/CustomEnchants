package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 8:00 PM

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import pw.xwy.CustomEnchants.Enums.CustomEnchants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeathListener implements Listener {
	
	static HashMap<Player, List<ItemStack>> keptItems = new HashMap<Player, List<ItemStack>>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		Player k = p.getKiller();
		if (k != null) {
			if (k.getItemInHand().hasItemMeta()) {
				if (k.getItemInHand().getItemMeta().hasLore()) {
					for (String s : k.getItemInHand().getItemMeta().getLore()) {
						if (s.equalsIgnoreCase(CustomEnchants.DECAPITATE.getName())) {
							ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							SkullMeta meta = (SkullMeta) head.getItemMeta();
							meta.setOwner(p.getName());
							head.setItemMeta(meta);
							List<ItemStack> drops = e.getDrops();
							drops.add(head);
						}
					}
				}
			}
		}
		List<ItemStack> keeps = new ArrayList<ItemStack>();
		List<ItemStack> drops = e.getDrops();
		Iterator<ItemStack> iter = drops.iterator();
		while (iter.hasNext()) {
			ItemStack i = iter.next();
			if (i.hasItemMeta() && i.getItemMeta().hasLore()) {
				if (i.getItemMeta().getLore().contains(CustomEnchants.SOULBOUND.getName())) {
					int r = EnchantDrop.getRandomNumberFrom(1, 100);
					if (r <= 10) {
						keeps.add(i);
						iter.remove();
					}
				}
			}
		}
		keptItems.put(p, keeps);
	}
	
	@EventHandler
	public void entityKill(EntityDeathEvent e) {
		
		if (e.getEntity() != null && !(e.getEntity() instanceof Player) && e.getEntity().getKiller() != null) {
			Player p = e.getEntity().getKiller();
			ItemStack i = p.getItemInHand();
			
			if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore()) {
				if (i.getItemMeta().getLore().contains(CustomEnchants.MOBSLAYERI.getName())) {
					e.setDroppedExp(e.getDroppedExp() * 2);
				} else if (i.getItemMeta().getLore().contains(CustomEnchants.MOBSLAYERII.getName())) {
					e.setDroppedExp(e.getDroppedExp() * 3);
				} else if (i.getItemMeta().getLore().contains(CustomEnchants.MOBSLAYERIII.getName())) {
					e.setDroppedExp(e.getDroppedExp() * 4);
				}
				if (i.getItemMeta().getLore().contains(CustomEnchants.ANIMALCOOKER.getName())) {
					changeDrops(e);
				} else if (BowListener.furnaceList.contains(p.getName())) {
					changeDrops(e);
				}
			}
		}
	}
	
	private void changeDrops(EntityDeathEvent e) {
		
		for (ItemStack it : e.getDrops()) {
			if (it.getType().equals(Material.MUTTON)) {
				it.setType(Material.COOKED_MUTTON);
			} else if (it.getType().equals(Material.RAW_BEEF)) {
				it.setType(Material.COOKED_BEEF);
			} else if (it.getType().equals(Material.RABBIT)) {
				it.setType(Material.COOKED_RABBIT);
			} else if (it.getType().equals(Material.PORK)) {
				it.setType(Material.GRILLED_PORK);
			} else if (it.getType().equals(Material.RAW_CHICKEN)) {
				it.setType(Material.COOKED_CHICKEN);
			}
		}
	}
}