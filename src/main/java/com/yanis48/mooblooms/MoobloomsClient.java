package com.yanis48.mooblooms;

import com.yanis48.mooblooms.api.Cluckshroom;
import com.yanis48.mooblooms.api.Moobloom;
import com.yanis48.mooblooms.client.CluckshroomEntityRenderer;
import com.yanis48.mooblooms.client.MoobloomEntityRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class MoobloomsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Register entity renderers for mooblooms
		for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values()) {
			EntityRendererRegistry.INSTANCE.register(moobloom.getEntityType(), (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		}
		
		// Register entity renderers for cluckshrooms
		for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values()) {
			EntityRendererRegistry.INSTANCE.register(cluckshroom.getEntityType(), (dispatcher, context) -> new CluckshroomEntityRenderer(dispatcher));
		}
	}
}
