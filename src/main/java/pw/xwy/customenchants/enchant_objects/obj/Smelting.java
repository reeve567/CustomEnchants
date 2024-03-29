package pw.xwy.customenchants.enchant_objects.obj;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;
import pw.xwy.customenchants.utilities.FortuneCalc;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;
import pw.xwy.utils.CustomItem;

import java.util.ArrayList;

public class Smelting extends ACustomEnchant {
	public Smelting(String name, ItemSets sets, Rarity rarity, String description, Material displayItem) {
		super(name, sets, rarity, description, displayItem);
	}

	public Smelting(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int durability) {
		super(name, sets, rarity, description, displayItem);
	}

	private int getAmount(boolean fortune, int forLevel, Material type) {
		if (fortune) return FortuneCalc.numDroppedFromFortune(forLevel, type, 1);
		return 1;
	}

	private ItemStack smelting(Material type, int amount) {

		if (type.equals(Material.GOLD_ORE)) {
			return new ItemStack(Material.GOLD_INGOT, amount);
		} else if (type.equals(Material.IRON_ORE)) {
			return new ItemStack(Material.IRON_INGOT, amount);
		} else if (type.equals(Material.COBBLESTONE)) {
			return new ItemStack(Material.STONE);
		}
		return new ItemStack(Material.AIR);
	}

	public ArrayList<ItemStack> event(Block b, boolean fortune, int lvl, byte data) {
		ArrayList<ItemStack> drops = new ArrayList<>();
		if (b.getType().equals(Material.GOLD_ORE) || b.getType().equals(Material.IRON_ORE) || b.getType().equals(Material.COBBLESTONE)) {
			drops.add(smelting(b.getType(), getAmount(fortune, lvl, b.getType())));
		} else {
			if (b.getType() == Material.LAPIS_ORE) data = 4;

			for (ItemStack j : b.getDrops()) {
				drops.add(new CustomItem(j.getType()).setCustomAmount(getAmount(fortune, lvl, b.getType())));
			}
		}
		return drops;
	}
}
