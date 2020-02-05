package com.yanis48.mooblooms.init;

import com.yanis48.mooblooms.Mooblooms;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoobloomsItems {
	
	public static final Item DANDELION_MOOBLOOM_SPAWN_EGG = register("dandelion_moobloom", MoobloomsEntities.DANDELION_MOOBLOOM, 0xFED639, 0xFBEBAE);
	public static final Item POPPY_MOOBLOOM_SPAWN_EGG = register("poppy_moobloom", MoobloomsEntities.POPPY_MOOBLOOM, 0xBF2529, 0xFAB8B7);
	public static final Item BLUE_ORCHID_MOOBLOOM_SPAWN_EGG = register("blue_orchid_moobloom", MoobloomsEntities.BLUE_ORCHID_MOOBLOOM, 0x27A9F4, 0xABE3FB);
	public static final Item ALLIUM_MOOBLOOM_SPAWN_EGG = register("allium_moobloom", MoobloomsEntities.ALLIUM_MOOBLOOM, 0xA65EE1, 0xE8CFFE);
	public static final Item OXEYE_DAISY_MOOBLOOM_SPAWN_EGG = register("oxeye_daisy_moobloom", MoobloomsEntities.OXEYE_DAISY_MOOBLOOM, 0xD6E8E8, 0xFFEC4F);
	public static final Item CORNFLOWER_MOOBLOOM_SPAWN_EGG = register("cornflower_moobloom", MoobloomsEntities.CORNFLOWER_MOOBLOOM, 0x466AEB, 0xBAC2DF);
	public static final Item WITHER_ROSE_MOOBLOOM_SPAWN_EGG = register("wither_rose_moobloom", MoobloomsEntities.WITHER_ROSE_MOOBLOOM, 0x2A1F19, 0x636363);
	public static final Item SUNCOWER_SPAWN_EGG = register("suncower", MoobloomsEntities.SUNCOWER, 0xF19D25, 0xFFEC4F);
	public static final Item BAMBMOO_SPAWN_EGG = register("bambmoo", MoobloomsEntities.BAMBMOO, 0x538209, 0x97D155);
	
	public static final Item CRIMSON_MOOSHROOM_SPAWN_EGG = register("crimson_mooshroom", MoobloomsEntities.CRIMSON_MOOSHROOM, 0x730408, 0xFF6500);
	public static final Item WARPED_MOOSHROOM_SPAWN_EGG = register("warped_mooshroom", MoobloomsEntities.WARPED_MOOSHROOM, 0x167E86, 0xFF6500);
	
	public static final Item CLUCKSHROOM_SPAWN_EGG = register("cluckshroom", MoobloomsEntities.CLUCKSHROOM, 0xA0181F, 0xFA292A);
	
	private static Item register(String name, EntityType<?> entity, int primaryColor, int secondaryColor) {
		return Registry.register(Registry.ITEM, new Identifier(Mooblooms.MOD_ID, name + "_spawn_egg"), new SpawnEggItem(entity, primaryColor, secondaryColor, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
	}
}
