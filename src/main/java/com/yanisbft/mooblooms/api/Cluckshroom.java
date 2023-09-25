package com.yanisbft.mooblooms.api;

import com.yanisbft.mooblooms.config.MoobloomConfigCategory;
import com.yanisbft.mooblooms.entity.AnimalWithBlockState;
import com.yanisbft.mooblooms.entity.CluckshroomEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.google.common.base.Preconditions.checkState;

@SuppressWarnings("unchecked")
public class Cluckshroom extends AbstractMoobloom {
	public static final Map<EntityType<?>, Cluckshroom> CLUCKSHROOM_BY_TYPE = new HashMap<>();
	private final EntityType<CluckshroomEntity> entityType;
	private SpawnEggItem spawnEgg;

	private Cluckshroom(Cluckshroom.Builder settings) {
		super(settings);

		FabricEntityTypeBuilder.Mob<?> builder = FabricEntityTypeBuilder.createMob()
				.entityFactory(CluckshroomEntity::new)
				.spawnGroup(SpawnGroup.CREATURE)
				.spawnRestriction(SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (SpawnRestriction.SpawnPredicate<CluckshroomEntity>) settings.spawnPredicate)
				.dimensions(EntityDimensions.changing(0.4F, 0.7F))
				.trackRangeChunks(10)
				.defaultAttributes(CluckshroomEntity::createChickenAttributes);

		if (this.settings.fireImmune) {
			builder.fireImmune();
		}

		this.entityType = (EntityType<CluckshroomEntity>) builder.build();

		Registry.register(Registries.ENTITY_TYPE, this.settings.name, this.entityType);

		if (this.settings.primarySpawnEggColor != 0 && this.settings.secondarySpawnEggColor != 0) {
			this.spawnEgg = new SpawnEggItem(this.entityType, this.settings.primarySpawnEggColor, this.settings.secondarySpawnEggColor, new Item.Settings().maxCount(64));
			ItemGroupEvents.modifyEntriesEvent(this.settings.spawnEggItemGroup).register((entries) -> entries.add(this.spawnEgg));
			Identifier itemName = new Identifier(this.settings.name.getNamespace(), this.settings.name.getPath() + "_spawn_egg");
			Registry.register(Registries.ITEM, itemName, this.spawnEgg);
		}

		if (this.settings.spawnEntry != null && this.isSpawnEnabled()) {
			Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.tag(TagKey.of(RegistryKeys.BIOME, settings.name.withPrefixedPath("spawns_")));
			BiomeModifications.addSpawn(biomeSelector, this.settings.spawnGroup, this.entityType, this.settings.spawnEntry.getWeight(), this.settings.spawnEntry.getMinGroupSize(), this.settings.spawnEntry.getMaxGroupSize());
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
		 * Sets the block state related to this cluckshroom, from the default state of a block.
		 * <p>Will appear on this cluckshroom's back and be randomly placed on valid blocks.</p>
		 * <p>The item matching the block state will be dropped when shearing this cluckshroom.</p>
		 * @param block a block
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder blockState(Block block) {
			return blockState(block.getDefaultState());
		}

		/**
		 * Sets how the block state of this cluckshroom will be rendered on its back.
		 * @param scaleX the scale on the X axis
		 * @param scaleY the scale on the Y axis
		 * @param scaleZ the scale on the Z axis
		 * @param translationX the translation on the X axis
		 * @param translationY the translation on the Y axis
		 * @param translationZ the translation on the Z axis
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder blockStateRenderer(float scaleX, float scaleY, float scaleZ, double translationX, double translationY, double translationZ) {
			return this.blockStateRenderer(new Vector3f(scaleX, scaleY, scaleZ), new Vec3d(translationX, translationY, translationZ));
		}

		/**
		 * Sets how the block state of this cluckshroom will be rendered on its back.
		 * @param scale a vector representing the scale
		 * @param translation a vector representing the translation
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder blockStateRenderer(Vector3f scale, Vec3d translation) {
			this.blockStateRendererScale = scale;
			this.blockStateRendererTranslation = translation;
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
		 * Sets the blocks that are valid for placing the specified {@linkplain #blockState(BlockState)}.
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
		 * Sets the damage types that will not affect this cluckshroom.
		 * @param damageTypes a list of damage sources
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder ignoredDamageTypes(List<RegistryKey<DamageType>> damageTypes) {
			this.ignoredDamageTypes = damageTypes;
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
		 * Sets the spawn entry used to generate this cluckshroom.
		 * @param spawnEntry a {@linkplain SpawnEntry spawn entry}
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnEntry(SpawnEntry spawnEntry) {
			this.spawnEntry = spawnEntry;
			return this;
		}

		/**
		 * Sets the spawn group of this cluckshroom.
		 * <p>Defaults to {@link SpawnGroup#CREATURE}.</p>
		 * @param spawnGroup a {@linkplain SpawnGroup spawn group}
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnGroup(SpawnGroup spawnGroup) {
			this.spawnGroup = spawnGroup;
			return this;
		}

		/**
		 * Sets the spawn predicate used to restrict where this cluckshroom can spawn.
		 * @param spawnPredicate a {@linkplain SpawnRestriction.SpawnPredicate spawn predicate}
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnPredicate(SpawnRestriction.SpawnPredicate<? extends AnimalWithBlockState> spawnPredicate) {
			this.spawnPredicate = spawnPredicate;
			return this;
		}

		/**
		 * Sets this cluckshroom's spawn egg colors.
		 * <p>Will appear in {@linkplain ItemGroups#SPAWN_EGGS}.</p>
		 * @param primaryColor an int representing the main color
		 * @param secondaryColor an int representing the dots' color
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnEgg(int primaryColor, int secondaryColor) {
			return this.spawnEgg(primaryColor, secondaryColor, ItemGroups.SPAWN_EGGS);
		}

		/**
		 * Sets this cluckshroom's spawn egg colors and item group.
		 * @param primaryColor an int representing the main color
		 * @param secondaryColor an int representing the dots' color
		 * @param group an item group
		 * @return this builder for chaining
		 */
		public Cluckshroom.Builder spawnEgg(int primaryColor, int secondaryColor, RegistryKey<ItemGroup> group) {
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
