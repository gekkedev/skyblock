# SkyBlock
Minimalist SkyBlock plugin for Spigot-based Minecraft servers

![](https://github.com/gekkedev/skyblock/blob/master/img/4.png)

## Installation
1. Download [this JAR file](https://github.com/gekkedev/skyblock/releases/latest) or compile it by yourself.
2. Place the file in your server's plugins directory (using `/reload` is not recommendable).
3. If your server is running, shut it down.
4. Launch your server as usual (or just use `/restart`).
5. Ensure you have a way of teleportation in order to get back the other worlds, as this plugin currently only teleports inwards, not outwards. Installing [*EssentialsX Spawn*](https://dev.bukkit.org/projects/essentialsx) (not the whole suite, just *Spawn*) is a good approach as it provides you with the command `/spawn` which will take care of leaving SkyBlock at any time.

## Usage
Enter `/skyblock` or just `/sb` to start playing SkyBlock and `/spawn` or any other teleportation command to leave the Skyblock world (an additional plugin is required for this).  
In case you ever mess up, you can reset your island by entering `/skyblock reset` or just `/sb reset` and the SkyBlock island will be recreated.  
**Caution:** Teleporting to your island will clear your inventory, so place any important items in a chest first. The purpose of doing that is to prevent any unwanted items from appearing in SkyBlock which would cause unfair advantages.

## Compatibility
The plugin is intended to run on Spigot 1.13.2 or higher.

## Permissions
No permissions exist so far as the plugin is designed to require no management at all. Classic Plug&Play.

## Performance
It's intended to run this plugin on small(low amount of players) community servers for the purpose of quickly adding skyblock gameplay to the server. There's not much done to improve the performance config-wise, BUT all islands are created in the same world (allowing players to interfere with each other) which performs wayyy better than individual worlds.

## Features
### Random positioning
![](https://github.com/gekkedev/skyblock/blob/master/img/1.png)
Islands will spawn at random places with a minimum distance. The algorithm is relatively simple so it will likely expand diagonally with a light spread, depending on the number of existing islands.

### Resources
![](https://github.com/gekkedev/skyblock/blob/master/img/2.png)  
Each chest contains a bucket of lava, one block of ice, a piece of sugar cane, and three seeds. But that's not it! The island is made of a limited amount of sand and comes with the chance to contain a few iron ores.  

### MotD
![](https://github.com/gekkedev/skyblock/blob/master/img/3.png)  
If the plugin is installed, it appends itself to the *Message of the Day* that people will see when pinging the server.
