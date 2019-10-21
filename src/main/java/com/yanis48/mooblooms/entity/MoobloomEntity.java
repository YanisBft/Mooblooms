package com.yanis48.mooblooms.entity;

import com.yanis48.mooblooms.Mooblooms;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SuspiciousStewItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoobloomEntity extends CowEntity {
	public final String id;
	
	public MoobloomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
		super(entityType, world);
		this.id = Registry.ENTITY_TYPE.getId(entityType).getPath();
	}
	
	public boolean interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.getItem() == Items.SHEARS && this.getBreedingAge() >= 0) {
			this.world.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + this.getHeight() / 2.0F, this.getZ(), 0.0D, 0.0D, 0.0D);
			if (!this.world.isClient) {
				this.remove();
				CowEntity cow = EntityType.COW.create(this.world);
				cow.setPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, this.pitch);
				cow.setHealth(this.getHealth());
				cow.bodyYaw = this.bodyYaw;
				if (this.hasCustomName()) {
					cow.setCustomName(this.getCustomName());
				}
				this.world.spawnEntity(cow);
				for(int i = 0; i < 5; ++i) {
					this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getY() + this.getHeight(), this.getZ(), new ItemStack(this.getFlowerState().getBlock())));
				}
				stack.damage(1, player, ((playerEntity) -> {
					playerEntity.sendToolBreakStatus(hand);
				}));
				this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
			}
			return true;
		} else if (stack.getItem() == Items.MUSHROOM_STEW && this.getBreedingAge() >= 0 && !this.isBambmoo()) {
			stack.decrement(1);
			ItemStack suspiciousStew = new ItemStack(Items.SUSPICIOUS_STEW);
			FlowerBlock flowerBlock = (FlowerBlock) this.getFlowerState().getBlock();
			SuspiciousStewItem.addEffectToStew(suspiciousStew, flowerBlock.getEffectInStew(), flowerBlock.getEffectInStewDuration());
			player.setStackInHand(hand, suspiciousStew);
			this.playSound(SoundEvents.ENTITY_MOOSHROOM_SUSPICIOUS_MILK, 1.0F, 1.0F);
			return true;
		} else {
			return super.interactMob(player, hand);
		}
	}
	
	@Override
	public MoobloomEntity createChild(PassiveEntity entity) {
		return (MoobloomEntity) Registry.ENTITY_TYPE.get(new Identifier(Mooblooms.MOD_ID, this.id)).create(this.world);
	}
	
	@Override
	public boolean canHaveStatusEffect(StatusEffectInstance statusEffectInstance) {
		if (statusEffectInstance.getEffectType() == StatusEffects.WITHER && this.isWitherRose()) {
			return false;
		}
		return super.canHaveStatusEffect(statusEffectInstance);
	}
	
	public void tickMovement() {
		if (!this.world.isClient && !this.isBambmoo() && !this.isBaby()) {
			Block blockUnderneath = this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1, this.getZ())).getBlock();
			if (blockUnderneath == Blocks.GRASS_BLOCK && this.world.isAir(this.getBlockPos())) {
				int i = this.random.nextInt(1000);
				if (i == 0) {
					this.world.setBlockState(this.getBlockPos(), this.getFlowerState());
				}
			}
		}
		if (this.world.isClient && this.isWitherRose()) {
			for(int i = 0; i < 3; ++i) {
				this.world.addParticle(ParticleTypes.SMOKE, this.getX() + (this.random.nextDouble() - 0.5D) * this.getWidth(), this.getY() + this.random.nextDouble() * this.getHeight(), this.getZ() + (this.random.nextDouble() - 0.5D) * this.getWidth(), 0.0D, 0.0D, 0.0D);
			}
		}
		super.tickMovement();
	}
	
	public boolean isWitherRose() {
		return this.id.equals("wither_rose_moobloom") ? true : false;
	}
	
	public boolean isBambmoo() {
		return this.id.equals("bambmoo") ? true : false;
	}
	
	public BlockState getFlowerState() {
		BlockState state;
		if (this.isBambmoo()) {
			state = Blocks.BAMBOO.getDefaultState().with(BambooBlock.LEAVES, BambooLeaves.SMALL);
		} else {
			String flowerId = this.id.replace("_moobloom", "");
			state = Registry.BLOCK.get(new Identifier("minecraft", flowerId)).getDefaultState();
		}
		return state;
	}
}
