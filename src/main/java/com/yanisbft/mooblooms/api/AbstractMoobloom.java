package com.yanisbft.mooblooms.api;

import com.google.common.collect.ImmutableList;
import com.yanisbft.mooblooms.config.MoobloomConfigCategory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMoobloom {
	private static final Logger LOGGER = LogManager.getLogger("Mooblooms API");
	protected AbstractMoobloom.Builder settings;

	public AbstractMoobloom(AbstractMoobloom.Builder settings) {
		this.settings = settings;

		LOGGER.log(Level.INFO, "Registered " + this.settings.name);
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
	
	public boolean isFireImmune() {
		return this.settings.fireImmune;
	}
	
	public BlockState getBlockState() {
		return this.settings.blockState;
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
	
	public List<DamageSource> getIgnoredDamageSources() {
		return this.settings.ignoredDamageSources;
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
	
	public int getPrimarySpawnEggColor() {
		return this.settings.primarySpawnEggColor;
	}
	
	public int getSecondarySpawnEggColor() {
		return this.settings.secondarySpawnEggColor;
	}
	
	public ItemGroup getSpawnEggItemGroup() {
		return this.settings.spawnEggItemGroup;
	}
	
	public MoobloomConfigCategory getConfigCategory() {
		return this.settings.configCategory;
	}
	
	public static class Builder {
		protected Identifier name;
		protected boolean fireImmune;
		protected BlockState blockState;
		protected List<Block> validBlocks;
		protected boolean canPlaceBlocks;
		protected List<StatusEffect> ignoredEffects;
		protected List<DamageSource> ignoredDamageSources;
		protected ParticleEffect particle;
		protected Identifier lootTable;
		protected SpawnEntry spawnEntry;
		protected int primarySpawnEggColor;
		protected int secondarySpawnEggColor;
		protected ItemGroup spawnEggItemGroup;
		protected MoobloomConfigCategory configCategory;

		public Builder(Identifier defaultLootTable) {
			this.validBlocks = ImmutableList.of(Blocks.GRASS_BLOCK);
			this.canPlaceBlocks = true;
			this.ignoredEffects = new ArrayList<>();
			this.ignoredDamageSources = new ArrayList<>();
			this.lootTable = defaultLootTable;
		}
	}
}
