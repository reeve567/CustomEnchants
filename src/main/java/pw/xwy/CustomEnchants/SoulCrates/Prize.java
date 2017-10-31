package pw.xwy.CustomEnchants.SoulCrates;
// made by reeve
// on 5:29 PM

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Prize {

	private String name;
	private ItemStack displayItem;

	public Prize(String name, ItemStack displayItem) {
		this.name = name;

		ItemMeta im = displayItem.getItemMeta();
		im.setDisplayName(name);

		displayItem.setItemMeta(im);

		this.displayItem = displayItem;
	}

	public String getName() {

		return name;
	}

	public ItemStack getDisplayItem() {

		return displayItem;
	}
}
