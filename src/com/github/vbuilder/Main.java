package com.github.vbuilder;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.vbuilder.commands.CommandType;
import com.github.vbuilder.listeners.PlayerListener;

public class Main extends JavaPlugin{

	private final static Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		
	}
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getCommands();
	}
	
	public static void writeMessage(String s){
		log.info("[VBuilder] " + s);
	}
	
	public static void writeError(String s){
		log.severe("[VBuilder] " + s);
	}
	
	private void getCommands(){
		this.getCommand("VB").setExecutor(new CommandType());
	}
}
