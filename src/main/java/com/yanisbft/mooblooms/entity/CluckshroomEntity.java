package com.yanisbft.mooblooms.entity;

import com.yanisbft.mooblooms.api.Cluckshroom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.conversion.EntityConversionContext;
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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.rule.GameRules;

public class CluckshroomEntity extends ChickenEntity implements AnimalWithBlockState, Shearable {
	public Cluckshroom settings;

	public CluckshroomEntity(EntityType<? extends CluckshroomEntity> entityType, World world) {
		super(entityType, world);
		this.settings = Cluckshroom.CLUCKSHROOM_BY_TYPE.get(entityType);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() == Items.SHEARS && this.isShearable()) {
			if (this.getEntityWorld() instanceof ServerWorld serverWorld) {
				this.sheared(serverWorld, SoundCategory.PLAYERS, stack);
				this.emitGameEvent(GameEvent.SHEAR, player);
				stack.damage(1, player, hand.getEquipmentSlot());
			}

			return ActionResult.SUCCESS;
		}

		return super.interactMob(player, hand);
	}

	@Override
	public void sheared(ServerWorld world, SoundCategory shearedSoundCategory, ItemStack shears) {
		world.playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
		this.convertTo(EntityType.CHICKEN, EntityConversionContext.create(this, false, false), chicken -> {
			world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5), this.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
			Block block = this.settings.getBlockStateProvider().apply(this.getEntityWorld()).getBlock();
			for (int i = 0; i < 5; i++) {
				this.getEntityWorld().spawnEntity(new ItemEntity(this.getEntityWorld(), this.getX(), this.getY() + this.getHeight(), this.getZ(), new ItemStack(block)));
			}
		});
	}

	@Override
	public boolean isShearable() {
		return this.isAlive() && !this.isBaby();
	}

	@Override
	public CluckshroomEntity createChild(ServerWorld world, PassiveEntity entity) {
		return this.settings.getEntityType().create(world, SpawnReason.BREEDING);
	}

	@Override
	public boolean canHaveStatusEffect(StatusEffectInstance statusEffectInstance) {
		if (this.settings.getIgnoredEffects().contains(statusEffectInstance.getEffectType().value())) {
			return false;
		}

		return super.canHaveStatusEffect(statusEffectInstance);
	}

	@Override
	public boolean isInvulnerableTo(ServerWorld world, DamageSource source) {
		for (RegistryKey<DamageType> ignoredDamageType : this.settings.getIgnoredDamageTypes()) {
			if (source.isOf(ignoredDamageType)) {
				return true;
			}
		}

		return super.isInvulnerableTo(world, source);
	}

	@Override
	public void tickMovement() {
		if (this.canPlaceBlocks()) {
			Block blockUnderneath = this.getEntityWorld().getBlockState(new BlockPos(this.getBlockX(), this.getBlockY() - 1, this.getBlockZ())).getBlock();
			if (this.settings.getValidBlocks().contains(blockUnderneath) && this.getEntityWorld().isAir(this.getBlockPos())) {
				int i = this.random.nextInt(1000);
				if (i == 0) {
					BlockState state = this.settings.getBlockStateProvider().apply(this.getEntityWorld());
					this.placeBlocks(this, state);
				}
			}
		}

		if (this.getEntityWorld().isClient() && this.settings.getParticle() != null) {
			for (int i = 0; i < 3; i++) {
				this.getEntityWorld().addParticleClient(this.settings.getParticle(), this.getX() + (this.random.nextDouble() - 0.5D) * this.getWidth(), this.getY() + this.random.nextDouble() * this.getHeight(), this.getZ() + (this.random.nextDouble() - 0.5D) * this.getWidth(), 0.0D, 0.0D, 0.0D);
			}
		}

		super.tickMovement();
	}

	private boolean canPlaceBlocks() {
		return this.getEntityWorld() instanceof ServerWorld serverWorld
				&& serverWorld.getGameRules().getValue(GameRules.DO_MOB_GRIEFING)
				&& this.settings.canPlaceBlocks()
				&& !this.isBaby()
				&& this.canSpawnBlocks(this.settings.getConfigCategory());
	}

	@Override
	public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
		return true;
	}

	@Override
	public boolean canSpawn(WorldView world) {
		return true;
	}
}
