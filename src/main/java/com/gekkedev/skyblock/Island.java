package com.gekkedev.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Island {
	private Player owner;

	public Island(Player player) {
		this.owner = player;
		if (!Main.config.isConfigurationSection("IslandBases." + player.getName())) {
			Location newLoc = getNewLocation();
			ConfigurationSection section = Main.config.createSection("IslandBases." + player.getName());
			section.set("x", newLoc.getX());
			section.set("y", newLoc.getY());
			section.set("z", newLoc.getZ());

			generateIsland();
		}
	}
	
	private Location getNewLocation() {
		//generate a random spawn location
		int radius = 25;
		int minRadius = Bukkit.getSpawnRadius() * 3;
		int maxRadius = radius * Main.config.getConfigurationSection("IslandBases").getKeys(false).size();
		return new Location(
				Main.sbworld,
				minRadius + Math.random() * maxRadius * 2 - maxRadius,
				20, //height
				minRadius + Math.random() * maxRadius * 2 - maxRadius
		);
	}

	public void generateIsland() { //generate island at predefined spawn location
		Bukkit.getLogger().info("Spawning SkyBlock island for " + this.owner.getName());
		this.owner.sendMessage(ChatColor.AQUA + "Please wait while your island is being generated...");
		Bukkit.broadcastMessage(this.owner.getName() + " joined the SkyBlock community!");
		Block spawner = getIslandBase().getBlock();
		for (int x = spawner.getX(); x <= spawner.getX() + 7; x++) {
			for (int z = spawner.getZ(); z <= spawner.getZ() + 4; z++) {
				for (int y = spawner.getY(); y <= spawner.getY() + 15; y++) {
					int height = y - spawner.getY();
					if (height >= 0 && height <= 1) {
						int dice = (int) Math.round(Math.random() * 5);
						switch (dice) {
							case 0:
							case 1:
								Main.sbworld.getBlockAt(x, y, z).setType(Material.DIRT);
								break;
							case 2:
							case 3:
							case 4:
								Main.sbworld.getBlockAt(x, y, z).setType(Material.STONE);
								break;
							case 5:
								Main.sbworld.getBlockAt(x, y, z).setType(Material.IRON_ORE);
								break;
						}
					} else if (height == 2) {
						Main.sbworld.getBlockAt(x, y, z).setType(Material.SAND);
					} else if (height == 3) {
						Main.sbworld.getBlockAt(x, y, z).setType(Material.GRASS_BLOCK);
					}/* else if (height >= 6 && height <= 11) {
						Main.sbworld.getBlockAt(6, y, 4).setType(Material.STRIPPED_OAK_WOOD);
					}*/
					else Main.sbworld.getBlockAt(x, y, z).setType(Material.AIR);
				}
			}
		}

		Block chestBlock = getPlayerSpawn().getBlock().getRelative(4, 0, 2);
		chestBlock.setType(Material.CHEST);
		Chest chest = (Chest) chestBlock.getState();
		ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS);
		seeds.setAmount(3);
		chest.getBlockInventory().addItem(
				new ItemStack(Material.LAVA_BUCKET),
				new ItemStack(Material.ICE),
				new ItemStack(Material.SUGAR_CANE),
				seeds
		);
		
		if (!Main.sbworld.generateTree(getPlayerSpawn().add(3, 0, 0), TreeType.TREE))
			this.owner.sendMessage(ChatColor.RED + "Error: Could not generate tree!");

		//generate a piece of bedrock to mark the spawn location
		getPlayerSpawn().getBlock().getRelative(0, -1, 0).setType(Material.BEDROCK);
	}

	private Location getIslandBase() {
		return new Location(
			Main.sbworld,
			Main.config.getDouble("IslandBases." + this.owner.getName() + ".x"),
			Main.config.getDouble("IslandBases." + this.owner.getName() + ".y"),
			Main.config.getDouble("IslandBases." + this.owner.getName() + ".z")
		);
	}

	private Location getPlayerSpawn() {
		return getIslandBase().add(2, 4, 2);
	}

	public void tpThere() {
		this.owner.sendMessage("Teleporting you to your SkyBlock island...");
		this.owner.teleport(getPlayerSpawn());
	}
}
