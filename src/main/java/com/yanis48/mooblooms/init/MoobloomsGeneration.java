package com.yanis48.mooblooms.init;

import java.util.List;

import com.yanis48.mooblooms.MoobloomsConfig;

import net.minecraft.entity.EntityCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnEntry;

public class MoobloomsGeneration {
	
	public static void init() {
		for (Biome biome : Registry.BIOME) {
			List<SpawnEntry> spawnList = biome.getEntitySpawnList(EntityCategory.CREATURE);
			
			if (biome.equals(Biomes.FLOWER_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.DANDELION_MOOBLOOM, MoobloomsConfig.DandelionMoobloom.weight, MoobloomsConfig.DandelionMoobloom.minGroupSize, MoobloomsConfig.DandelionMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.POPPY_MOOBLOOM, MoobloomsConfig.PoppyMoobloom.weight, MoobloomsConfig.PoppyMoobloom.minGroupSize, MoobloomsConfig.PoppyMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM, MoobloomsConfig.BlueOrchidMoobloom.weight, MoobloomsConfig.BlueOrchidMoobloom.minGroupSize, MoobloomsConfig.BlueOrchidMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.ALLIUM_MOOBLOOM, MoobloomsConfig.AlliumMoobloom.weight, MoobloomsConfig.AlliumMoobloom.minGroupSize, MoobloomsConfig.AlliumMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM, MoobloomsConfig.OxeyeDaisyMoobloom.weight, MoobloomsConfig.OxeyeDaisyMoobloom.minGroupSize, MoobloomsConfig.OxeyeDaisyMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.CORNFLOWER_MOOBLOOM, MoobloomsConfig.CornflowerMoobloom.weight, MoobloomsConfig.CornflowerMoobloom.minGroupSize, MoobloomsConfig.CornflowerMoobloom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.WITHER_ROSE_MOOBLOOM, MoobloomsConfig.WitherRoseMoobloom.weight, MoobloomsConfig.WitherRoseMoobloom.minGroupSize, MoobloomsConfig.WitherRoseMoobloom.maxGroupSize));
			}
			
			if (biome.equals(Biomes.SUNFLOWER_PLAINS)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.SUNCOWER, MoobloomsConfig.Suncower.weight, MoobloomsConfig.Suncower.minGroupSize, MoobloomsConfig.Suncower.maxGroupSize));
			}
			
			if (biome.equals(Biomes.BAMBOO_JUNGLE) || biome.equals(Biomes.BAMBOO_JUNGLE_HILLS)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.BAMBMOO, MoobloomsConfig.Bambmoo.weight, MoobloomsConfig.Bambmoo.minGroupSize, MoobloomsConfig.Bambmoo.maxGroupSize));
			}
			
			if (biome.equals(Biomes.CRIMSON_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.CRIMSON_MOOSHROOM, MoobloomsConfig.CrimsonMooshroom.weight, MoobloomsConfig.CrimsonMooshroom.minGroupSize, MoobloomsConfig.CrimsonMooshroom.maxGroupSize));
			}
			
			if (biome.equals(Biomes.WARPED_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.WARPED_MOOSHROOM, MoobloomsConfig.WarpedMooshroom.weight, MoobloomsConfig.WarpedMooshroom.minGroupSize, MoobloomsConfig.WarpedMooshroom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.MUSHROOM)) {
				spawnList.add(new Biome.SpawnEntry(MoobloomsEntities.CLUCKSHROOM, MoobloomsConfig.Cluckshroom.weight, MoobloomsConfig.Cluckshroom.minGroupSize, MoobloomsConfig.Cluckshroom.maxGroupSize));
			}
		}
	}
}
