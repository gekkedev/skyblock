package com.gekkedev.skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gekkedev.skyblock.Island;


public class SBCommand implements CommandExecutor {
    // This method is called whenever somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (sender instanceof Player) {
            Player player = (Player) sender;
    			/*Block block = newSpawn.getBlock();
    			boolean free = true;
    			for (int x = radius; x >= -radius; x--) {
			        for (int y = radius; y >= -radius; y--) {
			            for (int z = radius; z >= -radius; z--) {
			                if (block.getRelative(x, y, z).getType() != Material.AIR && block.getRelative(x, y, z).getType() != Material.VOID_AIR) {
			                    //player.sendMessage("Blocking block found: " + block.getRelative(x, y, z).getType().name());
			                    free = false;
			                }
			            }
			        }
			    }
    			if (free) {
    				ConfigurationSection section = Main.config.createSection("PlayerSpawns." + player.getName());
    				section.set("x", newSpawn.getX());
    				section.set("y", newSpawn.getY());
    				section.set("z", newSpawn.getZ());
    			} else {
    				player.sendMessage(ChatColor.RED + "ERROR: Seems like at your randomly taken position there already is a SkyBlock island!");
    				player.sendMessage("Island position is blocked. Please try again");
    				return true;
    			}*/

			Island island = new Island(player);
    		if (args.length == 1 && args[0].equalsIgnoreCase("restart")) {
    			island.generateIsland();
    		}
    		island.tpThere();
        } else Bukkit.getLogger().warning("Please use this command ingame only!");

        return true;
    }
}