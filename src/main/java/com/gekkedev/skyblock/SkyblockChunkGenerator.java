package com.gekkedev.skyblock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class SkyblockChunkGenerator extends ChunkGenerator {
    public Location getFixedSpawnLocation(World world, Random random){
        return new Location(world, 0, 70, 0);
    }
 
    public List<BlockPopulator> getDefaultPopulators(World world){
        return new ArrayList<BlockPopulator>();
    }
 
    public short[][] generateExtBlockSections(World world, Random random, int chunkX, int chunkY, BiomeGrid biomegrid){
        return new short[world.getMaxHeight() / 16][];
    }
    public ChunkData generateChunkData(World world, Random random, int x, int z, ChunkGenerator.BiomeGrid biome) {
    	return createChunkData(world);
    }
}
