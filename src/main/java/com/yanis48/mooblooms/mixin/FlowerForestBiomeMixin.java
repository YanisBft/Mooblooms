package com.yanis48.mooblooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.yanis48.mooblooms.init.MoobloomsEntities;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FlowerForestBiome;

@Mixin(FlowerForestBiome.class)
public class FlowerForestBiomeMixin extends Biome {

	protected FlowerForestBiomeMixin(Settings settings) {
		super(settings);
	}
	
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.DANDELION_MOOBLOOM, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.POPPY_MOOBLOOM, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.ALLIUM_MOOBLOOM, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.CORNFLOWER_MOOBLOOM, 10, 2, 4));
	}
}
