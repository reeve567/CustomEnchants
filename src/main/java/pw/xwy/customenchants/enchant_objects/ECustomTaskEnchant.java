package pw.xwy.customenchants.enchant_objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.enums.Rarity;

import java.util.List;

public enum ECustomTaskEnchant implements ICustomTaskEnchant {
	FLASH("Flash", ItemSets.ARMOR, Rarity.HYDRO, "This enchant gives you haste if++you have the enchant on all pieces of armor.", Material.GOLD_PICKAXE, 35) {
		@Override
		public void event(Player player) {
			if (player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
				player.removePotionEffect(PotionEffectType.FAST_DIGGING);
			}
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 45, 0));
		}
	},
	GLOWING("Glowing", ItemSets.HELM, Rarity.UNCOMMON, "This enchant gives the wearer infinite night vision.", Material.GLOWSTONE, 35) {
		@Override
		public void event(Player player) {
			if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0));
		}
	},
	HEARTBOOST("Heart Boost", ItemSets.HELM, Rarity.HYDRO, "This enchant adds 4 hearts to the player's max health.", Material.REDSTONE_BLOCK,35) {
		@Override
		public void event(Player player) {
			player.setMaxHealth(28);
		}
		
		@Override
		public boolean check(Player player) {
			if (ItemCheck(player.getInventory().getHelmet())) {
				player.setMaxHealth(20);
				return true;
			}
			return false;
		}
	},
	MOONGRAVITY("Moon Gravity", ItemSets.BOOTS, Rarity.RARE, "This enchant gives the wearer JumpBoost I infinitely.", Material.GOLDEN_CARROT,35) {
		@Override
		public void event(Player player) {
			if (player.hasPotionEffect(PotionEffectType.JUMP))
				player.removePotionEffect(PotionEffectType.JUMP);
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 45, 0));
		}
		
		@Override
		public boolean check(Player player) {
			return ItemCheck(player.getInventory().getBoots());
		}
	},
	SCUBADIVER("Scuba Diver", ItemSets.HELM, Rarity.UNCOMMON, "This enchant gives the wearer infinite water breathing.", Material.RAW_FISH,35) {
		@Override
		public void event(Player player) {
			if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
				player.removePotionEffect(PotionEffectType.WATER_BREATHING);
			}
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 45, 0));
		}
		
		@Override
		public boolean check(Player player) {
			return ItemCheck(player.getInventory().getHelmet());
		}
	},
	VALOR("Valor", ItemSets.ARMOR, Rarity.MYSTICAL, "This enchant gives you resistance if++you have the enchant on all pieces of armor.", Material.BEACON,35) {
		@Override
		public void event(Player player) {
			if (player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
				player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			}
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45, 0));
		}
	},
	WINDSSPEEDI("Wind's Speed I", ItemSets.BOOTS, Rarity.COMMON, "This enchant gives the wearer Speed I infinitely.", Material.SUGAR,35) {
		@Override
		public void event(Player player) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 45, 0));
			if (player.hasPotionEffect(PotionEffectType.SPEED)) {
				player.removePotionEffect(PotionEffectType.SPEED);
			}
		}
		
		@Override
		public boolean check(Player player) {
			return ItemCheck(player.getInventory().getBoots());
		}
	},
	WINDSSPEEDII("Wind's Speed II", ItemSets.BOOTS, Rarity.RARE, "This enchant gives the wearer Speed II infinitely.", Material.SUGAR,35) {
		@Override
		public void event(Player player) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 45, 1));
			if (player.hasPotionEffect(PotionEffectType.SPEED)) {
				player.removePotionEffect(PotionEffectType.SPEED);
			}
		}
		
		@Override
		public boolean check(Player player) {
			return ItemCheck(player.getInventory().getBoots());
		}
	};
	private CustomEnchantUtility customEnchantUtility;
	private int tickWait;
	
	ECustomTaskEnchant(String name, ItemSets sets, Rarity rarity, String description, Material displayItem, int tickWait) {
		customEnchantUtility = new CustomEnchantUtility(name, sets, rarity, description, displayItem);
		this.tickWait = tickWait;
	}
	
	boolean ItemCheck(ItemStack i) {
		return i != null && i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore().contains(getName());
	}
	
	public boolean check(Player player) {
		return ItemCheck(player.getInventory().getHelmet()) &&
				ItemCheck(player.getInventory().getChestplate()) &&
				ItemCheck(player.getInventory().getLeggings()) &&
				ItemCheck(player.getInventory().getBoots());
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
	
	public int getTickWait() {
		return tickWait;
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
