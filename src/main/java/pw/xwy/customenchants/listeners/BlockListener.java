package pw.xwy.customenchants.listeners;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import pw.xwy.customenchants.*;
import pw.xwy.customenchants.enchant_objects.CustomBlockEnchant;
import pw.xwy.customenchants.enchant_objects.CustomMineEnchant;
import pw.xwy.customenchants.utilities.ExperienceManager;
import pw.xwy.customenchants.enchant_objects.obj.Smelting;
import pw.xwy.customenchants.utilities.enums.ItemSets;
import pw.xwy.customenchants.utilities.FortuneCalc;
import pw.xwy.utils.CustomItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockListener implements Listener {
	
	private int getAmount(boolean fortune, int forLevel, Material type) {
		if (fortune) return FortuneCalc.numDroppedFromFortune(forLevel, type, 1);
		return 1;
	}
	
	private List<ItemStack> getDrop(Block b, boolean smelt, boolean fortune, int lvl, byte data, ItemStack it) {
		
		List<ItemStack> drops = new ArrayList<>();
		if (shouldAdd(b.getType(), it)) {
			if (smelt) {
				drops = ((Smelting) RealName.SMELTING.getEnchant()).event(b, fortune, lvl, data);
			} else {
				if (b.getType() == Material.LAPIS_ORE) data = 4;
				
				for (ItemStack j : b.getDrops()) {
					drops.add(new CustomItem(j.getType()).setCustomAmount(getAmount(fortune, lvl, b.getType())));
				}
			}
		}
		return drops;
	}
	
	private boolean shouldAdd(Material mat, ItemStack is) {
		
		if (mat == Material.BEDROCK || mat == Material.COMMAND_BLOCK || mat == Material.END_PORTAL || mat == Material.END_PORTAL_FRAME || mat == Material.LAVA || mat == Material.WATER) {
			return false;
		} else if (mat == Material.OBSIDIAN) {
			return (is != null) && is.getType() == Material.DIAMOND_PICKAXE;
		} else if (mat == Material.ENDER_CHEST || mat == Material.ANVIL || mat == Material.COAL_BLOCK
				|| mat == Material.REDSTONE_BLOCK || mat == Material.ENCHANTING_TABLE ||
				mat == Material.IRON_BARS || mat == Material.IRON_DOOR || mat == Material.SPAWNER ||
				mat == Material.DISPENSER || mat == Material.DROPPER || mat == Material.COAL_ORE ||
				mat == Material.END_STONE || mat == Material.HOPPER || mat == Material.NETHER_QUARTZ_ORE ||
				mat == Material.BRICK_STAIRS || mat == Material.BRICK || mat == Material.CAULDRON ||
				mat == Material.COBBLESTONE || mat == Material.COBBLESTONE_STAIRS || mat == Material.COBBLESTONE_WALL ||
				mat == Material.MOSSY_COBBLESTONE || mat == Material.NETHER_BRICK || mat == Material.NETHER_BRICK_STAIRS
				|| mat == Material.STONE_PRESSURE_PLATE || (mat.getId() == 43 || mat.getId() == 44) || mat == Material.STONE ||
				(mat.getId() == 94 || mat.getId() == 109) || (mat.getId() == 159 || mat.getId() == 172) ||
				mat == Material.QUARTZ_BLOCK || mat == Material.SANDSTONE || mat == Material.SANDSTONE_STAIRS ||
				mat == Material.NETHERRACK) {
			return (is != null) && (is.getType() == Material.WOODEN_PICKAXE || is.getType() == Material.STONE_PICKAXE ||
					is.getType() == Material.IRON_PICKAXE || is.getType() == Material.DIAMOND_PICKAXE);
		} else if (mat == Material.IRON_BLOCK || mat == Material.IRON_ORE || mat == Material.LAPIS_BLOCK || mat ==
				Material.LAPIS_ORE) {
			return (is != null) && (is.getType() == Material.STONE_PICKAXE || is.getType() == Material.IRON_PICKAXE || is.getType() ==
					Material.DIAMOND_PICKAXE);
		} else if (mat == Material.DIAMOND_ORE || mat == Material.EMERALD_ORE || mat == Material.GOLD_ORE || mat ==
				Material.REDSTONE_ORE) {
			return (is != null) && (is.getType() == Material.IRON_PICKAXE || is.getType() == Material.DIAMOND_PICKAXE);
		}
		return true;
	}
	
	@EventHandler
	public void onLogBreak(BlockBreakEvent e) {
		
		if (ItemSets.AXE.setContains(e.getPlayer().getItemInHand().getType())) {
			
			if (!e.getPlayer().getItemInHand().hasItemMeta() || !e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
				return;
			}
			
			Player player = e.getPlayer();
			
			if (player.getGameMode() == GameMode.CREATIVE) return;
			
			if (!shouldAdd(e.getBlock().getType(), player.getItemInHand())) return;
			
			e.setCancelled(true);
			if (player.getItemInHand() != null && player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().hasLore()) {
				ItemStack i = player.getItemInHand();
				if (ItemSets.AXE.setContains(i.getType()) && i.getItemMeta().getLore().contains(RealName.LUMBERJACK.getEnchant().getName()) && e.getBlock().getType().equals(Material.LEGACY_LOG)) {
					((CustomBlockEnchant) RealName.LUMBERJACK.getEnchant()).event(e);
				}
			} else {
				e.getBlock().setType(Material.AIR);
			}
		}
	}
	
	@EventHandler
	public void onSpecialEvent(BlockMinedEvent e) {
		if (e.getBlock().getType() == Material.BEDROCK || e.getBlock().getType() == Material.AIR) {
			return;
		}
		ItemStack tool = e.getPlayer().getItemInHand();
		boolean hasSmelt = RealName.hasEnchant(e.getPlayer().getItemInHand(), RealName.SMELTING);
		int fortune = 0;
		if (tool != null && tool.hasItemMeta() && tool.getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
			fortune = tool.getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
		}
		ArrayList<ItemStack> drops = new ArrayList<>(getDrop(e.getBlock(), hasSmelt, fortune != 0, fortune, e.getBlock().getData(), tool));
		
		if (e.getBlock().getType() == Material.COAL_ORE || e.getBlock().getType() == Material.REDSTONE_ORE || e.getBlock().getType() == Material.LAPIS_ORE || e.getBlock().getType() == Material.DIAMOND_ORE || e.getBlock().getType() == Material.EMERALD_ORE) {
			int xp = 0;
			Random random = new Random();
			switch (e.getBlock().getType()) {
				case DIAMOND_ORE:
					xp = random.nextInt(5) + 3;
					break;
				case EMERALD_ORE:
					xp = random.nextInt(5) + 3;
					break;
				case COAL_ORE:
					xp = random.nextInt(3);
					break;
				case LAPIS_ORE:
					xp = random.nextInt(4) + 2;
					break;
				case NETHER_QUARTZ_ORE:
					xp = random.nextInt(4) + 2;
					break;
				case REDSTONE_ORE:
					xp = random.nextInt(5) + 1;
					break;
			}
			ExperienceManager experienceManager = new ExperienceManager(e.getPlayer());
			experienceManager.setTotalExperience(experienceManager.getTotalExperience() + xp + 1);
		}
		
		e.getBlock().setType(Material.AIR);
		
		for (ItemStack i : drops) {
			e.getPlayer().getInventory().addItem(i);
		}
		
		if (e.isOriginal()) {
			//harded handle
			if (e.getPlayer().getInventory().firstEmpty() == -1) {
				e.getPlayer().sendMessage("§cInventory is full!");
			}
			//explosive handle
			if (RealName.hasEnchant(e.getPlayer().getItemInHand(), RealName.EXPLOSIVEPICKI)) {
				((CustomMineEnchant) RealName.EXPLOSIVEPICKI.getEnchant()).event(e);
			} else if (RealName.hasEnchant(e.getPlayer().getItemInHand(), RealName.EXPLOSIVEPICKII)) {
				((CustomMineEnchant) RealName.EXPLOSIVEPICKII.getEnchant()).event(e);
			} else if (RealName.hasEnchant(e.getPlayer().getItemInHand(), RealName.EXPLOSIVEPICKIII)) {
				((CustomMineEnchant) RealName.EXPLOSIVEPICKIII.getEnchant()).event(e);
			}
		} else {
			e.getBlock().getLocation().getWorld().playEffect(e.getBlock().getLocation(), Effect.STEP_SOUND, e.getBlock());
		}
		e.getPlayer().updateInventory();
		
	}
}
