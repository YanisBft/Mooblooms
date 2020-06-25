package com.yanis48.mooblooms.init;

import java.util.List;

import com.yanis48.mooblooms.config.MoobloomsConfig;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnEntry;

public class MoobloomsGeneration {

	public static void init() {
		for (Biome biome : Registry.BIOME) {
			List<SpawnEntry> spawnList = biome.getEntitySpawnList(SpawnGroup.CREATURE);
			
			if (biome.equals(Biomes.FLOWER_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), MoobloomsConfig.DandelionMoobloom.weight, MoobloomsConfig.DandelionMoobloom.minGroupSize, MoobloomsConfig.DandelionMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), MoobloomsConfig.PoppyMoobloom.weight, MoobloomsConfig.PoppyMoobloom.minGroupSize, MoobloomsConfig.PoppyMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), MoobloomsConfig.BlueOrchidMoobloom.weight, MoobloomsConfig.BlueOrchidMoobloom.minGroupSize, MoobloomsConfig.BlueOrchidMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), MoobloomsConfig.AlliumMoobloom.weight, MoobloomsConfig.AlliumMoobloom.minGroupSize, MoobloomsConfig.AlliumMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), MoobloomsConfig.OxeyeDaisyMoobloom.weight, MoobloomsConfig.OxeyeDaisyMoobloom.minGroupSize, MoobloomsConfig.OxeyeDaisyMoobloom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), MoobloomsConfig.CornflowerMoobloom.weight, MoobloomsConfig.CornflowerMoobloom.minGroupSize, MoobloomsConfig.CornflowerMoobloom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), MoobloomsConfig.WitherRoseMoobloom.weight, MoobloomsConfig.WitherRoseMoobloom.minGroupSize, MoobloomsConfig.WitherRoseMoobloom.maxGroupSize));
			}
			
			if (biome.equals(Biomes.SUNFLOWER_PLAINS)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.SUNCOWER.getEntityType(), MoobloomsConfig.Suncower.weight, MoobloomsConfig.Suncower.minGroupSize, MoobloomsConfig.Suncower.maxGroupSize));
			}
			
			if (biome.equals(Biomes.BAMBOO_JUNGLE) || biome.equals(Biomes.BAMBOO_JUNGLE_HILLS)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.BAMBMOO.getEntityType(), MoobloomsConfig.Bambmoo.weight, MoobloomsConfig.Bambmoo.minGroupSize, MoobloomsConfig.Bambmoo.maxGroupSize));
			}
			
			if (biome.equals(Biomes.CRIMSON_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), MoobloomsConfig.CrimsonMooshroom.weight, MoobloomsConfig.CrimsonMooshroom.minGroupSize, MoobloomsConfig.CrimsonMooshroom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), MoobloomsConfig.CrimsonCluckshroom.weight, MoobloomsConfig.CrimsonCluckshroom.minGroupSize, MoobloomsConfig.CrimsonCluckshroom.maxGroupSize));
			}
			
			if (biome.equals(Biomes.WARPED_FOREST)) {
				spawnList.add(new SpawnEntry(MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), MoobloomsConfig.WarpedMooshroom.weight, MoobloomsConfig.WarpedMooshroom.minGroupSize, MoobloomsConfig.WarpedMooshroom.maxGroupSize));
				spawnList.add(new SpawnEntry(MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.WarpedCluckshroom.weight, MoobloomsConfig.WarpedCluckshroom.minGroupSize, MoobloomsConfig.WarpedCluckshroom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.MUSHROOM)) {
				spawnList.add(new Biome.SpawnEntry(MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.RedCluckshroom.weight, MoobloomsConfig.RedCluckshroom.minGroupSize, MoobloomsConfig.RedCluckshroom.maxGroupSize));
				spawnList.add(new Biome.SpawnEntry(MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), MoobloomsConfig.BrownCluckshroom.weight, MoobloomsConfig.BrownCluckshroom.minGroupSize, MoobloomsConfig.BrownCluckshroom.maxGroupSize));
			}
		}
	}
}
