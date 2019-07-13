package com.gekkedev.skyblock.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gekkedev.skyblock.Main;

import org.bukkit.ChatColor;


public class ChatModifier implements Listener {
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
    	if (event.getPlayer().getWorld() == Main.sbworld) {
    		event.setFormat(ChatColor.UNDERLINE + "[SkyBlock]" + ChatColor.RESET + " %s : %s");
    	}
    }
}
