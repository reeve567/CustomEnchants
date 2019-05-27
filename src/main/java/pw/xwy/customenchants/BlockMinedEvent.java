package pw.xwy.customenchants;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BlockMinedEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	private Block block;
	private Player player;
	private boolean isOriginal;
	
	public BlockMinedEvent(Block block, Player player, boolean isOriginal) {
		this.block = block;
		this.player = player;
		this.isOriginal = isOriginal;
	}
	
	public static void call(Block block, Player player, boolean isOriginal) {
		Bukkit.getPluginManager().callEvent(new BlockMinedEvent(block, player, isOriginal));
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public Block getBlock() {
		return block;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isOriginal() {
		return isOriginal;
	}
	
}
