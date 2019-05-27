package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Location;
import org.bukkit.Material;
import pw.xwy.customenchants.BlockMinedEvent;
import pw.xwy.customenchants.obj.CustomMineEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class ExplosivePick2 extends CustomMineEnchant {
	
	public ExplosivePick2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public ExplosivePick2(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	@Override
	public void event(BlockMinedEvent e) {
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				for (int k = -2; k <= 2; k++) {
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
