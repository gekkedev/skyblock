package com.gekkedev.skyblock.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.gekkedev.skyblock.Main;

public class WorldChangeHandler implements Listener {
	@EventHandler
	public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
		if (event.getPlayer().getWorld() == Main.sbworld) {
			Main.sbworld.strikeLightningEffect(event.getPlayer().getLocation());
			event.getPlayer().getInventory().clear();
		}
	}
}
