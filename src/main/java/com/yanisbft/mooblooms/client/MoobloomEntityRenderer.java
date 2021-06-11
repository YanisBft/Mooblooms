package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.entity.MoobloomEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MoobloomEntityRenderer extends MobEntityRenderer<MoobloomEntity, CowEntityModel<MoobloomEntity>> {

	public MoobloomEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new CowEntityModel(CowEntityModel.getTexturedModelData().createModel()), 0.7F);
		this.addFeature(new MoobloomBlockStateRenderer(this));
	}

	@Override
	public Identifier getTexture(MoobloomEntity moobloom) {
		String namespace = moobloom.settings.getName().getNamespace();
		String path = moobloom.settings.getName().getPath();
		return new Identifier(namespace, "textures/entity/" + path + ".png");
	}
}
