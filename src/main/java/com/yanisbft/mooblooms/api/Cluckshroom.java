package com.yanisbft.mooblooms.api;

import static com.google.common.base.Preconditions.checkState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yanisbft.mooblooms.config.MoobloomConfigCategory;
import com.yanisbft.mooblooms.entity.CluckshroomEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unchecked")
public class Cluckshroom extends AbstractMoobloom {
	public static final Map<EntityType<?>, Cluckshroom> CLUCKSHROOM_BY_TYPE = new HashMap<>();
	private EntityType<CluckshroomEntity> entityType;
	private SpawnEggItem spawnEgg;
	
	private Cluckshroom(Cluckshroom.Builder settings) {
		super(settings);
		
		FabricEntityTypeBuilder.Mob<?> builder = FabricEntityTypeBuilder.createMob()
				.entityFactory(CluckshroomEntity::new)
				.spawnGroup(SpawnGroup.CREATURE)
				.dimensions(EntityDimensions.fixed(0.4F, 0.7F))
				.trackRangeChunks(10)
				.defaultAttributes(CluckshroomEntity::createChickenAttributes);
		
		if (this.settings.fireImmune) {
			builder.fireImmune();
		}
		
		this.entityType = (EntityType<CluckshroomEntity>) builder.build();
		
		Registry.register(Registry.ENTITY_TYPE, this.settings.name, this.entityType);
		
		if (this.settings.primarySpawnEggColor != 0 && this.settings.secondarySpawnEggColor != 0) {
			this.spawnEgg = new SpawnEggItem(this.entityType, this.settings.primarySpawnEggColor, this.settings.secondarySpawnEggColor, new Item.Settings().maxCount(64).group(this.settings.spawnEggItemGroup));
			Identifier itemName = new Identifier(this.settings.name.getNamespace(), this.settings.name.getPath() + "_spawn_egg");
			Registry.register(Registry.ITEM, itemName, this.spawnEgg);
		}
		
		CLUCKSHROOM_BY_TYPE.putIfAbsent(this.entityType, this);
	}
	
	public EntityType<CluckshroomEntity> getEntityType() {
		return this.entityType;
	}
	
	public SpawnEggItem getSpawnEgg() {
		return this.spawnEgg;
	}
	
	public static class Builder extends AbstractMoobloom.Builder {
		
		public Builder() {
			super(EntityType.CHICKEN.getLootTableId());
		}
		
		/**
		 * Sets the name of this cluckshroom.
		 * @param name an {@linkplain Identifier}, consisting of a namespace and a path
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder name(Identifier name) {
			this.name = name;
			return this;
		}
		
		/**
		 * Sets this cluckshroom to be fire immune.
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder fireImmune() {
			this.fireImmune = true;
			return this;
		}
		
		/**
		 * Sets the block state related to this cluckshroom.
		 * <p>Will appear on this cluckshroom's back and be randomly placed on valid blocks.</p>
		 * <p>The item matching the block state will be dropped when shearing this cluckshroom.</p>
		 * @param state a block state
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder blockState(BlockState state) {
			this.blockState = state;
			return this;
		}
		
		/**
		 * Sets the blocks that are valid for placing the specified {@linkplain #blockState(BlockState)}.
		 * <p><i>Note: Can't be combined with {@linkplain #validBlocks(List)}</i></p>
		 * @param blocks a block tag
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder validBlocks(Tag<Block> blocks) {
			return this.validBlocks(blocks.values());
		}
		
		/**
		 * Sets the blocks that are valid for placing the specified {@linkplain #blockState(BlockState)}.
		 * <p><i>Note: Can't be combined with {@linkplain #validBlocks(Tag)}</i></p>
		 * @param blocks a list of blocks
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder validBlocks(List<Block> blocks) {
			this.validBlocks = blocks;
			return this;
		}
		
		/**
		 * Sets this cluckshroom to be unable to place blocks.
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder cannotPlaceBlocks() {
			this.canPlaceBlocks = false;
			return this;
		}
		
		/**
		 * Sets the status effects that will not affect this cluckshroom.
		 * @param effects a list of status effects
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder ignoredEffects(List<StatusEffect> effects) {
			this.ignoredEffects = effects;
			return this;
		}
		
		/**
		 * Sets the damage sources that will not affect this cluckshroom.
		 * @param damageSources a list of damage sources
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder ignoredDamageSources(List<DamageSource> damageSources) {
			this.ignoredDamageSources = damageSources;
			return this;
		}
		
		/**
		 * Sets the particle constantly displayed around this cluckshroom.
		 * @param particle a particle effect
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder particle(ParticleEffect particle) {
			this.particle = particle;
			return this;
		}
		
		/**
		 * Sets the loot table of this cluckshroom.
		 * <p>Defaults to {@linkplain net.minecraft.entity.passive.ChickenEntity chicken's} loot table.</p>
		 * @param lootTable a loot table {@linkplain net.minecraft.util.Identifier identifier}
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder lootTable(Identifier lootTable) {
			this.lootTable = lootTable;
			return this;
		}
		
		/**
		 * Sets this cluckshroom's spawn egg colors.
		 * <p>Will appear in {@linkplain ItemGroup#MISC}.</p>
		 * @param primaryColor an int representing the main color
		 * @param secondaryColor an int representing the dots' color
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnEgg(int primaryColor, int secondaryColor) {
			return this.spawnEgg(primaryColor, secondaryColor, ItemGroup.MISC);
		}
		
		/**
		 * Sets this cluckshroom's spawn egg colors and item group.
		 * @param primaryColor an int representing the main color
		 * @param secondaryColor an int representing the dots' color
		 * @param group an item group
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnEgg(int primaryColor, int secondaryColor, ItemGroup group) {
			this.primarySpawnEggColor = primaryColor;
			this.secondarySpawnEggColor = secondaryColor;
			this.spawnEggItemGroup = group;
			return this;
		}
		
		/**
		 * Sets this cluckshroom's config category.
		 * <p>Will be used to get the {@code spawnBlocks} config option.</p>
		 * @param configCategory an instance of a class implementing {@link MoobloomConfigCategory}
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder configCategory(MoobloomConfigCategory configCategory) {
			this.configCategory = configCategory;
			return this;
		}
		
		/**
		 * Creates the cluckshroom.
		 * @return a new {@linkplain Cluckshroom}
		 */
		public Cluckshroom build() {
			checkState(this.name != null, "A name is required to build a new cluckshroom.");
			checkState(this.blockState != null, "A block state is required to build a new cluckshroom.");
			return new Cluckshroom(this);
		}
	}
}
