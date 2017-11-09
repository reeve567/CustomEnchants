package pw.xwy.CustomEnchants.Listeners;
// made by reeve
// on 12:21 PM

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import pw.xwy.CustomEnchants.Enums.CustomEnchants;
import pw.xwy.CustomEnchants.Enums.Messages;

public class HitListener implements Listener {
	
	static Player summoner = null;
	static boolean playerMadeExplosion = false;
	private Player explodee = null;
	private JavaPlugin main;
	
	HitListener(JavaPlugin main) {
		this.main = main;
	}
	
	
	private boolean armorCheck(ItemStack a, String ench) {
		
		if (a != null) {
			if (a.hasItemMeta()) {
				if (a.getItemMeta().hasLore()) {
					for (String s : a.getItemMeta().getLore()) {
						if (s.equalsIgnoreCase(ench)) return true;
					}
				}
			}
		}
		return false;
	}
	
	private void moltenFunc(Entity damager, Entity person) {
		
		if (damager instanceof Arrow) {
			Arrow arrow = (Arrow) damager;
			if (arrow.getShooter() instanceof Skeleton) {
				Skeleton sk = (Skeleton) arrow.getShooter();
				sk.setFireTicks(100);
				
			} else if (arrow.getShooter() instanceof Player) {
				Player pl = (Player) arrow.getShooter();
				pl.setFireTicks(100);
			} else
				person.sendMessage(String.valueOf(((Arrow) damager).getShooter()));
		} else
			damager.setFireTicks(100);
	}
	
