package com.yanisbft.mooblooms.api;

import com.google.common.collect.ImmutableList;
import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.config.MoobloomConfigCategory;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMoobloom {
	private static final Logger LOGGER = LogManager.getLogger("Mooblooms API");
	protected AbstractMoobloom.Builder settings;

	public AbstractMoobloom(AbstractMoobloom.Builder settings) {
		this.settings = settings;

		if (Mooblooms.config.showApiLogs) {
			LOGGER.log(Level.INFO, "Registered " + this.settings.name);
		}
	}

	protected boolean isSpawnEnabled() {
		if (this.settings.configCategory != null) {
			try {
				return this.settings.configCategory.getClass().getDeclaredField("spawnEnabled").getBoolean(this.settings.configCategory);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public Identifier getName() {
		return this.settings.name;
	}

	public BlockState getBlockState() {
		return this.settings.blockState;
	}

	public Vector3f getBlockStateRendererScale() {
		return this.settings.blockStateRendererScale;
	}

	public Vec3d getBlockStateRendererTranslation() {
		return this.settings.blockStateRendererTranslation;
	}

	public boolean isFireImmune() {
		return this.settings.fireImmune;
	}

	public List<Block> getValidBlocks() {
		return this.settings.validBlocks;
	}

	public boolean canPlaceBlocks() {
		return this.settings.canPlaceBlocks;
	}

	public List<StatusEffect> getIgnoredEffects() {
		return this.settings.ignoredEffects;
	}

	public List<RegistryKey<DamageType>> getIgnoredDamageTypes() {
		return this.settings.ignoredDamageTypes;
	}

	public ParticleEffect getParticle() {
		return this.settings.particle;
	}

	public Identifier getLootTable() {
		return this.settings.lootTable;
	}

	public SpawnEntry getSpawnEntry() {
		return this.settings.spawnEntry;
	}

	public SpawnGroup getSpawnGroup() {
		return this.settings.spawnGroup;
	}

	public SpawnRestriction.SpawnPredicate<? extends AnimalWithBlockState> getSpawnPredicate() {
		return this.settings.spawnPredicate;
	}

	public int getPrimarySpawnEggColor() {
		return this.settings.primarySpawnEggColor;
	}

	public int getSecondarySpawnEggColor() {
		return this.settings.secondarySpawnEggColor;
	}

	public RegistryKey<ItemGroup> getSpawnEggItemGroup() {
		return this.settings.spawnEggItemGroup;
	}

	public MoobloomConfigCategory getConfigCategory() {
		return this.settings.configCategory;
	}

	public static class Builder {
		protected Identifier name;
		protected BlockState blockState;
		protected Vector3f blockStateRendererScale;
		protected Vec3d blockStateRendererTranslation;
		protected boolean fireImmune;
		protected List<Block> validBlocks;
		protected boolean canPlaceBlocks;
		protected List<StatusEffect> ignoredEffects;
		protected List<RegistryKey<DamageType>> ignoredDamageTypes;
		protected ParticleEffect particle;
		protected Identifier lootTable;
		protected SpawnEntry spawnEntry;
		protected SpawnGroup spawnGroup;
		protected SpawnRestriction.SpawnPredicate<? extends AnimalWithBlockState> spawnPredicate;
		protected int primarySpawnEggColor;
		protected int secondarySpawnEggColor;
		protected RegistryKey<ItemGroup> spawnEggItemGroup;
		protected MoobloomConfigCategory configCategory;

		public Builder(Identifier defaultLootTable) {
			this.blockStateRendererScale = new Vector3f(-1.0F, -1.0F, 1.0F);
			this.blockStateRendererTranslation = new Vec3d(-0.5D, -0.5D, -0.5D);
			this.validBlocks = ImmutableList.of(Blocks.GRASS_BLOCK);
			this.canPlaceBlocks = true;
			this.ignoredEffects = new ArrayList<>();
			this.ignoredDamageTypes = new ArrayList<>();
			this.lootTable = defaultLootTable;
			this.spawnGroup = SpawnGroup.CREATURE;
		}
	}
}
