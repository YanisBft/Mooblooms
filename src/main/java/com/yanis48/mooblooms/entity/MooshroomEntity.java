package com.yanis48.mooblooms.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class MooshroomEntity extends MoobloomEntity {

	public MooshroomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected boolean isUnderneathBlockValid(Block block) {
		return BlockTags.NYLIUM.contains(block);
	}
	
	@Override
	protected void placeBlocks() {
		if (this.getEntityWorld().getDimension().getType() == DimensionType.THE_NETHER) {
			super.placeBlocks();
		}
	}
	
	@Override
	public BlockState getFlowerState() {
		String flowerName = this.getIdPath().replace("mooshroom", "fungus");
		BlockState state = Registry.BLOCK.get(new Identifier("minecraft", flowerName)).getDefaultState();
		return state;
	}
}
