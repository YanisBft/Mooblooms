package com.yanis48.mooblooms;

import com.yanis48.mooblooms.entity.MoobloomEntityRenderer;
import com.yanis48.mooblooms.init.MoobloomsEntities;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class MoobloomsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.DANDELION_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.POPPY_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.ALLIUM_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.CORNFLOWER_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.WITHER_ROSE_MOOBLOOM, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
		EntityRendererRegistry.INSTANCE.register(MoobloomsEntities.BAMBMOO, (dispatcher, context) -> new MoobloomEntityRenderer(dispatcher));
	}
}
