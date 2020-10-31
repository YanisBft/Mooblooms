package com.yanisbft.mooblooms.init;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import com.yanisbft.mooblooms.config.MoobloomsConfig;

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
	
	public static final Moobloom DANDELION_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("dandelion_moobloom")).blockState(Blocks.DANDELION.getDefaultState()).spawnEgg(0xFED639, 0xFBEBAE).configClass(MoobloomsConfig.DandelionMoobloom.class).build();
	public static final Moobloom POPPY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("poppy_moobloom")).blockState(Blocks.POPPY.getDefaultState()).spawnEgg(0xBF2529, 0xFAB8B7).configClass(MoobloomsConfig.PoppyMoobloom.class).build();
	public static final Moobloom BLUE_ORCHID_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("blue_orchid_moobloom")).blockState(Blocks.BLUE_ORCHID.getDefaultState()).spawnEgg(0x27A9F4, 0xABE3FB).configClass(MoobloomsConfig.BlueOrchidMoobloom.class).build();
	public static final Moobloom ALLIUM_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("allium_moobloom")).blockState(Blocks.ALLIUM.getDefaultState()).spawnEgg(0xA65EE1, 0xE8CFFE).configClass(MoobloomsConfig.AlliumMoobloom.class).build();
	public static final Moobloom OXEYE_DAISY_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("oxeye_daisy_moobloom")).blockState(Blocks.OXEYE_DAISY.getDefaultState()).spawnEgg(0xD6E8E8, 0xFFEC4F).configClass(MoobloomsConfig.OxeyeDaisyMoobloom.class).build();
	public static final Moobloom CORNFLOWER_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("cornflower_moobloom")).blockState(Blocks.CORNFLOWER.getDefaultState()).spawnEgg(0x466AEB, 0xBAC2DF).configClass(MoobloomsConfig.CornflowerMoobloom.class).build();
	public static final Moobloom WITHER_ROSE_MOOBLOOM = new Moobloom.Builder().name(Mooblooms.id("wither_rose_moobloom")).fireImmune().blockState(Blocks.WITHER_ROSE.getDefaultState()).ignoredEffects(ImmutableList.of(StatusEffects.WITHER)).particle(ParticleTypes.SMOKE).spawnEgg(0x2A1F19, 0x636363).configClass(MoobloomsConfig.WitherRoseMoobloom.class).build();
	public static final Moobloom SUNCOWER = new Moobloom.Builder().name(Mooblooms.id("suncower")).blockState(Blocks.SUNFLOWER.getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER)).spawnEgg(0xF19D25, 0xFFEC4F).configClass(MoobloomsConfig.Suncower.class).build();
	public static final Moobloom BAMBMOO = new Moobloom.Builder().name(Mooblooms.id("bambmoo")).blockState(Blocks.BAMBOO.getDefaultState().with(BambooBlock.LEAVES, BambooLeaves.SMALL)).spawnEgg(0x538209, 0x97D155).cannotPlaceBlocks().configClass(MoobloomsConfig.Bambmoo.class).build();
	public static final Moobloom COWCTUS = new Moobloom.Builder().name(Mooblooms.id("cowctus")).blockState(Blocks.CACTUS.getDefaultState()).ignoredDamageSources(ImmutableList.of(DamageSource.CACTUS)).spawnEgg(0x39581A, 0x9FA76D).cannotPlaceBlocks().build();
	
	public static final Moobloom CRIMSON_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("crimson_mooshroom")).fireImmune().blockState(Blocks.CRIMSON_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x730408, 0xFF6500).configClass(MoobloomsConfig.CrimsonMooshroom.class).build();
	public static final Moobloom WARPED_MOOSHROOM = new Moobloom.Builder().name(Mooblooms.id("warped_mooshroom")).fireImmune().blockState(Blocks.WARPED_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x167E86, 0xFF6500).configClass(MoobloomsConfig.WarpedMooshroom.class).build();
	
	public static final Cluckshroom RED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("red_cluckshroom")).blockState(Blocks.RED_MUSHROOM.getDefaultState()).spawnEgg(0xA0181F, 0xFA292A).configClass(MoobloomsConfig.RedCluckshroom.class).build();
	public static final Cluckshroom BROWN_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("brown_cluckshroom")).blockState(Blocks.BROWN_MUSHROOM.getDefaultState()).spawnEgg(0x977251, 0xCC9978).configClass(MoobloomsConfig.RedCluckshroom.class).build();
	public static final Cluckshroom CRIMSON_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("crimson_cluckshroom")).fireImmune().blockState(Blocks.CRIMSON_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x730408, 0xA42429).configClass(MoobloomsConfig.CrimsonCluckshroom.class).build();
	public static final Cluckshroom WARPED_CLUCKSHROOM = new Cluckshroom.Builder().name(Mooblooms.id("warped_cluckshroom")).fireImmune().blockState(Blocks.WARPED_FUNGUS.getDefaultState()).validBlocks(NYLIUM).spawnEgg(0x167E86, 0x14B485).configClass(MoobloomsConfig.WarpedCluckshroom.class).build();
}
