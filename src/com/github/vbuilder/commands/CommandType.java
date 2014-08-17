package com.github.vbuilder.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandType implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("VB")){
			if(args[0].equalsIgnoreCase("type")){
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(args.length == 2){
						if(args[1].equalsIgnoreCase("smallhouse")){
							player.sendMessage("right click a block with this arrow in your hand!");
							ItemStack i = new ItemStack(Material.BONE);
							player.getInventory().addItem(i);
						}
					}
				}
			}
		}
		return true;
	}

}
