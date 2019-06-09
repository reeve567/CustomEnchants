package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.xwy.customenchants.RealName;
import pw.xwy.customenchants.listeners.EnchantDrop;
import pw.xwy.customenchants.enchant_objects.CustomDamageEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class ExpThief extends CustomDamageEnchant {
	public ExpThief(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}

	public ExpThief(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}

	@Override
	//TODO: Fix whatever the hell is going on here
	public void event(EntityDamageByEntityEvent e) {
		if (EnchantDrop.getRandomNumberFrom(1, 100) <= 85) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				if (!(player.getInventory().getBoots() != null && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().hasLore() && player.getInventory().getBoots().getItemMeta().getLore().contains(RealName.EXPPROTECTOR.getEnchant().getName()))) {
					player.setExp(player.getExp() * 98);
					player.setExp(player.getExp() + player.getExp() * 2);
				}
			}
		}
	}
}
