package com.yanisbft.mooblooms.init;

import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import com.yanisbft.mooblooms.mixin.SpawnRestrictionAccessor;

import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class MoobloomsSpawnRestrictions {

	public static void init() {
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
