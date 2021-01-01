package com.yanisbft.mooblooms.entity;

import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.Moobloom;
import com.yanisbft.mooblooms.init.MoobloomsEntities;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SuspiciousStewItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoobloomEntity extends CowEntity implements AnimalWithBlockState {
	public Moobloom settings;
	
	public MoobloomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
		super(entityType, world);
		this.settings = Moobloom.MOOBLOOM_BY_TYPE.get(entityType);
	}
	
	@Override
	public Identifier getLootTableId() {
		return this.settings.getLootTable();
	}
	
	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.getItem() == Items.SHEARS && this.getBreedingAge() >= 0) {
			this.world.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + this.getHeight() / 2.0F, this.getZ(), 0.0D, 0.0D, 0.0D);
			if (!this.world.isClient) {
				this.remove();
				CowEntity cow = EntityType.COW.create(this.world);
				cow.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.yaw, this.pitch);
				cow.setHealth(this.getHealth());
				cow.bodyYaw = this.bodyYaw;
				if (this.hasCustomName()) {
					cow.setCustomName(this.getCustomName());
				}
				this.world.spawnEntity(cow);
				for (int i = 0; i < 5; i++) {
					this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getY() + this.getHeight(), this.getZ(), new ItemStack(this.settings.getBlockState().getBlock())));
				}
				stack.damage(1, player, ((playerEntity) -> {
					playerEntity.sendToolBreakStatus(hand);
				}));
				this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
			}
			return ActionResult.success(this.world.isClient);
		} else if (stack.getItem() == Items.MUSHROOM_STEW && this.getBreedingAge() >= 0 && (this.settings.getBlockState().getBlock() instanceof FlowerBlock)) {
			stack.decrement(1);
			ItemStack suspiciousStew = new ItemStack(Items.SUSPICIOUS_STEW);
			FlowerBlock flowerBlock = (FlowerBlock) this.settings.getBlockState().getBlock();
			SuspiciousStewItem.addEffectToStew(suspiciousStew, flowerBlock.getEffectInStew(), flowerBlock.getEffectInStewDuration());
			player.setStackInHand(hand, suspiciousStew);
			this.playSound(SoundEvents.ENTITY_MOOSHROOM_SUSPICIOUS_MILK, 1.0F, 1.0F);
			return ActionResult.success(this.world.isClient);
		} else {
			return super.interactMob(player, hand);
		}
	}
	
	@Override
	public MoobloomEntity createChild(ServerWorld world, PassiveEntity entity) {
		return this.settings.getEntityType().create(world);
	}
	
	@Override
	public boolean canHaveStatusEffect(StatusEffectInstance statusEffectInstance) {
		if (this.settings.getIgnoredEffects().contains(statusEffectInstance.getEffectType())) {
			return false;
		}
		
		return super.canHaveStatusEffect(statusEffectInstance);
	}
	
	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		if (this.settings.getIgnoredDamageSources().contains(source)) {
			return true;
		}
		
		return super.isInvulnerableTo(source);
	}
	
	@Override
	public void onPlayerCollision(PlayerEntity player) {
		if (!player.abilities.creativeMode && player.getPos().isInRange(this.getPos(), 1.5D)) {
			if (this.isWitherRose() && Mooblooms.config.witherRoseMoobloom.damagePlayers) {
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 0));
			} else if (this.isCowctus() && Mooblooms.config.cowctus.damagePlayers) {
				player.damage(DamageSource.CACTUS, 1.0F);
			}
		}
		
		super.onPlayerCollision(player);
	}
	
	@Override
	public void tickMovement() {
		if (this.canSpawnBlocks(this.settings.getConfigCategory())) {
			if (!this.world.isClient && !this.isBaby() && this.settings.canPlaceBlocks()) {
				Block blockUnderneath = this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1, this.getZ())).getBlock();
				if (this.settings.getValidBlocks().contains(blockUnderneath) && this.world.isAir(this.getBlockPos())) {
					int i = this.random.nextInt(1000);
					if (i == 0) {
						this.placeBlocks(this, this.settings.getBlockState());
					}
				}
			}
		}
		
		if (this.world.isClient && this.settings.getParticle() != null) {
			for (int i = 0; i < 3; i++) {
				this.world.addParticle(this.settings.getParticle(), this.getX() + (this.random.nextDouble() - 0.5D) * this.getWidth(), this.getY() + this.random.nextDouble() * this.getHeight(), this.getZ() + (this.random.nextDouble() - 0.5D) * this.getWidth(), 0.0D, 0.0D, 0.0D);
			}
		}
		
		super.tickMovement();
	}
	
	public boolean isWitherRose() {
		return this.settings.equals(MoobloomsEntities.WITHER_ROSE_MOOBLOOM);
	}
	
	public boolean isSuncower() {
		return this.settings.equals(MoobloomsEntities.SUNCOWER);
	}
	
	public boolean isCowctus() {
		return this.settings.equals(MoobloomsEntities.COWCTUS);
	}
}