	@EventHandler
	public void Hit(final EntityDamageByEntityEvent e) {
		
		if (!e.isCancelled()) {
			
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				ItemStack legs = player.getInventory().getLeggings();
				ItemStack chest = player.getInventory().getChestplate();
				ItemStack boots = player.getInventory().getBoots();
				ItemStack helm = player.getInventory().getHelmet();
				
				if (armorCheck(chest, CustomEnchants.DETONATE.getName())) {
					int r = EnchantDrop.getRandomNumberFrom(1, 100);
					if (r > 75) {
						explodee = (Player) e.getEntity();
						playerMadeExplosion = true;
						e.getEntity().getLocation().getWorld().createExplosion(e.getEntity().getLocation(), 3, false);
					}
				}
				
				if (player.isBlocking() && player.getItemInHand() != null && player.getItemInHand().hasItemMeta() &&
						player.getItemInHand().getItemMeta().hasLore() && player.getItemInHand().getItemMeta().getLore().contains(CustomEnchants
						.GUARDIANSBLOCK
						.getName())) {
					e.setDamage(e.getDamage() / 2);
				}
				
				
				if (armorCheck(boots, CustomEnchants.SELFHEALER.getName())) {
					if (((Player) e.getEntity()).getHealth() <= 5) {
						((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
					}
				}
				if (armorCheck(chest, CustomEnchants.REINFORCED.getName())) {
					if (((Player) e.getEntity()).getHealth() <= 5) {
						((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 80, 0));
					}
				}
				if (armorCheck(boots, CustomEnchants.SUPERSPEED.getName())) {
					if (((Player) e.getEntity()).getHealth() <= 3) {
						((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2));
					}
				}
				if (armorCheck(legs, CustomEnchants.STARVEDI.getName())) {
					if (e.getDamager() instanceof Player && ((Player) e.getDamager()).getFoodLevel() > 0) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 15) {
							((Player) e.getDamager()).setFoodLevel(((Player) e.getDamager()).getFoodLevel() - 1);
						}
					}
				} else if (armorCheck(legs, CustomEnchants.STARVEDII.getName())) {
					if (e.getDamager() instanceof Player && ((Player) e.getDamager()).getFoodLevel() > 0) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 25) {
							((Player) e.getDamager()).setFoodLevel(((Player) e.getDamager()).getFoodLevel() - 1);
						}
					}
				} else if (armorCheck(legs, CustomEnchants.STARVEDIII.getName())) {
					if (e.getDamager() instanceof Player && ((Player) e.getDamager()).getFoodLevel() > 0) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 35) {
							((Player) e.getDamager()).setFoodLevel(((Player) e.getDamager()).getFoodLevel() - 1);
						}
					}
				}
				if (armorCheck(legs, CustomEnchants.ANTIKNOCKBACKI.getName())) {
					Bukkit.getScheduler().runTaskLater(main, new Runnable() {
						@Override
						public void run() {
							
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.75);
							e.getEntity().setVelocity(kb);
						}
					}, 1);
				} else if (armorCheck(legs, CustomEnchants.ANTIKNOCKBACKII.getName())) {
					Bukkit.getScheduler().runTaskLater(main, new Runnable() {
						@Override
						public void run() {
							
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.5);
							e.getEntity().setVelocity(kb);
						}
					}, 1);
				} else if (armorCheck(legs, CustomEnchants.ANTIKNOCKBACKIII.getName())) {
					
					Bukkit.getScheduler().runTaskLater(main, new Runnable() {
						@Override
						public void run() {
							
							Vector kb = e.getDamager().getLocation().toVector().subtract(e.getEntity().getLocation().toVector()).multiply(-0.25);
							e.getEntity().setVelocity(kb);
						}
					}, 1);
				}
				
				
				if (armorCheck(helm, CustomEnchants.MOLTEN.getName())) {
					moltenFunc(e.getDamager(), e.getEntity());
				} else if (armorCheck(chest, CustomEnchants.MOLTEN.getName())) {
					moltenFunc(e.getDamager(), e.getEntity());
				} else if (armorCheck(legs, CustomEnchants.MOLTEN.getName())) {
					moltenFunc(e.getDamager(), e.getEntity());
				} else if (armorCheck(boots, CustomEnchants.MOLTEN.getName())) {
					moltenFunc(e.getDamager(), e.getEntity());
				}
			}
			if (e.getDamager() instanceof Arrow) {
				if (((Arrow) e.getDamager()).getShooter() instanceof Player) {
					Player p = (Player) ((Arrow) e.getDamager()).getShooter();
					if (BowListener.freezerlist.contains(p.getName())) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 20) {
							if (e.getEntity() instanceof Player) {
								Player p1 = (Player) e.getEntity();
								p1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 3));
								p.sendMessage(Messages.frozen.get());
								BowListener.freezerlist.remove(p.getName());
							}
						}
					}
					if (BowListener.smiteList.contains(p.getName())) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 20) {
							e.getEntity().getLocation().getWorld().strikeLightning(e.getEntity().getLocation());
							p.sendMessage(Messages.smited.get());
							BowListener.smiteList.remove(p.getName());
						}
					}
					if (BowListener.rpgList.contains(p.getName())) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 15) {
							playerMadeExplosion = true;
							e.getEntity().getLocation().getWorld().createExplosion(e.getEntity().getLocation(), 5);
							BowListener.rpgList.remove(p.getName());
						}
					}
					if (BowListener.explosiveList.contains(p.getName())) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 70) {
							e.setDamage(e.getDamage() * 2);
							BowListener.explosiveList.remove(p.getName());
						}
					}
					if (BowListener.poisonList.contains(p.getName())) {
						int num = EnchantDrop.getRandomNumberFrom(1, 100);
						if (num <= 50) {
							if (e.getEntity() instanceof Player) {
								((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
								p.sendMessage(Messages.poisoned.get());
							}
						}
					}
				}
			}
			
			
			if (e.getDamager() instanceof Player) {
				Player player = (Player) e.getDamager();
				
				if (armorCheck(player.getInventory().getBoots(), CustomEnchants.LEADERSHIP.getName())) {
					double bonus = 0;
					
					for (Player other : Bukkit.getOnlinePlayers()) {
						double maxDist = 20;
						
						if (other != player && other.getLocation().getWorld() == player.getLocation().getWorld()) {
							if (other.getLocation().distanceSquared(player.getLocation()) <= maxDist) {
								
								Faction fac1 = MPlayer.get(other).getFaction();
								Faction fac2 = MPlayer.get(player).getFaction();
								
								if (fac1 == fac2) {
									bonus += 0.05;
								}
							}
						}
					}
					e.setDamage(e.getDamage() + bonus);
				}
				
				
				if (player.getItemInHand().hasItemMeta()) {
					if (player.getItemInHand().getItemMeta().hasLore()) {
						for (String s : player.getItemInHand().getItemMeta().getLore()) {
							if (s.equalsIgnoreCase(CustomEnchants.VAMPIRE.getName())) {
								double d = player.getHealth() + (e.getDamage() / 2);
								if (d > player.getMaxHealth()) d = player.getMaxHealth();
								player.setHealth(d);
							} else if (s.equalsIgnoreCase(CustomEnchants.STORMCALLER.getName()) || s.equalsIgnoreCase(CustomEnchants.THOR.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 90) {
									player.getLocation().getWorld().strikeLightning(e.getEntity().getLocation());
									summoner = player;
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.ARMORDESTRUCTOR.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 75) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										
										ItemStack boots = player.getInventory().getBoots();
										ItemStack legs = player.getInventory().getLeggings();
										ItemStack chest = player.getInventory().getChestplate();
										ItemStack helm = player.getInventory().getHelmet();
										
										if (boots != null) {
											boots.setDurability((short) (boots.getDurability() + 1));
										}
										if (legs != null) {
											legs.setDurability((short) (legs.getDurability() + 1));
										}
										if (chest != null) {
											chest.setDurability((short) (chest.getDurability() + 1));
										}
										if (helm != null) {
											helm.setDurability((short) (helm.getDurability() + 1));
										}
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.REKT.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 90) {
									e.setDamage(e.getDamage() * 2);
									e.getDamager().sendMessage(Messages.rektMessage.get());
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.DEMONSWEAKNESSI.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 40, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.DEMONSWEAKNESSII.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 80, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.SMOKESCREENI.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.SMOKESCREENII.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.SMOKESCREENIII.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.EXPTHIEF.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r < 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										if (!(((Player) e.getEntity()).getInventory().getBoots() != null &&
												((Player) e.getEntity()).getInventory().getBoots().hasItemMeta() &&
												((Player) e.getEntity()).getInventory().getBoots().getItemMeta().hasLore() &&
												((Player) e.getEntity()).getInventory().getBoots().getItemMeta().getLore()
														.contains(CustomEnchants.EXPPROTECTOR.getName()))) {
											((Player) e.getEntity()).setExp(((Player) e.getEntity()).getExp() * 98);
											((Player) e.getDamager()).setExp(((Player) e.getDamager()).getExp() + ((Player) e.getEntity()).getExp() * 2);
										}
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.CHARGE.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 85) {
									if (SprintListener.sprinting.contains(e.getEntity())) {
										e.setDamage(e.getDamage() * 1.2);
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.DEMONSBLADE.getName())) {
								e.setDamage(e.getDamage() * 1.05);
							} else if (s.equalsIgnoreCase(CustomEnchants.WITHERI.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 40, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.WITHERII.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 0));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.FROZENBLADE.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 85) {
									if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.CURSED.getName())) {
								int r = EnchantDrop.getRandomNumberFrom(1, 100);
								if (r > 85) {
									if (e.getEntity() instanceof Player) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 160, 0));
										e.getDamager().sendMessage(Messages.cursed.get());
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.DIZZY.getName())) {
								if (e.getEntity() instanceof Player) {
									((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 60, 0));
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.HOSTILEDAMAGE.getName())) {
								if (e.getEntity() instanceof Monster) {
									e.setDamage(e.getDamage() * 2);
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.PARALYZE.getName())) {
								if (e.getEntity() instanceof Player) {
									
									int r = EnchantDrop.getRandomNumberFrom(1, 100);
									if (r > 80) {
										((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
									}
								}
							} else if (s.equalsIgnoreCase(CustomEnchants.BATTLEROAR.getName())) {
								if (e.getEntity() instanceof Player) {
									int g = EnchantDrop.getRandomNumberFrom(1, 100);
									if (g <= 20) {
										int r = EnchantDrop.getRandomNumberFrom(1, 100);
										if (r <= 50) {
											if (((Player) e.getEntity()).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
												((Player) e.getEntity()).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
											((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
										} else {
											if (((Player) e.getEntity()).hasPotionEffect(PotionEffectType.WITHER))
												((Player) e.getEntity()).removePotionEffect(PotionEffectType.WITHER);
											((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 0));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void lightStrikeFire(BlockIgniteEvent e) {
		
		if (e.getCause().equals(BlockIgniteEvent.IgniteCause.LIGHTNING)) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onFire(EntityCombustEvent e) {
		
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			ItemStack legs = player.getInventory().getLeggings();
			ItemStack chest = player.getInventory().getChestplate();
			ItemStack boots = player.getInventory().getBoots();
			ItemStack helm = player.getInventory().getHelmet();
			if (armorCheck(helm, CustomEnchants.BURNSHEILD.getName()) ||
					armorCheck(chest, CustomEnchants.BURNSHEILD.getName()) ||
					armorCheck(legs, CustomEnchants.BURNSHEILD.getName()) ||
					armorCheck(boots, CustomEnchants.BURNSHEILD.getName())) {
				e.setDuration(0);
				e.setCancelled(true);
			}
		}
	}
	
	
	@EventHandler
	public void EnvHit(EntityDamageEvent e) {
		
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			ItemStack boots = player.getInventory().getBoots();
			if (boots != null && boots.hasItemMeta() && boots.getItemMeta().hasLore() && boots.getItemMeta().getLore().contains(CustomEnchants.XWY.getName())) {
				e.setCancelled(true);
			}
		}
		
		
		//Lightning
		if (e.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				if (player.equals(summoner)) {
					e.setCancelled(true);
				} else {
					e.getEntity().setFireTicks(0);
				}
			} else if (e.getEntity() instanceof Item) {
				e.setCancelled(true);
			} else {
				e.getEntity().setFireTicks(0);
			}
		} else if (e.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				if (player.equals(explodee)) {
					e.setCancelled(true);
					explodee = null;
				}
			}
		} else if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				if (BowListener.shootChk(player.getName()))
					e.setCancelled(true);
			}
		} else if (e.getCause().equals(EntityDamageEvent.DamageCause.POISON)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				ItemStack helm = player.getInventory().getHelmet();
				if (helm != null && helm.hasItemMeta() && helm.getItemMeta().hasLore()) {
					for (String s : helm.getItemMeta().getLore()) {
						if (s.equalsIgnoreCase(CustomEnchants.MEDICINE.getName())) {
							e.setCancelled(true);
						}
					}
				}
				
			}
		} else if (e.getCause().equals(EntityDamageEvent.DamageCause.WITHER)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				ItemStack helm = player.getInventory().getHelmet();
				if (helm != null && helm.hasItemMeta() && helm.getItemMeta().hasLore()) {
					for (String s : helm.getItemMeta().getLore()) {
						if (s.equalsIgnoreCase(CustomEnchants.GUARDIAN.getName())) {
							e.setCancelled(true);
						}
					}
				}
				
			}
		} else if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) ||
				e.getCause().equals(EntityDamageEvent.DamageCause.LAVA) ||
				e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
			if (e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				ItemStack legs = player.getInventory().getLeggings();
				ItemStack chest = player.getInventory().getChestplate();
				ItemStack boots = player.getInventory().getBoots();
				ItemStack helm = player.getInventory().getHelmet();
				if (armorCheck(helm, CustomEnchants.BURNSHEILD.getName()) ||
						armorCheck(chest, CustomEnchants.BURNSHEILD.getName()) ||
						armorCheck(legs, CustomEnchants.BURNSHEILD.getName()) ||
						armorCheck(boots, CustomEnchants.BURNSHEILD.getName()))
					e.setCancelled(true);
			}
		}
	}
}