package pw.xwy.customenchants.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrugsListener implements Listener {

	public static final String prefix = "§6Drugs §8§l»» §7";

	@EventHandler
	public void onPlayeruse(PlayerInteractEvent event) {
		Player e = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItemInHand().getType() == Material.SUGAR && e.isSneaking()) {


				if (e.hasPotionEffect(PotionEffectType.SPEED))
					e.removePotionEffect(PotionEffectType.SPEED);

				e.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1800, 2));
				if (e.getItemInHand().getAmount() > 1)
					e.getItemInHand().setAmount(e.getItemInHand().getAmount() - 1);
				else
					e.setItemInHand(new ItemStack(Material.AIR));
				e.getPlayer().sendMessage(prefix + "You snorted cocaine");
			}
			if (e.getItemInHand().getType() == Material.GUNPOWDER && e.isSneaking()) {

				if (e.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
					e.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

				e.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1));
				if (e.getItemInHand().getAmount() > 1)
					e.getItemInHand().setAmount(e.getItemInHand().getAmount() - 1);
				else
					e.setItemInHand(new ItemStack(Material.AIR));
				e.getPlayer().sendMessage(prefix + "You took steroids");

			}
			if (e.getItemInHand().getType() == Material.GHAST_TEAR && e.isSneaking()) {
				if (e.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
					e.removePotionEffect(PotionEffectType.SLOW_DIGGING);
				if (e.hasPotionEffect(PotionEffectType.JUMP))
					e.removePotionEffect(PotionEffectType.JUMP);
				if (e.hasPotionEffect(PotionEffectType.REGENERATION))
					e.removePotionEffect(PotionEffectType.REGENERATION);
				if (e.hasPotionEffect(PotionEffectType.SPEED))
					e.removePotionEffect(PotionEffectType.SPEED);
				e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 600, 1));
				e.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 2));
				e.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 3));
				e.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 3));
				e.getPlayer().sendMessage(prefix + "You popped a molly");
				if (e.getItemInHand().getAmount() > 1)
					e.getItemInHand().setAmount(e.getItemInHand().getAmount() - 1);
				else
					e.setItemInHand(new ItemStack(Material.AIR));
			}

		}
	}
}









