package com.yanis48.mooblooms.entity;

import com.yanis48.mooblooms.MoobloomsConfig;
import com.yanis48.mooblooms.init.MoobloomsEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CluckshroomEntity extends ChickenEntity {

	public CluckshroomEntity(EntityType<? extends ChickenEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	public boolean interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.getItem() == Items.SHEARS && this.getBreedingAge() >= 0) {
			this.world.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + this.getHeight() / 2.0F, this.getZ(), 0.0D, 0.0D, 0.0D);
			if (!this.world.isClient) {
				this.remove();
				ChickenEntity chicken = EntityType.CHICKEN.create(this.world);
				chicken.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, this.pitch);
				chicken.setHealth(this.getHealth());
				chicken.bodyYaw = this.bodyYaw;
				if (this.hasCustomName()) {
					chicken.setCustomName(this.getCustomName());
				}
				this.world.spawnEntity(chicken);
				for(int i = 0; i < 3; ++i) {
					this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getY() + this.getHeight(), this.getZ(), new ItemStack(this.getMushroomState().getBlock())));
				}
				stack.damage(1, player, ((playerEntity) -> {
					playerEntity.sendToolBreakStatus(hand);
				}));
				this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
			}
			return true;
		} else {
			return super.interactMob(player, hand);
		}
	}
	
	@Override
	public CluckshroomEntity createChild(PassiveEntity entity) {
		return (CluckshroomEntity) MoobloomsEntities.CLUCKSHROOM.create(this.world);
	}
	
	@Override
	public void tickMovement() {
		if (MoobloomsConfig.Cluckshroom.spawnBlocks) {
			if (!this.world.isClient && !this.isBaby()) {
				Block blockUnderneath = this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1, this.getZ())).getBlock();
				if (blockUnderneath == Blocks.GRASS_BLOCK && this.world.isAir(new BlockPos(this.getPos()))) {
					int i = this.random.nextInt(1000);
					if (i == 0) {
						this.world.setBlockState(new BlockPos(this.getPos()), this.getMushroomState());
					}
				}
			}
		}
		super.tickMovement();
	}
	
	public BlockState getMushroomState() {
		return Blocks.RED_MUSHROOM.getDefaultState();
	}
}
