package com.yanis48.mooblooms.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.state.property.Properties;

public interface AnimalWithBlockState {

	default void placeBlocks(AnimalEntity entity, BlockState state) {
		if (state.getBlock() instanceof TallPlantBlock) {
			entity.world.setBlockState(entity.getBlockPos(), state.cycle(Properties.DOUBLE_BLOCK_HALF));
			entity.world.setBlockState(entity.getBlockPos().up(), state);
		} else {
			entity.world.setBlockState(entity.getBlockPos(), state);
		}
	}
	
	default boolean canSpawnBlocks(Class<?> configClass) {
		boolean enabled = true;
		
		if (configClass != null) {
			try {
				enabled = configClass.getDeclaredField("spawnBlocks").getBoolean(null);
			} catch (IllegalArgumentException | IllegalAccessException | SecurityException | NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		
		return enabled;
	}
}
