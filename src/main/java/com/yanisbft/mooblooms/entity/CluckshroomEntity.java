package com.yanisbft.mooblooms.entity;

import com.yanisbft.mooblooms.api.Cluckshroom;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CluckshroomEntity extends ChickenEntity implements AnimalWithBlockState {
	public Cluckshroom settings;
	
	public CluckshroomEntity(EntityType<? extends CluckshroomEntity> entityType, World world) {
		super(entityType, world);
		this.settings = Cluckshroom.CLUCKSHROOM_BY_TYPE.get(entityType);
	}
	
	@Override
	public Identifier getLootTableId() {
		return this.settings.getLootTable();
	}
	
	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.getItem() == Items.SHEARS && this.getBreedingAge() >= 0) {
			this.getWorld().addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY() + this.getHeight() / 2.0F, this.getZ(), 0.0D, 0.0D, 0.0D);
			if (!this.getWorld().isClient) {
				this.discard();
				ChickenEntity chicken = EntityType.CHICKEN.create(this.getWorld());
				chicken.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
				chicken.setHealth(this.getHealth());
				chicken.bodyYaw = this.bodyYaw;
				if (this.hasCustomName()) {
					chicken.setCustomName(this.getCustomName());
				}
				this.getWorld().spawnEntity(chicken);
				for(int i = 0; i < 3; ++i) {
					this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY() + this.getHeight(), this.getZ(), new ItemStack(this.settings.getBlockState().getBlock())));
				}
				stack.damage(1, player, ((playerEntity) -> {
					playerEntity.sendToolBreakStatus(hand);
				}));
				this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0F, 1.0F);
			}
			return ActionResult.success(this.getWorld().isClient);
		} else {
			return super.interactMob(player, hand);
		}
	}
	
	@Override
	public CluckshroomEntity createChild(ServerWorld world, PassiveEntity entity) {
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
		for (RegistryKey<DamageType> ignoredDamageType : this.settings.getIgnoredDamageTypes()) {
			if (source.isOf(ignoredDamageType)) {
				return true;
			}
		}

		return super.isInvulnerableTo(source);
	}
	
	@Override
	public void tickMovement() {
		if (this.canSpawnBlocks(this.settings.getConfigCategory())) {
			if (!this.getWorld().isClient && !this.isBaby() && this.settings.canPlaceBlocks()) {
				Block blockUnderneath = this.getWorld().getBlockState(new BlockPos(this.getBlockX(), this.getBlockY() - 1, this.getBlockZ())).getBlock();
				if (this.settings.getValidBlocks().contains(blockUnderneath) && this.getWorld().isAir(this.getBlockPos())) {
					int i = this.random.nextInt(1000);
					if (i == 0) {
						this.placeBlocks(this, this.settings.getBlockState());
					}
				}
			}
		}
		
		if (this.getWorld().isClient && this.settings.getParticle() != null) {
			for (int i = 0; i < 3; i++) {
				this.getWorld().addParticle(this.settings.getParticle(), this.getX() + (this.random.nextDouble() - 0.5D) * this.getWidth(), this.getY() + this.random.nextDouble() * this.getHeight(), this.getZ() + (this.random.nextDouble() - 0.5D) * this.getWidth(), 0.0D, 0.0D, 0.0D);
			}
		}
		
		super.tickMovement();
	}
}
