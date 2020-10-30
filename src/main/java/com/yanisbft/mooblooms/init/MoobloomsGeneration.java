package com.yanisbft.mooblooms.init;

import java.util.function.Predicate;

import com.yanisbft.mooblooms.config.MoobloomsConfig;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import com.yanisbft.mooblooms.mixin.SpawnRestrictionAccessor;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

@SuppressWarnings("deprecation")
public class MoobloomsGeneration {

	public static void init() {
		registerSpawnRestrictions();
		
		Predicate<BiomeSelectionContext> flowerForest = BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST);
		Predicate<BiomeSelectionContext> nether = BiomeSelectors.categories(Biome.Category.NETHER);
		Predicate<BiomeSelectionContext> sunflowerPlains = BiomeSelectors.includeByKey(BiomeKeys.SUNFLOWER_PLAINS);
		Predicate<BiomeSelectionContext> bambooJungle = BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.BAMBOO_JUNGLE_HILLS);
		Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST);
		Predicate<BiomeSelectionContext> warpedForest = BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST);
		Predicate<BiomeSelectionContext> mushroom = BiomeSelectors.categories(Biome.Category.MUSHROOM);
		
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), MoobloomsConfig.DandelionMoobloom.weight, MoobloomsConfig.DandelionMoobloom.minGroupSize, MoobloomsConfig.DandelionMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), MoobloomsConfig.PoppyMoobloom.weight, MoobloomsConfig.PoppyMoobloom.minGroupSize, MoobloomsConfig.PoppyMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), MoobloomsConfig.BlueOrchidMoobloom.weight, MoobloomsConfig.BlueOrchidMoobloom.minGroupSize, MoobloomsConfig.BlueOrchidMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), MoobloomsConfig.AlliumMoobloom.weight, MoobloomsConfig.AlliumMoobloom.minGroupSize, MoobloomsConfig.AlliumMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), MoobloomsConfig.OxeyeDaisyMoobloom.weight, MoobloomsConfig.OxeyeDaisyMoobloom.minGroupSize, MoobloomsConfig.OxeyeDaisyMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), MoobloomsConfig.CornflowerMoobloom.weight, MoobloomsConfig.CornflowerMoobloom.minGroupSize, MoobloomsConfig.CornflowerMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(nether, SpawnGroup.CREATURE, MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), MoobloomsConfig.WitherRoseMoobloom.weight, MoobloomsConfig.WitherRoseMoobloom.minGroupSize, MoobloomsConfig.WitherRoseMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(sunflowerPlains, SpawnGroup.CREATURE, MoobloomsEntities.SUNCOWER.getEntityType(), MoobloomsConfig.Suncower.weight, MoobloomsConfig.Suncower.minGroupSize, MoobloomsConfig.Suncower.maxGroupSize);
		BiomeModifications.addSpawn(bambooJungle, SpawnGroup.CREATURE, MoobloomsEntities.BAMBMOO.getEntityType(), MoobloomsConfig.Bambmoo.weight, MoobloomsConfig.Bambmoo.minGroupSize, MoobloomsConfig.Bambmoo.maxGroupSize);
		BiomeModifications.addSpawn(crimsonForest, SpawnGroup.CREATURE, MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), MoobloomsConfig.CrimsonMooshroom.weight, MoobloomsConfig.CrimsonMooshroom.minGroupSize, MoobloomsConfig.CrimsonMooshroom.maxGroupSize);
		BiomeModifications.addSpawn(crimsonForest, SpawnGroup.CREATURE, MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), MoobloomsConfig.CrimsonCluckshroom.weight, MoobloomsConfig.CrimsonCluckshroom.minGroupSize, MoobloomsConfig.CrimsonCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(warpedForest, SpawnGroup.CREATURE, MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), MoobloomsConfig.WarpedMooshroom.weight, MoobloomsConfig.WarpedMooshroom.minGroupSize, MoobloomsConfig.WarpedMooshroom.maxGroupSize);
		BiomeModifications.addSpawn(warpedForest, SpawnGroup.CREATURE, MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.WarpedCluckshroom.weight, MoobloomsConfig.WarpedCluckshroom.minGroupSize, MoobloomsConfig.WarpedCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(mushroom, SpawnGroup.CREATURE, MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), MoobloomsConfig.RedCluckshroom.weight, MoobloomsConfig.RedCluckshroom.minGroupSize, MoobloomsConfig.RedCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(mushroom, SpawnGroup.CREATURE, MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), MoobloomsConfig.BrownCluckshroom.weight, MoobloomsConfig.BrownCluckshroom.minGroupSize, MoobloomsConfig.BrownCluckshroom.maxGroupSize);
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
