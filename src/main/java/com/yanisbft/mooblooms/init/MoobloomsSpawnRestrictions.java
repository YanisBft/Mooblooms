package com.yanisbft.mooblooms.init;

import static com.yanisbft.mooblooms.init.MoobloomsEntities.*;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class MoobloomsSpawnRestrictions {
	public static void init() {
		final SpawnRestriction.Location onGround = SpawnRestriction.Location.ON_GROUND;
		final Heightmap.Type hm = Heightmap.Type.MOTION_BLOCKING_NO_LEAVES;

		SpawnRestriction.register(DANDELION_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(POPPY_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(BLUE_ORCHID_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(ALLIUM_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(OXEYE_DAISY_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(CORNFLOWER_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(WITHER_ROSE_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(SUNCOWER.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(BAMBMOO.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(COWCTUS.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnBadlands);
		SpawnRestriction.register(CHORUS_MOOBLOOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnEnd);

		SpawnRestriction.register(CRIMSON_MOOSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(WARPED_MOOSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnNether);

		SpawnRestriction.register(RED_CLUCKSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(BROWN_CLUCKSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawn);
		SpawnRestriction.register(CRIMSON_CLUCKSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnNether);
		SpawnRestriction.register(WARPED_CLUCKSHROOM.getEntityType(), onGround, hm, AnimalWithBlockState::canSpawnNether);
	}
}
