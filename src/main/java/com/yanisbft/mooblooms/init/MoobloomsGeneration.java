package com.yanisbft.mooblooms.init;

import java.util.function.Predicate;

import com.yanisbft.mooblooms.Mooblooms;
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
		
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), Mooblooms.config.dandelionMoobloom.weight, Mooblooms.config.dandelionMoobloom.minGroupSize, Mooblooms.config.dandelionMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), Mooblooms.config.poppyMoobloom.weight, Mooblooms.config.poppyMoobloom.minGroupSize, Mooblooms.config.poppyMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), Mooblooms.config.blueOrchidMoobloom.weight, Mooblooms.config.blueOrchidMoobloom.minGroupSize, Mooblooms.config.blueOrchidMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), Mooblooms.config.alliumMoobloom.weight, Mooblooms.config.alliumMoobloom.minGroupSize, Mooblooms.config.alliumMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), Mooblooms.config.oxeyeDaisyMoobloom.weight, Mooblooms.config.oxeyeDaisyMoobloom.minGroupSize, Mooblooms.config.oxeyeDaisyMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(flowerForest, SpawnGroup.CREATURE, MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), Mooblooms.config.cornflowerMoobloom.weight, Mooblooms.config.cornflowerMoobloom.minGroupSize, Mooblooms.config.cornflowerMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(nether, SpawnGroup.CREATURE, MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), Mooblooms.config.witherRoseMoobloom.weight, Mooblooms.config.witherRoseMoobloom.minGroupSize, Mooblooms.config.witherRoseMoobloom.maxGroupSize);
		BiomeModifications.addSpawn(sunflowerPlains, SpawnGroup.CREATURE, MoobloomsEntities.SUNCOWER.getEntityType(), Mooblooms.config.suncower.weight, Mooblooms.config.suncower.minGroupSize, Mooblooms.config.suncower.maxGroupSize);
		BiomeModifications.addSpawn(bambooJungle, SpawnGroup.CREATURE, MoobloomsEntities.BAMBMOO.getEntityType(), Mooblooms.config.bambmoo.weight, Mooblooms.config.bambmoo.minGroupSize, Mooblooms.config.bambmoo.maxGroupSize);
		BiomeModifications.addSpawn(crimsonForest, SpawnGroup.CREATURE, MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), Mooblooms.config.crimsonMooshroom.weight, Mooblooms.config.crimsonMooshroom.minGroupSize, Mooblooms.config.crimsonMooshroom.maxGroupSize);
		BiomeModifications.addSpawn(crimsonForest, SpawnGroup.CREATURE, MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), Mooblooms.config.crimsonCluckshroom.weight, Mooblooms.config.crimsonCluckshroom.minGroupSize, Mooblooms.config.crimsonCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(warpedForest, SpawnGroup.CREATURE, MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), Mooblooms.config.warpedMooshroom.weight, Mooblooms.config.warpedMooshroom.minGroupSize, Mooblooms.config.warpedMooshroom.maxGroupSize);
		BiomeModifications.addSpawn(warpedForest, SpawnGroup.CREATURE, MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), Mooblooms.config.warpedCluckshroom.weight, Mooblooms.config.warpedCluckshroom.minGroupSize, Mooblooms.config.warpedCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(mushroom, SpawnGroup.CREATURE, MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), Mooblooms.config.redCluckshroom.weight, Mooblooms.config.redCluckshroom.minGroupSize, Mooblooms.config.redCluckshroom.maxGroupSize);
		BiomeModifications.addSpawn(mushroom, SpawnGroup.CREATURE, MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), Mooblooms.config.brownCluckshroom.weight, Mooblooms.config.brownCluckshroom.minGroupSize, Mooblooms.config.brownCluckshroom.maxGroupSize);
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
