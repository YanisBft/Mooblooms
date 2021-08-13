package com.yanisbft.mooblooms.init;

import com.yanisbft.mooblooms.entity.AnimalWithBlockState;

import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class MoobloomsSpawnRestrictions {

	public static void init() {
		final SpawnRestriction.Location onGround = SpawnRestriction.Location.ON_GROUND;
		final Heightmap.Type motionBlocking = Heightmap.Type.MOTION_BLOCKING_NO_LEAVES;
		
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.SUNCOWER.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.BAMBMOO.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.COWCTUS.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnBadlands);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.CHORUS_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnEnd);

		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestrictionAccessor.callRegister(MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
	}
}
