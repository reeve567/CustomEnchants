package pw.xwy.customenchants;

import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.enchant_objects.ACustomEnchant;

public enum RealName {

	ANIMALCOOKER,
	ANTIKNOCKBACKI, ANTIKNOCKBACKII, ANTIKNOCKBACKIII,
	ARMORDESTRUCTOR,
	AUTOFEEDER,
	BATTLEROAR,
	BURNSHIELD,
	CHARGE,
	CURSED,
	DECAPITATE,
	DEMONSWEAKNESSI, DEMONSWEAKNESSII,
	DIZZY,
	EFFICIENCYVI, EFFICIENCYVII, EFFICIENCYVIII, EFFICIENCYIX, EFFICIENCYX,
	EXPLOSIVEPICKI, EXPLOSIVEPICKII, EXPLOSIVEPICKIII,
	EXPPROTECTOR,
	EXPTHIEF,
	EXTRADAMAGEARROW,
	FLASH,
	FORTUNEV,
	FROZENARROW,
	FROZENBLADE,
	FURNACE,
	GLOWING,
	GRAPPLING,
	GUARDIAN,
	GUARDIANSBLOCK,
	HEARTBOOST,
	HOSTILEDAMAGE,
	LUMBERJACK,
	MEDICINE,
	MINERI, MINERII,
	MOBSLAYERI, MOBSLAYERII, MOBSLAYERIII,
	MOLTEN,
	MOONGRAVITY,
	PARALYZE,
	POISONOUSARROW,
	REINFORCED,
	REKT,
	RIFLE,
	RPG,
	SCUBADIVER,
	SELFHEALER,
	SHOTGUN,
	SMELTING,
	SMOKESCREENI, SMOKESCREENII, SMOKESCREENIII,
	SOULBOUND,
	STARVEDI, STARVEDII, STARVEDIII,
	STORMCALLER,
	SUPERSPEED,
	THOR,
	VALOR,
	VAMPIRE,
	VOLTAGE,
	WINDSSPEEDI, WINDSSPEEDII,
	WITHERI, WITHERII,
	XWY

	//TODO: Move to correct place
	//Just put these here to get rid of compiler errors, runtime errors will occur still
	//Still need to make classes for these enchants



	;

	public static boolean hasEnchant(ItemStack itemInHand, RealName ench) {
		if (itemInHand != null && itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasLore()) {
			for (String s : itemInHand.getItemMeta().getLore()) {
				if (ench.getEnchant().getName().equalsIgnoreCase(s))
					return true;
			}
		}
		return false;
	}

	public ACustomEnchant getEnchant() {
		return CustomEnchantManager.getInstance().getEnchantsByRealName().get(this.toString());
	}

}
