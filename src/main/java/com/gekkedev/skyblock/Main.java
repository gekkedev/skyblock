package com.gekkedev.skyblock;
import java.io.File;
import java.io.IOException;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gekkedev.skyblock.commands.SBCommand;
import com.gekkedev.skyblock.handlers.AutoSaver;
import com.gekkedev.skyblock.handlers.ChatModifier;
import com.gekkedev.skyblock.handlers.MotdModifier;

/**
 * Skyblock plugin by gekkedev
 */
public class Main extends JavaPlugin
{
	public static World sbworld;
	String WORLDNAME = "skyblock_world";
	public static YamlConfiguration config;
	String configName = "config.yml";
	public static File cfgFile;
    @Override
    public void onEnable() {
        getLogger().info("SkyBlock by gekkedev initialized!");

    	//generate or load world
        WorldCreator creator = new WorldCreator(WORLDNAME);
        creator.generator(new SkyblockChunkGenerator());
        creator.environment(Environment.NORMAL);
        sbworld = creator.createWorld();

        //register events
        getServer().getPluginManager().registerEvents(new MotdModifier(), this);
        getServer().getPluginManager().registerEvents(new ChatModifier(), this);
        getServer().getPluginManager().registerEvents(new AutoSaver(), this);

        //register commands
        this.getCommand("skyblock").setExecutor(new SBCommand());
        
        //init config
        cfgFile = new File(getDataFolder() + File.separator + configName);
        try {
        	config = YamlConfiguration.loadConfiguration(cfgFile);
            getLogger().info("Loaded config.");
        } catch (Exception e) {
            getLogger().info("Could not load config.");
        	config = new YamlConfiguration();
        }
        if (!config.contains("IslandBases")) {
			config.createSection("IslandBases");
			saveData();
	    }
    }

    @Override
    public void onDisable() {
		getLogger().info("Saving skyblock data!");
    	saveData();
    }

	public static void saveData() {
		try {
			Main.config.save(Main.cfgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
