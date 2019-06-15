package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Location;
import org.bukkit.Material;
import pw.xwy.customenchants.BlockMinedEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.*;

public class CustomMineEnchantLoader {
	private List<ACustomMineEnchant> customMineEnchantList = new ArrayList<>();

	public CustomMineEnchantLoader() {
		customMineEnchantList.addAll(Arrays.asList(
				new ACustomMineEnchant("Explosive Pick I", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 3x3x3 area.", Material.FIREBALL) {
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
				},
				new ACustomMineEnchant("Explosive Pick II", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 5x5x5 area.", Material.FIREBALL) {
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
				},
				new ACustomMineEnchant("Explosive Pick III", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 7x7x7 area.", Material.FIREBALL) {
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
				));
	}

	public List<ACustomMineEnchant> getCustomMineEnchantList() {
		return customMineEnchantList;
	}
}
