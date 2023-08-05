package com.yanisbft.mooblooms.init;

import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class MoobloomsSpawnRestrictions {

	public static void init() {
		final SpawnRestriction.Location onGround = SpawnRestriction.Location.ON_GROUND;
		final Heightmap.Type motionBlocking = Heightmap.Type.MOTION_BLOCKING_NO_LEAVES;
		
		SpawnRestriction.register(MoobloomsEntities.DANDELION_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.POPPY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.ALLIUM_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.CORNFLOWER_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.WITHER_ROSE_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(MoobloomsEntities.SUNCOWER.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.BAMBMOO.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.COWCTUS.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnBadlands);
		SpawnRestriction.register(MoobloomsEntities.CHORUS_MOOBLOOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnEnd);

		SpawnRestriction.register(MoobloomsEntities.CRIMSON_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(MoobloomsEntities.WARPED_MOOSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);

		SpawnRestriction.register(MoobloomsEntities.RED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.BROWN_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(MoobloomsEntities.CRIMSON_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(MoobloomsEntities.WARPED_CLUCKSHROOM.getEntityType(), onGround, motionBlocking, AnimalWithBlockState::canSpawnNether);
	}
}
