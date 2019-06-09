package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import pw.xwy.customenchants.enchant_objects.CustomEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

import static pw.xwy.customenchants.listeners.BowListener.cantFire;

public class Rifle extends CustomEnchant {
	public Rifle(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public Rifle(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	public void launch(PlayerInteractEvent e) {
		if (e.getPlayer().getInventory().contains(Material.ARROW)) {
			if (!cantFire.contains(e.getPlayer().getName())) {
				cantFire.add(e.getPlayer().getName());
				e.setCancelled(true);
				e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
				e.getPlayer().getInventory().removeItem(new ItemStack(Material.ARROW, 1));
				Arrow arrow = e.getPlayer().launchProjectile(Arrow.class);
				arrow.setBounce(false);
				Vector v = e.getPlayer().getLocation().getDirection().multiply(3);
				arrow.setVelocity(v);
				e.getPlayer().updateInventory();
				
				Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> cantFire.remove(e.getPlayer().getName()), 100L);
				
			} else {
				e.setCancelled(true);
				e.getPlayer().sendMessage(Messages.prefix.get() + ChatColor.GRAY + "You may only do this every 5 seconds.");
			}
		} else {
			e.getPlayer().sendMessage(Messages.noAmmo.get());
		}
	}
}
