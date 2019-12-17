package com.yanis48.mooblooms.client;

import com.yanis48.mooblooms.Mooblooms;
import com.yanis48.mooblooms.entity.MoobloomEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MoobloomEntityRenderer extends MobEntityRenderer<MoobloomEntity, CowEntityModel<MoobloomEntity>> {
	
	public MoobloomEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new CowEntityModel(), 0.7F);
		this.addFeature(new MoobloomFlowerFeatureRenderer(this));
	}

	@Override
	public Identifier getTexture(MoobloomEntity moobloom) {
		return new Identifier(Mooblooms.MOD_ID, "textures/entity/" + moobloom.id + ".png");
	}	
}
