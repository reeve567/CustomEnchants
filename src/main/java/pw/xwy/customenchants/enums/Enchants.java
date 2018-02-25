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

public enum Enchants {
	THOR("&cThor", "Axe", Rarities.COMMON, ItemSets.AXE),
	STORMCALLER("&cStormCaller", "Sword", Rarities.COMMON, ItemSets.SWORD),
	REKT("&cRekt", "Axe", Rarities.RARE, ItemSets.AXE),
	DECAPITATE("&dDecapitate", "Sword & Axe", Rarities.RARE, ItemSets.SWORD, ItemSets.AXE),
	MOBSLAYERI("&cMobSlayer I", "MobSlayerI", "Sword", Rarities.COMMON, ItemSets.SWORD),
	MOBSLAYERII("&cMobSlayer II", "MobSlayerII", "Sword", Rarities.UNCOMMON, 0, ItemSets.SWORD),
	MOBSLAYERIII("&cMobSlayer III", "MobSlayerIII", "Sword", Rarities.RARE, 0, ItemSets.SWORD),
	MOLTEN("&aMolten", "Armor", Rarities.COMMON, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	UNSTABLEI("&aUnstable I", "UnstableI", "Armor", Rarities.RARE, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	UNSTABLEII("&aUnstable II", "UnstableII", "Armor", Rarities.MYSTICAL, 0, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	SOULBOUND("&aSoulbound", "Tools & Armor", Rarities.HYDRO, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS, ItemSets.SWORD, ItemSets.BOW, ItemSets.PICK, ItemSets.AXE),
	FROZENBLADE("&cFrozenBlade", "Sword", Rarities.RARE, ItemSets.SWORD),
	EXPTHIEF("&cEXPThief", "Sword", Rarities.RARE, ItemSets.SWORD),
	HOSTILEDAMAGE("&cHostileDamage", "Sword", Rarities.UNCOMMON, ItemSets.SWORD),
	VAMPIRE("&cVampire", "Sword", Rarities.HYDRO, ItemSets.SWORD),
	GRAPPLINGBOW("&aGrapplingBow", "Bow", Rarities.HYDRO, ItemSets.BOW),
	CURSED("&cCursed", "Axe", Rarities.HYDRO, ItemSets.AXE),
	DIZZY("&cDizzy", "Sword", Rarities.MYSTICAL, ItemSets.SWORD),
	SMOKESCREENI("&cSmokeScreen I", "SmokeScreenI", "Sword & Axe", Rarities.MYSTICAL, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENII("&cSmokeScreen II", "SmokeScreenII", "Sword & Axe", Rarities.MYSTICAL, 0, ItemSets.SWORD, ItemSets.AXE),
	SMOKESCREENIII("&cSmokeScreen III", "SmokeScreenIII", "Sword & Axe", Rarities.HYDRO, 0, ItemSets.SWORD, ItemSets.AXE),
	POISONOUSARROW("&cPoisonousArrow", "Bow", Rarities.UNCOMMON, ItemSets.BOW),
	ANIMALCOOKER("&cAnimalCooker", "Sword", Rarities.COMMON, ItemSets.SWORD),
	FURNACE("&cFurnace", "Bow", Rarities.COMMON, ItemSets.BOW),
	SCUBADIVER("&aScubaDiver", "Helmet", Rarities.COMMON, ItemSets.HELM),
	GLOWING("&aGlowing", "Helmet", Rarities.COMMON, ItemSets.HELM),
	HEARTBOOST("&aHeartBoost", "Helmet", Rarities.HYDRO, ItemSets.HELM),
	VALOR("&cValor", "Armor", Rarities.HYDRO, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	FLASH("&aFlash", "Armor", Rarities.HYDRO, ItemSets.HELM, ItemSets.CHEST, ItemSets.LEGGINGS, ItemSets.BOOTS),
	SMELTING("&aSmelting", "Pickaxe", Rarities.COMMON, ItemSets.PICK),
	HARDENED("&aHardened", "Pickaxe", Rarities.COMMON, ItemSets.PICK),
	FORTUNEV("&7Fortune V", "FortuneV", "Pickaxe", Rarities.MYSTICAL, ItemSets.PICK),
	MAGNET("&aMagnet", "Pickaxe", Rarities.RARE, ItemSets.PICK),
	EXPLOSIVEPICK("&aExplosivePick", "Pickaxe", Rarities.HYDRO, ItemSets.PICK),
	DETONATE("&cDetonate", "Chestplate", Rarities.MYSTICAL, ItemSets.CHEST),
	DEMONSWEAKNESSI("&cDemon's Weakness I", "DemonsWeaknessI", "Sword & Axe", Rarities.HYDRO, ItemSets.SWORD, ItemSets.AXE),
	DEMONSWEAKNESSII("&cDemon's Weakness II", "DemonsWeaknessII", "Sword & Axe", Rarities.HYDRO, 0, ItemSets.SWORD, ItemSets.AXE),
	PARALYZE("&cParalyze", "Sword", Rarities.COMMON, ItemSets.SWORD),
	WITHERI("&cWither I", "WitherI", "Sword", Rarities.HYDRO, ItemSets.SWORD),
	WITHERII("&cWither II", "WitherII", "Sword", Rarities.HYDRO, 0, ItemSets.SWORD),
	BATTLEROAR("&cBattleRoar", "Chestplate", Rarities.UNCOMMON, ItemSets.CHEST),
	BURNSHEILD("&aBurn-Shield", "Armor", Rarities.COMMON, ItemSets.BOOTS, ItemSets.LEGGINGS, ItemSets.CHEST, ItemSets.HELM),
	MEDICINE("&aMedicine", "Helmet", Rarities.HYDRO, ItemSets.HELM),
	GUARDIAN("&aGuardian", "Helmet", Rarities.HYDRO, ItemSets.HELM),
	AUTOFEEDER("&aAutoFeeder", "Leggings", Rarities.MYSTICAL, ItemSets.LEGGINGS),
	VOLTAGE("&cVoltage", "Bow", Rarities.UNCOMMON, ItemSets.BOW),
	FROZENARROW("&cFrozenArrow", "Bow", Rarities.UNCOMMON, ItemSets.BOW),
	SHOTGUN("&cShotgunBow", "Bow", Rarities.HYDRO, ItemSets.BOW),
	EXPPROTECTOR("&aEXPProtector", "Boots", Rarities.RARE, ItemSets.LEGGINGS),
	SELFHEALER("&aSelfHealer", "Boots", Rarities.HYDRO, ItemSets.LEGGINGS),
	CHARGE("&cCharge", "Sword", Rarities.HYDRO, ItemSets.SWORD),
	DEMONSBLADE("&cDemon's Blade", "DemonsBlade", "Sword", Rarities.RARE, ItemSets.SWORD),
	GUARDIANSBLOCK("&cGuardian's Block", "GuardiansBlock", "Sword", Rarities.MYSTICAL, ItemSets.SWORD),
	ARMORDESTRUCTOR("&cArmor Destructor", "ArmorDestructor", "Axe", Rarities.RARE, ItemSets.AXE),
	RIFLE("&cRifleBow", "Bow", Rarities.HYDRO, ItemSets.BOW),
	EXPLOSIVEARROW("&cExplosiveArrow", "Bow", Rarities.MYSTICAL, ItemSets.BOW),
	RPG("&cRPG", "Bow", Rarities.MYSTICAL, ItemSets.BOW),
	REINFORCED("&aReinforced", "Chestplate", Rarities.HYDRO, ItemSets.CHEST),
	LEADERSHIP("&cLeadership", "Boots", Rarities.HYDRO, ItemSets.BOOTS),
	MOONGRAVITY("&aMoonGravity", "Boots", Rarities.RARE, ItemSets.BOOTS),
	WINDSSPEEDI("&aWind's Speed I", "WindsSpeedI", "Boots", Rarities.COMMON, ItemSets.BOOTS),
	WINDSSPEEDII("&aWind's Speed II", "WindsSpeedII", "Boots", Rarities.RARE, 0, ItemSets.BOOTS),
	SUPERSPEED("&aSuperSpeed", "Boots", Rarities.HYDRO, ItemSets.BOOTS),
	STARVEDI("&cStarved I", "StarvedI", "Chestplate", Rarities.RARE, ItemSets.CHEST),
	STARVEDII("&cStarved II", "StarvedII", "Chestplate", Rarities.RARE, 0, ItemSets.CHEST),
	STARVEDIII("&cStarved III", "StarvedIII", "Chestplate", Rarities.MYSTICAL, 0, ItemSets.CHEST),
	ANTIKNOCKBACKI("&cAntiKnockback I", "AntiKnockbackI", "Leggings", Rarities.UNCOMMON, ItemSets.LEGGINGS),
	ANTIKNOCKBACKII("&cAntiKnockback II", "AntiKnockbackII", "Leggings", Rarities.RARE, 0, ItemSets.LEGGINGS),
	ANTIKNOCKBACKIII("&cAntiKnockback III", "AntiKnockbackIII", "Leggings", Rarities.MYSTICAL, 0, ItemSets.LEGGINGS),
	LUMBERJACK("&aLumberjack", "Axe", Rarities.RARE, ItemSets.AXE),
	
	XWY("&6God", "Xwy", "Boots", Rarities.ADMIN, 0, ItemSets.BOOTS),;
	
	private final String name;
	private final String label;
	private final String loreLbl;
	private final Rarities rarity;
	private final int amount;
	private final List<ItemSets> sets = new ArrayList<>();
	
	Enchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, ItemSets... a) {
		
		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = a.length;
		sets.addAll(Arrays.asList(a));
	}
	
	Enchants(String inGameName, String commandLabel, String loreLbl, Rarities rarity, int am, ItemSets... a) {
		
		this.name = inGameName;
		this.label = commandLabel;
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = am;
		sets.addAll(Arrays.asList(a));
	}
	
	Enchants(String inGameName, String loreLbl, Rarities rarity, ItemSets... a) {
		
		this.name = inGameName;
		this.label = ChatColor.stripColor(inGameName);
		this.loreLbl = loreLbl;
		this.rarity = rarity;
		amount = a.length;
		sets.addAll(Arrays.asList(a));
	}
	
	private String conv(String name) {
		return ChatColor.translateAlternateColorCodes('&', name);
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
	
	public String getLabel() {
		
		return label;
	}
	
	public String getLoreLbl() {
		
		return conv(loreLbl);
	}
	
	public String getName() {
		
		return conv(name);
	}
	
	public Rarities getRarity() {
		
		return rarity;
	}
	
}
