package com.gekkedev.skyblock.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.gekkedev.skyblock.Main;

public class ItemDropper implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getWorld() == Main.sbworld && event.getBlock().getType() == Material.COBBLESTONE) {
			String reward = "";
			Material item = Material.AIR;
			EntityType mob = EntityType.UNKNOWN;
			int dice = (int) Math.round(Math.random() * 128);
			if (dice <= 8) { //chance 1:16 (8:128)
				reward = "dirt";
				item = Material.DIRT;
			} else if (dice == 5) { //1:128
				reward = "lava bucket";
				item = Material.LAVA_BUCKET;
			} else if (dice == 6) {
				reward = "lapis lazuli ore";
				item = Material.LAPIS_ORE;
			} else if (dice == 7) {
				reward = "gold ore";
				item = Material.GOLD_ORE;
			} else if (dice <= 9) { //2:128
				reward = "sand";
				item = Material.SAND;
			} else if (dice <= 11) {
				reward = "iron ore";
				item = Material.IRON_ORE;
			} else if (dice <= 12) {
				reward = "redstone ore";
				item = Material.REDSTONE_ORE;
			} else if (dice <= 14) {
				reward = "gravel";
				item = Material.GRAVEL;
			} else if (dice == 15) {
				reward = "chicken";
				mob = EntityType.CHICKEN;
			} else if (dice == 16) {
				reward = "pig";
				mob = EntityType.PIG;
			} else if (dice == 17) {
				reward = "cow";
				mob = EntityType.COW;
			} else if (dice == 18) {
				reward = "sheep";
				mob = EntityType.SHEEP;
			} else if (dice == 19) {
				reward = "wolf";
				mob = EntityType.WOLF;
			} else event.getBlock().breakNaturally();
			if (reward != "") {
				event.getPlayer().sendMessage(ChatColor.GREEN + "You were lucky! One " + reward + " appeared!");
				Bukkit.getLogger().info(event.getPlayer().getName() + " just dropped one " + reward);
				event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.FIREWORK);
				//event.getBlock().getWorld().playSound(event.getBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
				if (item != Material.AIR) {
					event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(item));
				} else {
					event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation(), mob);
				}
			}
		}
	}
}
