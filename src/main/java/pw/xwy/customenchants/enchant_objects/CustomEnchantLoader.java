package pw.xwy.customenchants.enchant_objects;

import java.util.List;

public class CustomEnchantLoader {

	public List<ACustomBlockEnchant> customBlockEnchants;
	public List<ACustomMineEnchant> customMineEnchants;

	public CustomEnchantLoader() {
		customBlockEnchants = new CustomBlockEnchantLoader().getCustomBlockEnchants();
		customMineEnchants = new CustomMineEnchantLoader().getCustomMineEnchantList();
	}
}
