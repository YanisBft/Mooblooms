package com.yanis48.mooblooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.yanis48.mooblooms.MoobloomsConfig;
import com.yanis48.mooblooms.init.MoobloomsEntities;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.BambooJungleBiome;
import net.minecraft.world.biome.Biome;

@Mixin(BambooJungleBiome.class)
public class BambooJungleBiomeMixin extends Biome {
	
	protected BambooJungleBiomeMixin(Settings settings) {
		super(settings);
	}
	
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.BAMBMOO, MoobloomsConfig.SpawnWeight.bambmoo, 2, 4));
	}
}
