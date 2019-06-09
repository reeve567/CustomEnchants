package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.BlockMinedEvent;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.List;

public enum ECustomMineEnchant implements ICustomMineEnchant {
	EXPLOSIVEPICKI("Explosive Pick I", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 3x3x3 area.", Material.FIREBALL) {
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
	EXPLOSIVEPICKII("Explosive Pick II", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 5x5x5 area.", Material.FIREBALL) {
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
	EXPLOSIVEPICKIII("Explosive Pick III", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 7x7x7 area.", Material.FIREBALL) {
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
	};
	private CustomEnchantUtility customEnchantUtility;
	
	ECustomMineEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		customEnchantUtility = new CustomEnchantUtility(name, sets, rarity, description, displayItem);
	}
	
	public boolean checkSets(Material material) {
		return customEnchantUtility.checkSets(material);
	}
	
	public boolean containsSet(ItemSets set) {
		return customEnchantUtility.containsSet(set);
	}
	
	public String getCommandLabel() {
		return customEnchantUtility.getCommandLabel();
	}
	
	public List<String> getDescription() {
		return customEnchantUtility.getDescription();
	}
	
	public ItemStack getDisplayItem() {
		return customEnchantUtility.getDisplayItem();
	}
	
	public String getName() {
		return customEnchantUtility.getName();
	}
	
	public Rarity getRarity() {
		return customEnchantUtility.getRarity();
	}
	
	public String getRealName() {
		return customEnchantUtility.getRealName();
	}
	
	public ItemSets getSets() {
		return customEnchantUtility.getSets();
	}
	
	public boolean isEnabled() {
		return customEnchantUtility.isEnabled();
	}
	
	public void saveConfig(Config config) {
		customEnchantUtility.saveDefault(config);
	}
	
	public void setCustomStuff(Config config) {
		customEnchantUtility.setCustomStuff(config);
	}
}
