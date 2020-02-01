package com.yanis48.mooblooms.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class TallMoobloomEntity extends MoobloomEntity {

	public TallMoobloomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void placeBlocks() {
		this.world.setBlockState(this.getBlockPos(), this.getStemState());
		this.world.setBlockState(this.getBlockPos().up(), this.getFlowerState());
	}
	
	@Override
	public BlockState getFlowerState() {
		BlockState state;
		if (this.isSuncower()) {
			state = Blocks.SUNFLOWER.getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER);
		} else {
			String flowerName = this.getIdPath().replace("_moobloom", "");
			state = Registry.BLOCK.get(new Identifier("minecraft", flowerName)).getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER);
		}
		return state;
	}
	
	public BlockState getStemState() {
		BlockState state;
		if (this.isSuncower()) {
			state = Blocks.SUNFLOWER.getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER);
		} else {
			String flowerName = this.getIdPath().replace("_moobloom", "");
			state = Registry.BLOCK.get(new Identifier("minecraft", flowerName)).getDefaultState().with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER);
		}
		return state;
	}
}
