////////////////////////////////////////////////////////////////////////////////
// File copyright last updated on: 2/24/18 6:47 PM                             /
//                                                                             /
// Copyright (c) 2018.                                                         /
// All code here is made by Xwy (greys#0001) unless otherwise noted.           /
//                                                                             /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package pw.xwy.customenchants.enums;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MenuItem {
	DEMONSWEAKNESSI("Has a chance to give the opponent weakness for 2 seconds.", Material.EYE_OF_ENDER, ItemSets.SWORD, ItemSets.AXE),
	DEMONSWEAKNESSII("Has a chance to give the opponent weakness for 4 seconds.", Material.EYE_OF_ENDER, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENI("Has a chance to give the opponent blindness for 2 seconds.", Material.COAL,1, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENII("Has a chance to give the opponent blindness for 4 seconds.", Material.COAL,1, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENIII("Has a chance to give the opponent blindness for 5 seconds.", Material.COAL,1, ItemSets.SWORD, ItemSets.AXE),
	CURSED("Has a chance to give the opponent Mining Fatigue for 8 seconds.", Material.WOOD_PICKAXE, ItemSets.AXE),
	SOULBOUND("Dying with this enchant on an item++has a chance of keeping it on respawn.", Material.GOLDEN_APPLE, 1, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS, ItemSets.SWORD, ItemSets.BOW, ItemSets.PICK, ItemSets.AXE),
	REKT("Has a chance to deal double damage.", Material.DIAMOND_PICKAXE, ItemSets.AXE),
	DECAPITATE("This enchant ensures you salvage++an enemy player's head.", Material.SKULL_ITEM, 3, ItemSets.SWORD, ItemSets.AXE),
	LUMBERJACK("Mining the bottom log in a tree will drop all the wood.", Material.LOG, ItemSets.AXE),
	ARMORDESTRUCTOR("Damages the opponents armor more than normal.", Material.LEATHER_CHESTPLATE, ItemSets.AXE),
	THOR("Has a chance to smite the opponent when you hit them.", Material.GOLD_AXE, ItemSets.AXE),
	SELFHEALER("This enchant will give you 4 seconds of regeneration when you get below 3 hearts.", Material.RED_MUSHROOM, ItemSets.LEGGINGS),
	FLASH("This enchant gives you haste if you have the enchant on all pieces of armor.", Material.GOLD_PICKAXE, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	VALOR("This enchant gives you resistance if you have the enchant on all pieces of armor.", Material.BEACON, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	AUTOFEEDER("This enchant prevents you from losing hunger.", Material.COOKIE, ItemSets.LEGGINGS),
	UNSTABLEI("This enchant decreases the speed at which armor durability decreases.", Material.DIAMOND, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	UNSTABLEII("This enchant decreases the speed at which armor durability decreases.", Material.DIAMOND, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	GUARDIAN("This enchant makes the wearer immune to wither.", Material.YELLOW_FLOWER, ItemSets.HELM),
	MEDICINE("This enchant makes the wearer immune to poison.", Material.BROWN_MUSHROOM, ItemSets.HELM),
	HEARTBOOST("This enchant adds 4 hearts to the player's max health.", Material.REDSTONE_BLOCK, ItemSets.HELM),
	MOLTEN("This enchant will set an attacker on fire if they hit the wearer.", Material.LAVA_BUCKET, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	BURNSHEILD("This enchant allows the wearer to swim in lava and fire.", Material.POTION, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	GLOWING("This enchant gives the wearer infinite night vision.", Material.GLOWSTONE, ItemSets.HELM),
	SCUBADIVER("This enchant gives the wearer infinite water breathing.", Material.RAW_FISH, ItemSets.HELM),
	ANTIKNOCKBACKI("This enchantment reduces the amount of knockback you take.", Material.FIREWORK_CHARGE, ItemSets.LEGGINGS),
	ANTIKNOCKBACKII("This enchantment reduces the amount of knockback you take.", Material.FIREWORK_CHARGE, ItemSets.LEGGINGS),
	ANTIKNOCKBACKIII("This enchantment reduces the amount of knockback you take.", Material.FIREWORK_CHARGE, ItemSets.LEGGINGS),
	EXPPROTECTOR("This enchantment prevents your EXP from being stolen.", Material.EXP_BOTTLE, ItemSets.LEGGINGS),
	REINFORCED("This enchant will give you 4 seconds of resistance when you get below 3 hearts.", Material.GOLDEN_APPLE, ItemSets.CHEST),
	DETONATE("This enchant has a chance of exploding, damaging everything nearby except the wearer.", Material.TNT, ItemSets.CHEST),
	STARVEDI("This enchant has a chance to make your attacker hungry.", Material.RAW_FISH, ItemSets.CHEST),
	STARVEDII("This enchant has a chance to make your attacker hungry.", Material.RAW_FISH, ItemSets.CHEST),
	STARVEDIII("This enchant has a chance to make your attacker hungry.", Material.RAW_FISH, ItemSets.CHEST),
	BATTLEROAR("This enchant either gives the wearer strength when hit, or wither.", Material.REDSTONE_TORCH_ON, ItemSets.CHEST),
	SHOTGUN("Shooting an arrow with this enchant++launches 4 projectiles while on the++correct mode.", Material.ARROW, ItemSets.BOW),
	GRAPPLINGBOW("Arrows will launch you towards where they++land, if on the correct mode.", Material.WEB, ItemSets.BOW),
	RIFLE("With this enchant, all you have to do++is right click to shoot an arrow, if++on the correct mode.", Material.FIREWORK, ItemSets.BOW),
	EXPLOSIVEARROW("This enchant gives your arrows a chance to++do double damage.", Material.GOLD_INGOT, ItemSets.BOW),
	RPG("This enchant gives your arrows a chance to++explode on impact.", Material.TNT, ItemSets.BOW),
	FROZENARROW("This enchant gives your arrows a chance to++give the player it hit slowness.", Material.ICE, ItemSets.BOW),
	VOLTAGE("This enchant gives your arrows a chance to++smite the player it hit.", Material.BLAZE_POWDER, ItemSets.BOW),
	POISONOUSARROW("This enchant gives you arrows a chance to++poison the player it hit.", Material.SPIDER_EYE, ItemSets.BOW),
	FURNACE("This enchant allows your arrows to cook the++meat of animals that it kills.", Material.GRILLED_PORK, ItemSets.BOW),
	MOONGRAVITY("This enchant gives the wearer JumpBoost I infinitely.", Material.GOLDEN_CARROT, ItemSets.BOOTS),
	SUPERSPEED("When you hit to one and a half hearts or below, you get a speed boost for 3 seconds.", Material.GOLD_BOOTS, ItemSets.BOOTS),
	LEADERSHIP("When faction members are near you, your damage is increased.", Material.CHAINMAIL_HELMET, ItemSets.BOOTS),
	WINDSSPEEDI("This enchant gives the wearer Speed I infinitely.", Material.SUGAR, ItemSets.BOOTS),
	WINDSSPEEDII("This enchant gives the wearer Speed II infinitely.", Material.SUGAR, ItemSets.BOOTS),
	HARDENED("This enchant increases the amount of blocks you++can mine without repairing.", Material.WOOD_PICKAXE, ItemSets.PICK),
	MAGNET("Mined blocks go straight to your inventory.", Material.HOPPER, ItemSets.PICK),
	SMELTING("When you destroy a block with this, you++get the molten products of that block.", Material.GOLD_INGOT, ItemSets.PICK),
	FORTUNEV("This enchant brings great fortune to many.", Material.DIAMOND_PICKAXE, ItemSets.PICK),
	EXPLOSIVEPICK("This enchant allows your pickaxe to++mine in a 5x5x5 area.", Material.FIREBALL, ItemSets.PICK),
	VAMPIRE("Hitting an enemy with this enchant++on your sword will heal you for half++the damage you do.", Material.PUMPKIN, ItemSets.SWORD),
	WITHERI("Hitting an enemy with this enchant++has a chance to wither the opponent++for 2 seconds.", Material.SKULL_ITEM, 1, ItemSets.SWORD),
	WITHERII("Hitting an enemy with this enchant++has a chance to wither the opponent++for 4 seconds.", Material.SKULL_ITEM, 1, ItemSets.SWORD),
	CHARGE("Hitting an enemy while sprinting++increases your damage.", Material.GLOWSTONE_DUST, ItemSets.SWORD),
	DIZZY("Hitting an enemy with this enchant++inflicts 3 seconds of nausea.", Material.JACK_O_LANTERN, ItemSets.SWORD),
	GUARDIANSBLOCK("Taking damage while blocking with++this enchant reduces damage by 50%", Material.GOLD_SWORD, ItemSets.SWORD),
	EXPTHIEF("When you hit someone with this,++it has a chance of stealing their EXP.", Material.EXP_BOTTLE, ItemSets.SWORD),
	FROZENBLADE("This enchantment has a chance to give++the opponent slowness for 5 seconds.", Material.ICE, ItemSets.SWORD),
	DEMONSBLADE("This enchant increases your damage++during combos.", Material.REDSTONE, ItemSets.SWORD),
	MOBSLAYERI("Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE, ItemSets.SWORD),
	MOBSLAYERII("Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE, ItemSets.SWORD),
	MOBSLAYERIII("Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE, ItemSets.SWORD),
	HOSTILEDAMAGE("This enchantment doubles damage to++hostile mobs.", Material.SKULL_ITEM, 2, ItemSets.SWORD),
	STORMCALLER("Hitting an enemy has a chance to++smite them with lightning.", Material.NETHER_STAR, ItemSets.SWORD),
	PARALYZE("Hitting a mob has a chance to slow++it's movement speed.", Material.ROTTEN_FLESH, ItemSets.SWORD),
	ANIMALCOOKER("Killing mobs will cook their meat automatically.", Material.COOKED_BEEF, ItemSets.SWORD);
	
	private final CEnchant customEnchant;
	private final ArrayList<String> desc;
	private final Material type;
	private final List<ItemSets> sets = new ArrayList<>();
	private byte durability = 0;
	
	MenuItem(String desc, Material type, ItemSets... a) {
		customEnchant = CEnchant.valueOf(toString());
		this.desc = conv(desc);
		this.type = type;
		sets.addAll(Arrays.asList(a));
	}
	
	MenuItem(String desc, Material type, int dur, ItemSets... a) {
		customEnchant = CEnchant.valueOf(toString());
		durability = (byte) dur;
		this.desc = conv(desc);
		this.type = type;
		sets.addAll(Arrays.asList(a));
	}
	
	private ArrayList<String> conv(String desc) {
		ArrayList<String> de = new ArrayList<>();
		while (desc.contains("++")) {
			
			de.add(ChatColor.AQUA + desc.substring(0, desc.indexOf("++")));
			desc = desc.replace(desc.substring(0, desc.indexOf("++") + 2), "");
		}
		de.add(ChatColor.AQUA + desc);
		return de;
	}
	
	public CEnchant getCustomEnchant() {
		return customEnchant;
	}
	
	public ArrayList<String> getDesc() {
		return desc;
	}
	
	public byte getDurability() {
		return durability;
	}
	
	public List<ItemSets> getSets() {
		return sets;
	}
	
	public Material getType() {
		return type;
	}
}
