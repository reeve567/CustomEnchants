package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Location;
import org.bukkit.Material;
import pw.xwy.customenchants.BlockMinedEvent;
import pw.xwy.customenchants.enchant_objects.CustomMineEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class ExplosivePick3 extends CustomMineEnchant {
	
	public ExplosivePick3(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}
	
	public ExplosivePick3(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem, durability);
	}
	
	@Override
	public void event(BlockMinedEvent e) {
		for (int i = -3; i <= 3; i++) {
			for (int j = -3; j <= 3; j++) {
				for (int k = -3; k <= 3; k++) {
					
					Location temp = e.getBlock().getLocation();
					Location location = new Location(e.getBlock().getWorld(), temp.getX() + i, temp.getY() + j, temp.getZ() + k);
					if (!(i == 0 && j == 0 && k == 0)) {
						BlockMinedEvent.call(location.getBlock(), e.getPlayer(), false);
					}
				}
			}
		}
	}
}
