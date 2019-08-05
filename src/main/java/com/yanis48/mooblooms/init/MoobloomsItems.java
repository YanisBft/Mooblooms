package com.yanis48.mooblooms.init;

import com.yanis48.mooblooms.Mooblooms;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("rawtypes")
public class MoobloomsItems {
	
	public static final Item DANDELION_MOOBLOOM_SPAWN_EGG = register("dandelion_moobloom", MoobloomsEntities.DANDELION_MOOBLOOM, 16700985, 16509870);
	public static final Item POPPY_MOOBLOOM_SPAWN_EGG = register("poppy_moobloom", MoobloomsEntities.POPPY_MOOBLOOM, 12526889, 16431287);
	public static final Item BLUE_ORCHID_MOOBLOOM_SPAWN_EGG = register("blue_orchid_moobloom", MoobloomsEntities.BLUE_ORCHID_MOOBLOOM, 2599412, 11265019);
	public static final Item ALLIUM_MOOBLOOM_SPAWN_EGG = register("allium_moobloom", MoobloomsEntities.ALLIUM_MOOBLOOM, 10903265, 15257598);
	public static final Item OXEYE_DAISY_MOOBLOOM_SPAWN_EGG = register("oxeye_daisy_moobloom", MoobloomsEntities.OXEYE_DAISY_MOOBLOOM, 14084328, 16772175);
	public static final Item CORNFLOWER_MOOBLOOM_SPAWN_EGG = register("cornflower_moobloom", MoobloomsEntities.CORNFLOWER_MOOBLOOM, 4614891, 12239583);
	public static final Item WITHER_ROSE_MOOBLOOM_SPAWN_EGG = register("wither_rose_moobloom", MoobloomsEntities.WITHER_ROSE_MOOBLOOM, 2760473, 6513507);
	public static final Item BAMBMOO_SPAWN_EGG = register("bambmoo", MoobloomsEntities.BAMBMOO, 5472777, 9949525);
	
	private static Item register(String name, EntityType entity, int primaryColor, int secondaryColor) {
		return Registry.register(Registry.ITEM, new Identifier(Mooblooms.MOD_ID, name + "_spawn_egg"), new SpawnEggItem(entity, primaryColor, secondaryColor, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
	}
}
