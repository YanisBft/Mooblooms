package com.yanisbft.mooblooms.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.yanisbft.mooblooms.config.MoobloomsConfig;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import com.yanisbft.mooblooms.mixin.SpawnRestrictionAccessor;
import com.yanisbft.mooblooms.mixin.SpawnSettingsAccessor;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;

public class MoobloomsGeneration {
	private static final Registry<Biome> REGISTRY = BuiltinRegistries.BIOME;

	public static void init() {
		registerSpawnRestrictions();
		
		for (Biome biome : BuiltinRegistries.BIOME) {
			
			if (biome.equals(REGISTRY.get(BiomeKeys.FLOWER_FOREST))) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), MoobloomsConfig.DandelionMoobloom.weight, MoobloomsConfig.DandelionMoobloom.minGroupSize, MoobloomsConfig.DandelionMoobloom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), MoobloomsConfig.PoppyMoobloom.weight, MoobloomsConfig.PoppyMoobloom.minGroupSize, MoobloomsConfig.PoppyMoobloom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), MoobloomsConfig.BlueOrchidMoobloom.weight, MoobloomsConfig.BlueOrchidMoobloom.minGroupSize, MoobloomsConfig.BlueOrchidMoobloom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), MoobloomsConfig.AlliumMoobloom.weight, MoobloomsConfig.AlliumMoobloom.minGroupSize, MoobloomsConfig.AlliumMoobloom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), MoobloomsConfig.OxeyeDaisyMoobloom.weight, MoobloomsConfig.OxeyeDaisyMoobloom.minGroupSize, MoobloomsConfig.OxeyeDaisyMoobloom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), MoobloomsConfig.CornflowerMoobloom.weight, MoobloomsConfig.CornflowerMoobloom.minGroupSize, MoobloomsConfig.CornflowerMoobloom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), MoobloomsConfig.WitherRoseMoobloom.weight, MoobloomsConfig.WitherRoseMoobloom.minGroupSize, MoobloomsConfig.WitherRoseMoobloom.maxGroupSize));
			}
			
			if (biome.equals(REGISTRY.get(BiomeKeys.SUNFLOWER_PLAINS))) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.SUNCOWER.getEntityType(), MoobloomsConfig.Suncower.weight, MoobloomsConfig.Suncower.minGroupSize, MoobloomsConfig.Suncower.maxGroupSize));
			}
			
			if (biome.equals(REGISTRY.get(BiomeKeys.BAMBOO_JUNGLE)) || biome.equals(REGISTRY.get(BiomeKeys.BAMBOO_JUNGLE_HILLS))) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.BAMBMOO.getEntityType(), MoobloomsConfig.Bambmoo.weight, MoobloomsConfig.Bambmoo.minGroupSize, MoobloomsConfig.Bambmoo.maxGroupSize));
			}
			
			if (biome.equals(REGISTRY.get(BiomeKeys.CRIMSON_FOREST))) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), MoobloomsConfig.CrimsonMooshroom.weight, MoobloomsConfig.CrimsonMooshroom.minGroupSize, MoobloomsConfig.CrimsonMooshroom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), MoobloomsConfig.CrimsonCluckshroom.weight, MoobloomsConfig.CrimsonCluckshroom.minGroupSize, MoobloomsConfig.CrimsonCluckshroom.maxGroupSize));
			}
			
			if (biome.equals(REGISTRY.get(BiomeKeys.WARPED_FOREST))) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), MoobloomsConfig.WarpedMooshroom.weight, MoobloomsConfig.WarpedMooshroom.minGroupSize, MoobloomsConfig.WarpedMooshroom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.WarpedCluckshroom.weight, MoobloomsConfig.WarpedCluckshroom.minGroupSize, MoobloomsConfig.WarpedCluckshroom.maxGroupSize));
			}
			
			if (biome.getCategory().equals(Biome.Category.MUSHROOM)) {
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.RedCluckshroom.weight, MoobloomsConfig.RedCluckshroom.minGroupSize, MoobloomsConfig.RedCluckshroom.maxGroupSize));
				addSpawnToBiome(biome, new SpawnEntry(MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), MoobloomsConfig.BrownCluckshroom.weight, MoobloomsConfig.BrownCluckshroom.minGroupSize, MoobloomsConfig.BrownCluckshroom.maxGroupSize));
			}
		}
	}
	
	private static void addSpawnToBiome(Biome biome, SpawnSettings.SpawnEntry... spawners) {
		convertImmutableSpawners(biome);
		List<SpawnSettings.SpawnEntry> spawnersList = new ArrayList<>(((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners().get(SpawnGroup.CREATURE));
		spawnersList.addAll(Arrays.asList(spawners));
		((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners().put(SpawnGroup.CREATURE, spawnersList);
	}
	
	private static void convertImmutableSpawners(Biome biome) {
		if (((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners() instanceof ImmutableMap) {
			((SpawnSettingsAccessor) biome.getSpawnSettings()).setSpawners(new HashMap<>(((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners()));
		}
	}
	
	private static void registerSpawnRestrictions() {
		final SpawnRestriction.Location onGround = SpawnRestriction.Location.ON_GROUND;
		final Heightmap.Type motionBlocking = Heightmap.Type.MOTION_BLOCKING_NO_LEAVES;
		
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.SUNCOWER.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.BAMBMOO.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnMycelium);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnMycelium);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.invokeRegister(MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
	}
}
