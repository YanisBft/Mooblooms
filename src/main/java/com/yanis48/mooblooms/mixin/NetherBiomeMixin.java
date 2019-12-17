package com.yanis48.mooblooms.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.yanis48.mooblooms.MoobloomsConfig;
import com.yanis48.mooblooms.init.MoobloomsEntities;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.NetherBiome;

@Mixin(NetherBiome.class)
public class NetherBiomeMixin extends Biome {
	
	protected NetherBiomeMixin(Settings settings) {
		super(settings);
	}
	
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(MoobloomsEntities.WITHER_ROSE_MOOBLOOM, MoobloomsConfig.SpawnWeight.witherRoseMoobloom, 2, 4));
	}
}
