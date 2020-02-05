package com.yanis48.mooblooms.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MooshroomEntity extends MoobloomEntity {

	public MooshroomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	public BlockState getFlowerState() {
		String flowerName = this.getIdPath().replace("mooshroom", "fungi");
		BlockState state = Registry.BLOCK.get(new Identifier("minecraft", flowerName)).getDefaultState();
		return state;
	}
}
