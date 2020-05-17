package com.yanis48.mooblooms.init;

import com.yanis48.mooblooms.Mooblooms;
import com.yanis48.mooblooms.entity.CluckshroomEntity;
import com.yanis48.mooblooms.entity.MoobloomEntity;
import com.yanis48.mooblooms.entity.MooshroomEntity;
import com.yanis48.mooblooms.entity.TallMoobloomEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("deprecation")
public class MoobloomsEntities {
	
	public static final EntityType<MoobloomEntity> DANDELION_MOOBLOOM = register("dandelion_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> POPPY_MOOBLOOM = register("poppy_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> BLUE_ORCHID_MOOBLOOM = register("blue_orchid_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> ALLIUM_MOOBLOOM = register("allium_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> OXEYE_DAISY_MOOBLOOM = register("oxeye_daisy_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> CORNFLOWER_MOOBLOOM = register("cornflower_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> WITHER_ROSE_MOOBLOOM = register("wither_rose_moobloom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).fireImmune().build());
	public static final EntityType<TallMoobloomEntity> SUNCOWER = register("suncower", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TallMoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	public static final EntityType<MoobloomEntity> BAMBMOO = register("bambmoo", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MoobloomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build());
	
	public static final EntityType<MooshroomEntity> CRIMSON_MOOSHROOM = register("crimson_mooshroom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooshroomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).fireImmune().build());
	public static final EntityType<MooshroomEntity> WARPED_MOOSHROOM = register("warped_mooshroom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooshroomEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).fireImmune().build());
	
	public static final EntityType<CluckshroomEntity> CLUCKSHROOM = register("cluckshroom", FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CluckshroomEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build());
	
	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(Mooblooms.MOD_ID, name), builder);
	}
	
	public static void registerEntityAttributes() {
		FabricDefaultAttributeRegistry.register(DANDELION_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(POPPY_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(BLUE_ORCHID_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(ALLIUM_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(OXEYE_DAISY_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(CORNFLOWER_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(WITHER_ROSE_MOOBLOOM, MoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(SUNCOWER, TallMoobloomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(BAMBMOO, MoobloomEntity.createCowAttributes());
		
		FabricDefaultAttributeRegistry.register(CRIMSON_MOOSHROOM, MooshroomEntity.createCowAttributes());
		FabricDefaultAttributeRegistry.register(WARPED_MOOSHROOM, MooshroomEntity.createCowAttributes());
		
		FabricDefaultAttributeRegistry.register(CLUCKSHROOM, CluckshroomEntity.createChickenAttributes());
	}
}
