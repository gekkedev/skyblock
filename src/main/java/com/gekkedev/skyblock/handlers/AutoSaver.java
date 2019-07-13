package com.gekkedev.skyblock.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

import com.gekkedev.skyblock.Main;


public class AutoSaver implements Listener {
	@EventHandler
    public void onWorldSave(WorldSaveEvent event)
    {
    	if (event.getWorld() == Main.sbworld) {
    		Main.saveData();
    	}
    }
}
