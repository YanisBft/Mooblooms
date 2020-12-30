package com.yanisbft.mooblooms.init;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;

public class MoobloomsEntities {
	private static final List<Block> NYLIUM = ImmutableList.of(Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM);
	
	public static final Moobloom DANDELION_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("dandelion_moobloom")).blockState(Blocks.DANDELION.getDefaultState()).spawnEgg(0xFED639, 0xFBEBAE).configCategory(Mooblooms.config.dandelionMoobloom).build();
	public static final Moobloom POPPY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("poppy_moobloom")).blockState(Blocks.POPPY.getDefaultState()).spawnEgg(0xBF2529, 0xFAB8B7).configCategory(Mooblooms.config.poppyMoobloom).build();
	public static final Moobloom BLUE_ORCHID_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("blue_orchid_moobloom")).blockState(Blocks.BLUE_ORCHID.getDefaultState()).spawnEgg(0x27A9F4, 0xABE3FB).configCategory(Mooblooms.config.blueOrchidMoobloom).build();
	public static final Moobloom ALLIUM_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("allium_moobloom")).blockState(Blocks.ALLIUM.getDefaultState()).spawnEgg(0xA65EE1, 0xE8CFFE).configCategory(Mooblooms.config.alliumMoobloom).build();
	public static final Moobloom OXEYE_DAISY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("oxeye_daisy_moobloom")).blockState(Blocks.OXEYE_DAISY.getDefaultState()).spawnEgg(0xD6E8E8, 0xFFEC4F).configCategory(Mooblooms.config.oxeyeDaisyMoobloom).build();
	public static final Moobloom CORNFLOWER_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("cornflower_moobloom")).blockState(Blocks.CORNFLOWER.getDefaultState()).spawnEgg(0x466AEB, 0xBAC2DF).configCategory(Mooblooms.config.cornflowerMoobloom).build();
	public static final Moobloom WITHER_ROSE_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("wither_rose_moobloom")).fireImmune().blockState(Blocks.WITHER_ROSE.getDefaultState()).ignoredEffects(ImmutableList.of(StatusEffects.WITHER)).particle(ParticleTypes.SMOKE).spawnEgg(0x2A1F19, 0x636363).configCategory(Mooblooms.config.witherRoseMoobloom).build();
	public static final Moobloom SUNCOWER = new Moobloom.Builder().name(Mooblooms.id("suncower")).blockState(Blocks.SUNFLOWER.getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER)).spawnEgg(0xF19D25, 0xFFEC4F).configCategory(Mooblooms.config.suncower).build();
	public static final Moobloom BAMBMOO = new Moobloom.Builder().name(Mooblooms.id("bambmoo")).blockState(Blocks.BAMBOO.getDefaultState().with(BambooBlock.LEAVES, BambooLeaves.SMALL)).spawnEgg(0x538209, 0x97D155).cannotPlaceBlocks().configCategory(Mooblooms.config.bambmoo).build();
	public static final Moobloom COWCTUS = new Moobloom.Builder().name(Mooblooms.id("cowctus")).blockState(Blocks.CACTUS.getDefaultState()).ignoredDamageSources(ImmutableList.of(DamageSource.CACTUS)).spawnEgg(0x39581A, 0x9FA76D).cannotPlaceBlocks().build();
	
	public static final Moobloom CRIMSON_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("crimson_mooshroom")).fireImmune().blockState(Blocks.CRIMSON_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x730408, 0xFF6500).configCategory(Mooblooms.config.crimsonMooshroom).build();
	public static final Moobloom WARPED_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("warped_mooshroom")).fireImmune().blockState(Blocks.WARPED_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x167E86, 0xFF6500).configCategory(Mooblooms.config.warpedMooshroom).build();
	
	public static final Cluckshroom RED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("red_cluckshroom")).blockState(Blocks.RED_MUSHROOM.getDefaultState()).spawnEgg(0xA0181F, 0xFA292A).configCategory(Mooblooms.config.redCluckshroom).build();
	public static final Cluckshroom BROWN_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("brown_cluckshroom")).blockState(Blocks.BROWN_MUSHROOM.getDefaultState()).spawnEgg(0x977251, 0xCC9978).configCategory(Mooblooms.config.brownCluckshroom).build();
	public static final Cluckshroom CRIMSON_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("crimson_cluckshroom")).fireImmune().blockState(Blocks.CRIMSON_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x730408, 0xA42429).configCategory(Mooblooms.config.crimsonCluckshroom).build();
	public static final Cluckshroom WARPED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("warped_cluckshroom")).fireImmune().blockState(Blocks.WARPED_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x167E86, 0x14B485).configCategory(Mooblooms.config.warpedCluckshroom).build();
}
