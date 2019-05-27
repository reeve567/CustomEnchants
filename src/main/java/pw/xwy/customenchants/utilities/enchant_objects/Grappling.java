package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;
import pw.xwy.customenchants.obj.CustomBowBlockEnchant;
import pw.xwy.customenchants.CustomEnchants;
import pw.xwy.customenchants.RealName;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Messages;
import pw.xwy.customenchants.utilities.enums.Rarity;

import static pw.xwy.customenchants.listeners.BowListener.cantShoot;

public class Grappling extends CustomBowBlockEnchant {

	public Grappling(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public Grappling(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	public void launch(ProjectileLaunchEvent e) {
		Player player = (Player) e.getEntity().getShooter();


		ItemStack boots = player.getInventory().getBoots();
		if (boots != null && boots.getItemMeta().getLore().contains(RealName.XWY.getEnchant().getName())) {
			//Starting to redo here
			e.getEntity().setMetadata("Grappling", new FixedMetadataValue(CustomEnchants.instance, player.getName()));
		} else {
			if (!cantShoot.contains(player.getName())) {
				//And here
				e.getEntity().setMetadata("Grappling", new FixedMetadataValue(CustomEnchants.instance, player.getName()));

				cantShoot.add(player.getName());
				Bukkit.getScheduler().runTaskLater(CustomEnchants.instance, () -> cantShoot.remove(player.getName()), 300);
			} else {
				player.sendMessage(Messages.fifsecCooldown.get());
				e.setCancelled(true);
				player.getInventory().addItem(new ItemStack(Material.ARROW));
			}
		}
	}

	@Override
	public void event(ProjectileHitEvent e) {
		Location aLoc = e.getEntity().getLocation();
		Location pLoc = ((Player) e.getEntity().getShooter()).getLocation();

		double x = aLoc.getX() - pLoc.getX();
		double y = aLoc.getY() - pLoc.getY();
		double z = aLoc.getZ() - pLoc.getZ();

		Vector v = new Vector();

		v.setX(x / 3);
		v.setY(y / 9);
		v.setZ(z / 3);

		((Player) e.getEntity().getShooter()).setVelocity(v);

		((Player) e.getEntity().getShooter()).sendMessage(Messages.launched.get());

	}

}
