package pw.xwy.CustomEnchants.Enums;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public enum CustomEnchants {
	THOR(ChatColor.RED + "Thor", "Thor", "Axe", Rarities.COMMON, ItemSets.AXE),
	STORMCALLER(ChatColor.RED + "StormCaller", "StormCaller", "Sword", Rarities.COMMON, ItemSets.SWORD),
	REKT(ChatColor.RED + "Rekt", "rekt", "Axe", Rarities.RARE, ItemSets.AXE),
	DECAPITATE(ChatColor.LIGHT_PURPLE + "Decapitate", "Decapitate", "Sword & Axe", Rarities.RARE, ItemSets.SWORD, ItemSets.AXE),
	MOBSLAYERI(ChatColor.RED + "MobSlayer I", "MobSlayerI", "Sword", Rarities.COMMON, ItemSets.SWORD),
	MOBSLAYERII(ChatColor.RED + "MobSlayer II", "MobSlayerII", "Sword", Rarities.UNCOMMON, ItemSets.SWORD,0),
	MOBSLAYERIII(ChatColor.RED + "MobSlayer III", "MobSlayerIII", "Sword", Rarities.RARE, ItemSets.SWORD,0),
	MOLTEN(ChatColor.GREEN + "Molten", "Molten", "Armor", Rarities.COMMON, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	UNSTABLEI(ChatColor.GREEN + "Unstable I", "UnstableI", "Armor", Rarities.RARE, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	UNSTABLEII(ChatColor.GREEN + "Unstable II", "UnstableII", "Armor", Rarities.MYSTICAL, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS,0),
	SOULBOUND(ChatColor.GREEN + "Soulbound", "Soulbound", "Tools & Armor", Rarities.HYDRO, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS, ItemSets.SWORD, ItemSets.BOW, ItemSets.PICK, ItemSets.AXE),
	FROZENBLADE(ChatColor.RED + "FrozenBlade", "FrozenBlade", "Sword", Rarities.RARE, ItemSets.SWORD),
	EXPTHIEF(ChatColor.RED + "EXPThief", "EXPThief", "Sword", Rarities.RARE, ItemSets.SWORD),
	HOSTILEDAMAGE(ChatColor.RED + "HostileDamage", "HostileDamage", "Sword", Rarities.UNCOMMON, ItemSets.SWORD),
	VAMPIRE(ChatColor.RED + "Vampire", "Vampire", "Sword", Rarities.HYDRO, ItemSets.SWORD),
	GRAPPLINGBOW(ChatColor.GREEN + "GrapplingBow", "GrapplingBow", "Bow", Rarities.HYDRO, ItemSets.BOW),
	CURSED(ChatColor.RED + "Cursed", "Cursed", "Axe", Rarities.HYDRO, ItemSets.AXE),
	DIZZY(ChatColor.RED + "Dizzy", "Dizzy", "Sword", Rarities.MYSTICAL, ItemSets.SWORD),
	SMOKESCREENI(ChatColor.RED + "SmokeScreen I", "SmokeScreenI", "Sword & Axe", Rarities.MYSTICAL, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENII(ChatColor.RED + "SmokeScreen II", "SmokeScreenII", "Sword & Axe", Rarities.MYSTICAL, ItemSets.SWORD, ItemSets.AXE,0),
	SMOKESCREENIII(ChatColor.RED + "SmokeScreen III", "SmokeScreenIII", "Sword & Axe", Rarities.HYDRO, ItemSets.SWORD, ItemSets.AXE,0),
	POISONOUSARROW(ChatColor.RED + "PoisonousArrow", "PoisonousArrow", "Bow", Rarities.UNCOMMON, ItemSets.BOW),
	ANIMALCOOKER(ChatColor.RED + "AnimalCooker", "AnimalCooker", "Sword", Rarities.COMMON, ItemSets.SWORD),
	FURNACE(ChatColor.RED + "Furnace", "Furnace", "Bow", Rarities.COMMON, ItemSets.BOW),
	SCUBADIVER(ChatColor.GREEN + "ScubaDiver", "ScubaDiver", "Helmet", Rarities.COMMON, ItemSets.HELM),
	GLOWING(ChatColor.GREEN + "Glowing", "Glowing", "Helmet", Rarities.COMMON, ItemSets.HELM),
	HEARTBOOST(ChatColor.GREEN + "HeartBoost", "HeartBoost", "Helmet", Rarities.HYDRO, ItemSets.HELM),
	VALOR(ChatColor.RED + "Valor", "Valor", "Armor", Rarities.HYDRO, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	FLASH(ChatColor.GREEN + "Flash","Flash","Armor",Rarities.HYDRO,ItemSets.HELM,ItemSets.CHEST,ItemSets.LEGGINGS,ItemSets.BOOTS),
	SMELTING(ChatColor.GREEN + "Smelting", "Smelting", "Pickaxe", Rarities.COMMON, ItemSets.PICK),
	HARDENED(ChatColor.GREEN + "Hardened", "Hardened", "Pickaxe", Rarities.COMMON, ItemSets.PICK),
	FORTUNEV(ChatColor.GRAY + "Fortune V", "FortuneV", "Pickaxe", Rarities.MYSTICAL, ItemSets.PICK),
	MAGNET(ChatColor.GREEN + "Magnet", "Magnet", "Pickaxe", Rarities.RARE, ItemSets.PICK),
	EXPLOSIVEPICK(ChatColor.GREEN + "ExplosivePick", "ExplosivePick", "Pickaxe", Rarities.HYDRO, ItemSets.PICK),
	DETONATE(ChatColor.RED + "Detonate","Detonate","Chestplate",Rarities.MYSTICAL,ItemSets.CHEST),
	DEMONSWEAKNESSI(ChatColor.RED + "Demon's Weakness I","DemonsWeaknessI","Sword & Axe",Rarities.HYDRO,ItemSets.SWORD,ItemSets.AXE),
	DEMONSWEAKNESSII(ChatColor.RED + "Demon's Weakness II","DemonsWeaknessII","Sword & Axe",Rarities.HYDRO,ItemSets.SWORD,ItemSets.AXE,0),
	PARALYZE(ChatColor.RED + "Paralyze","Paralyze","Sword",Rarities.COMMON,ItemSets.SWORD),
	WITHERI(ChatColor.RED + "Wither I","WitherI","Sword",Rarities.HYDRO,ItemSets.SWORD),
	WITHERII(ChatColor.RED + "Wither II","WitherII","Sword",Rarities.HYDRO,ItemSets.SWORD,0),
	BATTLEROAR(ChatColor.RED + "BattleRoar","BattleRoar","Chestplate",Rarities.UNCOMMON,ItemSets.CHEST),
	BURNSHEILD(ChatColor.GREEN + "Burn-Shield","Burn-Shield","Armor",Rarities.COMMON,ItemSets.BOOTS,ItemSets.LEGGINGS,ItemSets.CHEST,ItemSets.HELM),
	MEDICINE(ChatColor.GREEN + "Medicine","Medicine","Helmet",Rarities.HYDRO,ItemSets.HELM),
	GUARDIAN(ChatColor.GREEN + "Guardian","Guardian","Helmet",Rarities.HYDRO,ItemSets.HELM),
	AUTOFEEDER(ChatColor.GREEN + "AutoFeeder","AutoFeeder","Leggings",Rarities.MYSTICAL,ItemSets.LEGGINGS),
	VOLTAGE(ChatColor.RED + "Voltage","Voltage","Bow",Rarities.UNCOMMON,ItemSets.BOW),
	FROZENARROW(ChatColor.RED + "FrozenArrow","FrozenArrow","Bow",Rarities.UNCOMMON,ItemSets.BOW),
	SHOTGUN(ChatColor.RED + "ShotgunBow","ShotgunBow","Bow",Rarities.HYDRO,ItemSets.BOW),
	EXPPROTECTOR(ChatColor.GREEN + "EXPProtector","EXPProtector","Boots",Rarities.RARE,ItemSets.LEGGINGS),
	SELFHEALER(ChatColor.GREEN + "SelfHealer","SelfHealer","Boots",Rarities.HYDRO,ItemSets.LEGGINGS),
	CHARGE(ChatColor.RED + "Charge","Charge","Sword",Rarities.HYDRO,ItemSets.SWORD),
	DEMONSBLADE(ChatColor.RED + "Demon's Blade","DemonsBlade","Sword",Rarities.RARE,ItemSets.SWORD),
	GUARDIANSBLOCK(ChatColor.RED + "Guardian's Block","GuardiansBlock","Sword",Rarities.MYSTICAL,ItemSets.SWORD),
	ARMORDESTRUCTOR(ChatColor.RED + "Armor Destructor","ArmorDestructor","Axe",Rarities.RARE,ItemSets.AXE),
	RIFLE(ChatColor.RED + "RifleBow","RifleBow","Bow",Rarities.HYDRO,ItemSets.BOW),
	EXPLOSIVEARROW(ChatColor.RED + "ExplosiveArrow","ExplosiveArrow","Bow",Rarities.MYSTICAL,ItemSets.BOW),
	RPG(ChatColor.RED + "RPG","RPG","Bow",Rarities.MYSTICAL,ItemSets.BOW),
	REINFORCED(ChatColor.GREEN + "Reinforced","Reinforced","Chestplate",Rarities.HYDRO,ItemSets.CHEST),
	LEADERSHIP(ChatColor.RED + "Leadership","Leadership","Boots",Rarities.HYDRO,ItemSets.BOOTS),
	MOONGRAVITY(ChatColor.GREEN + "MoonGravity","MoonGravity","Boots",Rarities.RARE,ItemSets.BOOTS),
	WINDSSPEEDI(ChatColor.GREEN + "Wind's Speed I","WindsSpeedI","Boots",Rarities.COMMON,ItemSets.BOOTS),
	WINDSSPEEDII(ChatColor.GREEN + "Wind's Speed II","WindsSpeedII","Boots",Rarities.RARE,ItemSets.BOOTS,0),
	SUPERSPEED(ChatColor.GREEN + "SuperSpeed","SuperSpeed","Boots",Rarities.HYDRO,ItemSets.BOOTS),
	STARVEDI(ChatColor.RED + "Starved I","StarvedI","Chestplate",Rarities.RARE,ItemSets.CHEST),
	STARVEDII(ChatColor.RED + "Starved II","StarvedII","Chestplate",Rarities.RARE,ItemSets.CHEST,0),
	STARVEDIII(ChatColor.RED + "Starved III","StarvedIII","Chestplate",Rarities.MYSTICAL,ItemSets.CHEST,0),
	ANTIKNOCKBACKI(ChatColor.RED + "AntiKnockback I","AntiKnockbackI","Leggings",Rarities.UNCOMMON,ItemSets.LEGGINGS),
	ANTIKNOCKBACKII(ChatColor.RED + "AntiKnockback II","AntiKnockbackII","Leggings",Rarities.RARE,ItemSets.LEGGINGS,0),
	ANTIKNOCKBACKIII(ChatColor.RED + "AntiKnockback III","AntiKnockbackIII","Leggings",Rarities.MYSTICAL,ItemSets.LEGGINGS,0),
	LUMBERJACK(ChatColor.GREEN + "Lumberjack","Lumberjack","Axe",Rarities.RARE,ItemSets.AXE),

	XWY(ChatColor.GOLD + "God", "Xwy", "Boots", Rarities.ADMIN, ItemSets.BOOTS,0),
	;

	private final String name;
	private final String label;
	private final String loreLbl;
	private final Rarities rarity;
	private final int amount;
	private final List<ItemSets> sets = new ArrayList<ItemSets>();


	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = 1;
		sets.add(a);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a,int am) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = am;
		sets.add(a);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a, ItemSets b) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = 2;
		sets.add(a);
		sets.add(b);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a, ItemSets b,int am) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = am;
		sets.add(a);
		sets.add(b);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a, ItemSets b, ItemSets c, ItemSets d) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = 4;
		sets.add(a);
		sets.add(b);
		sets.add(c);
		sets.add(d);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a, ItemSets b, ItemSets c, ItemSets d,int am) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = am;
		sets.add(a);
		sets.add(b);
		sets.add(c);
		sets.add(d);
	}

	CustomEnchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets a, ItemSets b,
	               ItemSets c, ItemSets d, ItemSets e, ItemSets f, ItemSets g, ItemSets h) {

		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = 8;
		sets.add(a);
		sets.add(b);
		sets.add(c);
		sets.add(d);
		sets.add(e);
		sets.add(f);
		sets.add(g);
		sets.add(h);
	}


	public String getName() {

		return name;
	}

	public String getLabel() {

		return label;
	}

	public Rarities getRarity() {

		return rarity;
	}

	public String getLoreLbl() {

		return loreLbl;
	}

	public boolean checkSets(Material m) {

		for (ItemSets i : sets) {
			if (i.setContains(m)) {
				return true;
			}
		}
		return false;
	}

	public int getAmount() {
		return amount;
	}

}
