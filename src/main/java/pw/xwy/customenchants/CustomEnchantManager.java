package pw.xwy.customenchants;

import org.bukkit.Material;
import pw.xwy.customenchants.enchant_objects.*;
import pw.xwy.customenchants.enchant_objects.obj.*;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CustomEnchantManager {

	private static CustomEnchantManager instance;
	private HashMap<Rarity, List<ACustomEnchant>> enchantsByRarity = new HashMap<>();
	private HashMap<String, ACustomEnchant> enchantsByRealName = new HashMap<>();
	private HashMap<String, ACustomEnchant> enchantsByLore = new HashMap<>();
	private HashMap<String, ACustomEnchant> enchantsByLabel = new HashMap<>();
	private List<CustomDamageEnchant> damageEnchants = new ArrayList<>();
	private List<CustomDeathEnchant> deathEnchants = new ArrayList<>();
	private List<CustomBlockEnchant> blockEnchants = new ArrayList<>();
	private List<CustomTaskEnchant> taskEnchants = new ArrayList<>();
	private List<CustomMineEnchant> mineEnchants = new ArrayList<>();

	public CustomEnchantManager() {
		System.out.println("Custom Enchant Manager started, lists should be good.");
		instance = this;
		// Setup list
		for (Rarity r : Rarity.values()) {
			enchantsByRarity.put(r, new ArrayList<>());
		}

		// START ENCHANTS
		init(
				new AnimalCooker("Animal Cooker", ItemSets.SWORD, Rarity.COMMON, "Killing mobs will cook their meat automatically.", Material.COOKED_BEEF),
				new ArmorDestructor("Armor Destructor", ItemSets.AXE, Rarity.RARE, "Damages the opponents armor more than normal.", Material.LEATHER_CHESTPLATE),
				new Autofeeder("Auto Feeder", ItemSets.LEGGINGS, Rarity.MYSTICAL, "This enchant prevents you from losing hunger.", Material.COOKIE),
				new BattleRoar("Battle Roar", ItemSets.CHEST, Rarity.UNCOMMON, "This enchant either gives the wearer strength when hit, or wither.", Material.REDSTONE_TORCH),
				new BurnShield("Burn Shield", ItemSets.ARMOR, Rarity.COMMON, "This enchant allows the wearer++to swim in lava and fire if you have++the enchant on all pieces of armor.", Material.MAGMA_CREAM),
				new Charge("Charge", ItemSets.SWORD, Rarity.RARE, "Hitting an enemy while sprinting++increases your damage.", Material.GLOWSTONE_DUST),
				new Cursed("Cursed", ItemSets.AXE, Rarity.HYDRO, "Has a chance to give the opponent++Mining Fatigue for 8 seconds.", Material.WOODEN_PICKAXE),
				new Decapitate("Decapitate", ItemSets.SWORDAXE, Rarity.RARE, "This enchant ensures you salvage++an enemy player's head.", Material.PLAYER_HEAD, 3),
				new DemonsWeakness1("Demon's Weakness I", ItemSets.SWORDAXE, Rarity.HYDRO, "Has a chance to give the opponent++weakness for 2 seconds.", Material.ENDER_EYE),
				new DemonsWeakness2("Demon's Weakness II", ItemSets.SWORDAXE, Rarity.HYDRO, "Has a chance to give the opponent++weakness for 4 seconds.", Material.ENDER_EYE),
				new Dizzy("Dizzy", ItemSets.SWORD, Rarity.MYSTICAL, "Hitting an enemy with this enchant++inflicts 3 seconds of nausea.", Material.JACK_O_LANTERN),
				new Efficiency6("Efficiency VI", ItemSets.PICK, Rarity.UNCOMMON, "Makes your pickaxe mine faster", Material.WOODEN_PICKAXE),
				new Efficiency7("Efficiency VII", ItemSets.PICK, Rarity.RARE, "Makes your pickaxe mine faster", Material.STONE_PICKAXE),
				new Efficiency8("Efficiency VIII", ItemSets.PICK, Rarity.RARE, "Makes your pickaxe mine faster", Material.IRON_PICKAXE),
				new Efficiency9("Efficiency IX", ItemSets.PICK, Rarity.MYSTICAL, "Makes your pickaxe mine faster", Material.DIAMOND_PICKAXE),
				new Efficiency10("Efficiency X", ItemSets.PICK, Rarity.HYDRO, "Makes your pickaxe mine faster", Material.GOLDEN_PICKAXE),
				new ExplosivePick1("Explosive Pick I", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 3x3x3 area.", Material.FIRE_CHARGE),
				new ExplosivePick2("Explosive Pick II", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 5x5x5 area.", Material.FIRE_CHARGE),
				new ExplosivePick3("Explosive Pick III", ItemSets.PICK, Rarity.HYDRO, "This enchant allows your pickaxe to++mine in a 7x7x7 area.", Material.FIRE_CHARGE),
				new ExpProtector("Exp Protector", ItemSets.BOOTS, Rarity.RARE, "This enchantment prevents your EXP from being stolen.", Material.EXPERIENCE_BOTTLE),
				new ExpThief("Exp Thief", ItemSets.SWORD, Rarity.RARE, "When you hit someone with this,++it has a chance of stealing their EXP.", Material.EXPERIENCE_BOTTLE),
				new ExtraDamageArrow("Extra Damage Arrow", ItemSets.BOW, Rarity.HYDRO, "This enchant gives your arrows a chance to++do double damage.", Material.GOLD_INGOT),
				new Flash("Flash", ItemSets.ARMOR, Rarity.HYDRO, "This enchant gives you haste if++you have the enchant on all pieces of armor.", Material.GOLDEN_PICKAXE),
				new Fortune5("Fortune V", ItemSets.PICK, Rarity.HYDRO, "This enchant brings great fortune to many.", Material.DIAMOND_PICKAXE),
				new FrozenArrow("Frozen Arrow", ItemSets.BOW, Rarity.RARE, "This enchant gives your arrows a chance to++give the player it hit slowness.", Material.ICE),
				new FrozenBlade("Frozen Blade", ItemSets.SWORD, Rarity.RARE, "This enchantment has a chance to give++the opponent slowness for 5 seconds.", Material.ICE),
				new Furnace("Furnace", ItemSets.BOW, Rarity.COMMON, "This enchant allows your arrows to cook the++meat of animals that it kills.", Material.COOKED_PORKCHOP),
				new Glowing("Glowing", ItemSets.HELM, Rarity.UNCOMMON, "This enchant gives the wearer infinite night vision.", Material.GLOWSTONE),
				new Grappling("Grappling", ItemSets.BOW, Rarity.HYDRO, "Arrows will launch you towards where they++land, if on the correct mode.", Material.COBWEB),
				new Guardian("Guardian", ItemSets.HELM, Rarity.MYSTICAL, "This enchant makes the wearer immune to wither.", Material.SUNFLOWER),
				new GuardiansBlock("Guardian's Block", ItemSets.SWORD, Rarity.HYDRO, "Taking damage while blocking with++this enchant reduces damage by 50%", Material.GOLDEN_SWORD),
				new HeartBoost("Heart Boost", ItemSets.HELM, Rarity.HYDRO, "This enchant adds 4 hearts to the player's max health.", Material.REDSTONE_BLOCK),
				new HostileDamage("Hostile Damage", ItemSets.SWORD, Rarity.UNCOMMON, "This enchantment doubles damage to++hostile mobs.", Material.SKELETON_SKULL, 2),
				new Medicine("Medicine", ItemSets.HELM, Rarity.MYSTICAL, "This enchant makes the wearer immune to poison.", Material.BROWN_MUSHROOM),
				new Miner1("Miner I", ItemSets.PICK, Rarity.RARE, "This doubles the attack damage of a pickaxe", Material.GOLDEN_PICKAXE),
				new Miner2("Miner II", ItemSets.PICK, Rarity.MYSTICAL, "This triples the attack damage of a pickaxe", Material.GOLDEN_PICKAXE),
				new MobSlayer1("Mob Slayer I", ItemSets.SWORD, Rarity.UNCOMMON, "Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE),
				new MobSlayer2("Mob Slayer II", ItemSets.SWORD, Rarity.RARE, "Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE),
				new MobSlayer3("Mob Slayer III", ItemSets.SWORD, Rarity.MYSTICAL, "Killing mobs with this enchantment++yields a higher amount of XP.", Material.SPIDER_EYE),
				new Molten("Molten", ItemSets.ARMOR, Rarity.COMMON, "This enchant will set an attacker on fire if they hit the wearer.", Material.LAVA_BUCKET),
				new MoonGravity("Moon Gravity", ItemSets.BOOTS, Rarity.RARE, "This enchant gives the wearer JumpBoost I infinitely.", Material.GOLDEN_CARROT),
				new Paralyze("Paralyze", ItemSets.SWORD, Rarity.MYSTICAL, "Hitting a mob has a chance to slow++it's movement speed.", Material.ROTTEN_FLESH),
				new PoisonousArrow("Poisonous Arrow", ItemSets.BOW, Rarity.RARE, "This enchant gives you arrows a chance to++poison the player it hit.", Material.SPIDER_EYE),
				new Reinforced("Reinforced", ItemSets.CHEST, Rarity.HYDRO, "This enchant will give you 4 seconds of++resistance when you get below 3 hearts.", Material.GOLDEN_APPLE),
				new Rekt("Rekt", ItemSets.AXE, Rarity.RARE, "Has a chance to deal double damage.", Material.DIAMOND_SWORD),
				new Rifle("Rifle", ItemSets.BOW, Rarity.MYSTICAL, "With this enchant, all you have to do++is right click to shoot an arrow, if++on the correct mode.", Material.FIRE_CHARGE),
				new RPG("RPG", ItemSets.BOW, Rarity.MYSTICAL, "This enchant gives your arrows a chance to++explode on impact.", Material.TNT),
				new ScubaDiver("Scuba Diver", ItemSets.HELM, Rarity.UNCOMMON, "This enchant gives the wearer infinite water breathing.", Material.TROPICAL_FISH),
				new SelfHealer("Self Healer", ItemSets.LEGGINGS, Rarity.MYSTICAL, "This enchant will give you 4++seconds of regeneration when you get below 3 hearts.", Material.RED_MUSHROOM),
				new Shotgun("Shotgun", ItemSets.BOW, Rarity.HYDRO, "Shooting an arrow with this enchant++launches 4 projectiles while on the++correct mode.", Material.ARROW),
				new Smelting("Smelting", ItemSets.PICK, Rarity.HYDRO, "When you destroy a block with this, you++get the molten products of that block.", Material.GOLD_INGOT),
				new SmokeScreen1("Smoke Screen I", ItemSets.SWORDAXE, Rarity.MYSTICAL, "Has a chance to give the opponent++blindness for 2 seconds.", Material.COAL),
				new SmokeScreen2("Smoke Screen II", ItemSets.SWORDAXE, Rarity.MYSTICAL, "Has a chance to give the opponent++blindness for 4 seconds.", Material.COAL),
				new SmokeScreen3("Smoke Screen III", ItemSets.SWORDAXE, Rarity.HYDRO, "Has a chance to give the opponent++blindness for 5 seconds.", Material.COAL),
				new Soulbound("Soulbound", ItemSets.EVERYTHING, Rarity.HYDRO, "Dying with this enchant on an item++has a chance of keeping it on respawn.", Material.ENCHANTED_GOLDEN_APPLE),
				new Starved1("Starved I", ItemSets.LEGGINGS, Rarity.UNCOMMON, "This enchant has a chance to make your attacker hungry.", Material.ROTTEN_FLESH),
				new Starved2("Starved II", ItemSets.LEGGINGS, Rarity.RARE, "This enchant has a chance to make your attacker hungry.", Material.ROTTEN_FLESH),
				new Starved3("Starved III", ItemSets.LEGGINGS, Rarity.MYSTICAL, "This enchant has a chance to make your attacker hungry.", Material.ROTTEN_FLESH),
				new StormCaller("Storm Caller", ItemSets.SWORD, Rarity.UNCOMMON, "Hitting an enemy has a chance to++smite them with lightning.", Material.NETHER_STAR),
				new SuperSpeed("Super Speed", ItemSets.BOOTS, Rarity.MYSTICAL, "When you hit to one and a half hearts or++below, you get a speed boost++for 3 seconds.", Material.GOLDEN_BOOTS),
				new Thor("Thor", ItemSets.AXE, Rarity.COMMON, "Has a chance to smite the opponent when you hit them.", Material.IRON_AXE),
				new Valor("Valor", ItemSets.ARMOR, Rarity.MYSTICAL, "This enchant gives you resistance if++you have the enchant on all pieces of armor.", Material.BEACON),
				new Vampire("Vampire", ItemSets.SWORD, Rarity.HYDRO, "Hitting an enemy with this enchant++on your sword will heal you for half++the damage you do.", Material.PUMPKIN),
				new Voltage("Voltage", ItemSets.BOW, Rarity.RARE, "This enchant gives your arrows a chance to++smite the player it hit.", Material.BLAZE_POWDER),
				new WindsSpeed1("Wind's Speed I", ItemSets.BOOTS, Rarity.COMMON, "This enchant gives the wearer Speed I infinitely.", Material.SUGAR),
				new WindsSpeed2("Wind's Speed II", ItemSets.BOOTS, Rarity.RARE, "This enchant gives the wearer Speed II infinitely.", Material.SUGAR),
				new Wither1("Wither I", ItemSets.SWORD, Rarity.MYSTICAL, "Hitting an enemy with this enchant++has a chance to wither the opponent++for 2 seconds.", Material.WITHER_SKELETON_SKULL),
				new Wither1("Wither II", ItemSets.SWORD, Rarity.HYDRO, "Hitting an enemy with this enchant++has a chance to wither the opponent++for 4 seconds.", Material.WITHER_SKELETON_SKULL),
				new Xwy("Xwy", ItemSets.BOOTS, Rarity.ADMIN, "OOF", Material.DIAMOND_BOOTS)
		);
		System.out.println("Done loading manager");

	}

	public static CustomEnchantManager getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		CustomEnchantManager manager = new CustomEnchantManager();
		for (CustomDamageEnchant enchant : manager.getDamageEnchants()) {
			System.out.println(enchant.getCommandLabel());
		}
	}

	private void init(ACustomEnchant... enchants) {
		for (ACustomEnchant ce : enchants) {
			if (ce instanceof CustomDamageEnchant) {
				damageEnchants.add((CustomDamageEnchant) ce);
			} else if (ce instanceof CustomDeathEnchant) {
				deathEnchants.add((CustomDeathEnchant) ce);
			} else if (ce instanceof CustomBlockEnchant) {
				blockEnchants.add((CustomBlockEnchant) ce);
			} else if (ce instanceof CustomTaskEnchant) {
				taskEnchants.add((CustomTaskEnchant) ce);
			} else if (ce instanceof CustomMineEnchant) {
				mineEnchants.add((CustomMineEnchant) ce);
			}

			List<ACustomEnchant> add = enchantsByRarity.get(ce.getRarity());
			add.add(ce);
			enchantsByRarity.put(ce.getRarity(), add);
			enchantsByRealName.put(ce.getRealName(), ce);
			enchantsByLore.put(ce.getName(), ce);
			enchantsByLabel.put(ce.getCommandLabel(), ce);
		}

	}

	public List<CustomBlockEnchant> getBlockEnchants() {
		return blockEnchants;
	}

	public List<CustomDamageEnchant> getDamageEnchants() {
		return damageEnchants;
	}

	public List<CustomDeathEnchant> getDeathEnchants() {
		return deathEnchants;
	}

	public HashMap<String, ACustomEnchant> getEnchantsByLabel() {
		return enchantsByLabel;
	}

	public HashMap<String, ACustomEnchant> getEnchantsByLore() {
		return enchantsByLore;
	}

	public HashMap<Rarity, List<ACustomEnchant>> getEnchantsByRarity() {
		return enchantsByRarity;
	}

	public HashMap<String, ACustomEnchant> getEnchantsByRealName() {
		return enchantsByRealName;
	}

	public List<CustomMineEnchant> getMineEnchants() {
		return mineEnchants;
	}

	public ACustomEnchant getRandomEnchant(Rarity rarity) {
		ACustomEnchant customEnchant = enchantsByRarity.get(rarity).get(new Random().nextInt(enchantsByRarity.get(rarity).size()));

		while (customEnchant.getRealName().equals(RealName.EXPLOSIVEPICKII.toString()) || customEnchant.getRealName().equals(RealName.EXPLOSIVEPICKIII.toString())) {
			customEnchant = enchantsByRarity.get(rarity).get(new Random().nextInt(enchantsByRarity.get(rarity).size()));
		}

		return customEnchant;

	}

	public List<CustomTaskEnchant> getTaskEnchants() {
		return taskEnchants;
	}

}
