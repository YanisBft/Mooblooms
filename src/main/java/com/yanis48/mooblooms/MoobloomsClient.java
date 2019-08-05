package com.yanis48.mooblooms;

import com.yanis48.mooblooms.entity.MoobloomEntity;
import com.yanis48.mooblooms.entity.MoobloomEntityRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

public class MoobloomsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(MoobloomEntity.class, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
	}
}
