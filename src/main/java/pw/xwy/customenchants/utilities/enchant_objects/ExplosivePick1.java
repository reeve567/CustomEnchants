package pw.xwy.customenchants.utilities.enchant_objects;

import org.bukkit.Location;
import org.bukkit.Material;
import pw.xwy.customenchants.BlockMinedEvent;
import pw.xwy.customenchants.obj.CustomMineEnchant;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

public class ExplosivePick1 extends CustomMineEnchant {
	
	public ExplosivePick1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, boolean... disable) {
		super(name, sets, rarity, description, displayItem, disable);
	}
	
	public ExplosivePick1(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability, boolean... disable) {
		super(name, sets, rarity, description, displayItem, durability, disable);
	}
	
	@Override
	public void event(BlockMinedEvent e) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
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
