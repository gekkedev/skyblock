package com.gekkedev.skyblock.handlers;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdModifier implements Listener {
	@EventHandler
	public void onServerListPing(ServerListPingEvent event) {
		event.setMotd(event.getMotd() + ChatColor.GREEN + "|SkyBlock" +  ChatColor.RESET);
	}
}
