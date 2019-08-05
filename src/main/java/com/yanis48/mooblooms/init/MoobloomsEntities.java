package com.yanis48.mooblooms.init;

import com.yanis48.mooblooms.Mooblooms;
import com.yanis48.mooblooms.entity.MoobloomEntity;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("deprecation")
public class MoobloomsEntities {
	
	public static final EntityType<MoobloomEntity> DANDELION_MOOBLOOM = register("dandelion_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> POPPY_MOOBLOOM = register("poppy_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> BLUE_ORCHID_MOOBLOOM = register("blue_orchid_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> ALLIUM_MOOBLOOM = register("allium_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> OXEYE_DAISY_MOOBLOOM = register("oxeye_daisy_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> CORNFLOWER_MOOBLOOM = register("cornflower_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> WITHER_ROSE_MOOBLOOM = register("wither_rose_moobloom", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	public static final EntityType<MoobloomEntity> BAMBMOO = register("bambmoo", FabricEntityTypeBuilder.create(EntityCategory.CREATURE, MoobloomEntity::new).size(0.9F, 1.4F).build());
	
	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(Mooblooms.MOD_ID, name), builder);
	}
}
