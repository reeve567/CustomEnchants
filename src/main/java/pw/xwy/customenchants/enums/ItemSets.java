////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.enums;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public enum ItemSets {
	SWORD(Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD),
	AXE(Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE),
	BOW(Material.BOW),
	PICK(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE),
	HELM(Material.LEATHER_HELMET, Material.IRON_HELMET, Material.CHAINMAIL_HELMET, Material.GOLD_HELMET, Material.DIAMOND_HELMET),
	CHEST(Material.LEATHER_CHESTPLATE, Material.IRON_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.DIAMOND_CHESTPLATE),
	LEGGINGS(Material.LEATHER_LEGGINGS, Material.IRON_LEGGINGS, Material.GOLD_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.DIAMOND_LEGGINGS),
	BOOTS(Material.LEATHER_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.DIAMOND_BOOTS);
	
	private final List<Material> set = new ArrayList<Material>();
	
	ItemSets(Material a) {
		set.add(a);
	}
	
	ItemSets(Material a, Material b, Material c, Material d, Material e) {
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);
		set.add(e);
	}
	
	public List<Material> getSet() {
		return set;
	}
	
	public boolean setContains(Material a) {
		return set.contains(a);
	}
	
}
