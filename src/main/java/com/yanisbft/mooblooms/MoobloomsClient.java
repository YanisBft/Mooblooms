package com.yanisbft.mooblooms;

import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import com.yanisbft.mooblooms.client.CluckshroomEntityRenderer;
import com.yanisbft.mooblooms.client.MoobloomEntityRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoobloomsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Register entity renderers for mooblooms
		for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values()) {
			EntityRendererRegistry.register(moobloom.getEntityType(), MoobloomEntityRenderer::new);
		}

		// Register entity renderers for cluckshrooms
		for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values()) {
			EntityRendererRegistry.register(cluckshroom.getEntityType(), CluckshroomEntityRenderer::new);
		}
	}
}
