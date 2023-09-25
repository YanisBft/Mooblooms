package com.yanisbft.mooblooms.init;

import com.google.common.collect.ImmutableList;
import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import com.yanisbft.mooblooms.api.SpawnEntry;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import net.minecraft.block.*;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;

import java.util.List;

public class MoobloomsEntities {
	private static final List<Block> NYLIUM = ImmutableList.of(Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM);

	public static final Moobloom DANDELION_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("dandelion_moobloom")).blockState(Blocks.DANDELION).spawnEntry(new SpawnEntry(Mooblooms.config.dandelionMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xFED639, 0xFBEBAE).configCategory(Mooblooms.config.dandelionMoobloom).build();
	public static final Moobloom POPPY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("poppy_moobloom")).blockState(Blocks.POPPY).spawnEntry(new SpawnEntry(Mooblooms.config.poppyMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xBF2529, 0xFAB8B7).configCategory(Mooblooms.config.poppyMoobloom).build();
	public static final Moobloom BLUE_ORCHID_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("blue_orchid_moobloom")).blockState(Blocks.BLUE_ORCHID).spawnEntry(new SpawnEntry(Mooblooms.config.blueOrchidMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x27A9F4, 0xABE3FB).configCategory(Mooblooms.config.blueOrchidMoobloom).build();
	public static final Moobloom ALLIUM_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("allium_moobloom")).blockState(Blocks.ALLIUM).spawnEntry(new SpawnEntry(Mooblooms.config.alliumMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xA65EE1, 0xE8CFFE).configCategory(Mooblooms.config.alliumMoobloom).build();
	public static final Moobloom OXEYE_DAISY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("oxeye_daisy_moobloom")).blockState(Blocks.OXEYE_DAISY).spawnEntry(new SpawnEntry(Mooblooms.config.oxeyeDaisyMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xD6E8E8, 0xFFEC4F).configCategory(Mooblooms.config.oxeyeDaisyMoobloom).build();
	public static final Moobloom CORNFLOWER_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("cornflower_moobloom")).blockState(Blocks.CORNFLOWER).spawnEntry(new SpawnEntry(Mooblooms.config.cornflowerMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x466AEB, 0xBAC2DF).configCategory(Mooblooms.config.cornflowerMoobloom).build();
	public static final Moobloom WITHER_ROSE_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("wither_rose_moobloom")).blockState(Blocks.WITHER_ROSE).fireImmune().ignoredEffects(ImmutableList.of(StatusEffects.WITHER)).spawnPredicate(AnimalWithBlockState::canSpawnNether).particle(ParticleTypes.SMOKE).spawnEntry(new SpawnEntry(Mooblooms.config.witherRoseMoobloom)).spawnEgg(0x2A1F19, 0x636363).configCategory(Mooblooms.config.witherRoseMoobloom).build();
	public static final Moobloom SUNCOWER = new Moobloom.Builder().name(Mooblooms.id("suncower")).blockState(Blocks.SUNFLOWER.getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER)).spawnEntry(new SpawnEntry(Mooblooms.config.suncower)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xF19D25, 0xFFEC4F).configCategory(Mooblooms.config.suncower).build();
	public static final Moobloom BAMBMOO = new Moobloom.Builder().name(Mooblooms.id("bambmoo")).blockState(Blocks.BAMBOO.getDefaultState().with(BambooBlock.LEAVES, BambooLeaves.SMALL)).spawnEntry(new SpawnEntry(Mooblooms.config.bambmoo)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x538209, 0x97D155).cannotPlaceBlocks().configCategory(Mooblooms.config.bambmoo).build();
	public static final Moobloom COWCTUS = new Moobloom.Builder().name(Mooblooms.id("cowctus")).blockState(Blocks.CACTUS).blockStateRenderer(-0.3F, -0.4F, 0.3F, -0.5D, -1.2D, -0.5D).ignoredDamageTypes(List.of(DamageTypes.CACTUS)).spawnEntry(new SpawnEntry(Mooblooms.config.cowctus)).spawnPredicate(AnimalWithBlockState::canSpawnBadlands).spawnEgg(0x39581A, 0x9FA76D).cannotPlaceBlocks().configCategory(Mooblooms.config.cowctus).build();
	public static final Moobloom CHERRY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("cherry_moobloom")).blockState(Blocks.CHERRY_SAPLING).blockStateRenderer(-0.7F, -0.7F, 0.7F, -0.5D, -0.7D, -0.5D).spawnEntry(new SpawnEntry(Mooblooms.config.cherryMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xF396CD, 0xE25692).configCategory(Mooblooms.config.cherryMoobloom).build();
	public static final Moobloom AZALEA_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("azalea_moobloom")).blockState(Blocks.FLOWERING_AZALEA).blockStateRenderer(-0.5F, -0.5F, 0.5F, -0.5D, -1.0D, -0.5D).spawnEntry(new SpawnEntry(Mooblooms.config.azaleaMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x70922D, 0xBA62CE).configCategory(Mooblooms.config.azaleaMoobloom).build();
	public static final Moobloom DRIPLEAF_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("dripleaf_moobloom")).blockState(Blocks.SMALL_DRIPLEAF.getDefaultState().with(SmallDripleafBlock.HALF, DoubleBlockHalf.UPPER)).blockStateRenderer(-0.6F, -0.6F, 0.6F, -0.5D, -0.8D, -0.5D).spawnEntry(new SpawnEntry(Mooblooms.config.dripleafMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x42552D, 0x98C440).cannotPlaceBlocks().configCategory(Mooblooms.config.dripleafMoobloom).build();
	public static final Moobloom CHORUS_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("chorus_moobloom")).blockState(Blocks.CHORUS_PLANT.getDefaultState().with(ChorusPlantBlock.DOWN, true)).blockStateRenderer(-0.5F, -0.6F, 0.5F, -0.5D, -0.8D, -0.5D).spawnEntry(new SpawnEntry(Mooblooms.config.chorusMoobloom)).spawnPredicate(AnimalWithBlockState::canSpawnEnd).spawnEgg(0x562E56, 0xD6BBD6).cannotPlaceBlocks().configCategory(Mooblooms.config.chorusMoobloom).build();

	public static final Moobloom CRIMSON_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("crimson_mooshroom")).blockState(Blocks.CRIMSON_FUNGUS).fireImmune().validBlocks(NYLIUM).spawnEntry(new SpawnEntry(Mooblooms.config.crimsonMooshroom)).spawnPredicate(AnimalWithBlockState::canSpawnNether).spawnEgg(0x730408, 0xFF6500).configCategory(Mooblooms.config.crimsonMooshroom).build();
	public static final Moobloom WARPED_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("warped_mooshroom")).blockState(Blocks.WARPED_FUNGUS).fireImmune().validBlocks(NYLIUM).spawnEntry(new SpawnEntry(Mooblooms.config.warpedMooshroom)).spawnPredicate(AnimalWithBlockState::canSpawnNether).spawnEgg(0x167E86, 0xFF6500).configCategory(Mooblooms.config.warpedMooshroom).build();

	public static final Cluckshroom RED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("red_cluckshroom")).blockState(Blocks.RED_MUSHROOM).spawnEntry(new SpawnEntry(Mooblooms.config.redCluckshroom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0xA0181F, 0xFA292A).configCategory(Mooblooms.config.redCluckshroom).build();
	public static final Cluckshroom BROWN_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("brown_cluckshroom")).blockState(Blocks.BROWN_MUSHROOM).spawnEntry(new SpawnEntry(Mooblooms.config.brownCluckshroom)).spawnPredicate(AnimalWithBlockState::canSpawn).spawnEgg(0x977251, 0xCC9978).configCategory(Mooblooms.config.brownCluckshroom).build();
	public static final Cluckshroom CRIMSON_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("crimson_cluckshroom")).blockState(Blocks.CRIMSON_FUNGUS).fireImmune().validBlocks(NYLIUM).spawnEntry(new SpawnEntry(Mooblooms.config.crimsonCluckshroom)).spawnPredicate(AnimalWithBlockState::canSpawnNether).spawnEgg(0x730408, 0xA42429).configCategory(Mooblooms.config.crimsonCluckshroom).build();
	public static final Cluckshroom WARPED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("warped_cluckshroom")).blockState(Blocks.WARPED_FUNGUS).fireImmune().validBlocks(NYLIUM).spawnEntry(new SpawnEntry(Mooblooms.config.warpedCluckshroom)).spawnPredicate(AnimalWithBlockState::canSpawnNether).spawnEgg(0x167E86, 0x14B485).configCategory(Mooblooms.config.warpedCluckshroom).build();

	public static void init() {
	}
}
