package com.github.vbuilder.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.github.vbuilder.builds.Build;
import com.github.vbuilder.builds.SmallHouse;

public class PlayerListener implements Listener{
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		ItemStack item = player.getItemInHand();
		if(item.getType() == Material.BONE){
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
				Location l = event.getClickedBlock().getLocation();
				float f = player.getLocation().getYaw();
				player.sendMessage(ChatColor.GREEN + "====================");
				player.sendMessage("Yaw: " + f);
				if (f < -45 && f >= -135) player.sendMessage("East");
				else if (f < -135 && f >= -225) player.sendMessage("North");
				else if (f < -225 && f >= -315) player.sendMessage("West");
				else player.sendMessage("South");
				player.sendMessage(ChatColor.GREEN + "====================");
				Build build = new SmallHouse(player.getUniqueId(), l, f);
				build.GenerateStructure();
			}
		}else if(item.getType() == Material.ARROW){
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			}
		}
	}
	
}
