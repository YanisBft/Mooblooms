package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.MoobloomEntityRenderState;
import com.yanisbft.mooblooms.entity.MoobloomEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MoobloomEntityRenderer extends AgeableMobEntityRenderer<MoobloomEntity, MoobloomEntityRenderState, CowEntityModel> {

	public MoobloomEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new CowEntityModel(CowEntityModel.getTexturedModelData().createModel()), new CowEntityModel(CowEntityModel.getTexturedModelData().createModel()), 0.7F);
		this.addFeature(new MoobloomBlockStateRenderer(this, context.getBlockRenderManager()));
	}

	@Override
	public MoobloomEntityRenderState createRenderState() {
		return new MoobloomEntityRenderState();
	}

	@Override
	public Identifier getTexture(MoobloomEntityRenderState state) {
		String namespace = state.name.getNamespace();
		String path = state.name.getPath();
		return Identifier.of(namespace, "textures/entity/" + path + ".png");
	}

	@Override
	public void updateRenderState(MoobloomEntity moobloom, MoobloomEntityRenderState state, float f) {
		super.updateRenderState(moobloom, state, f);
		state.name = moobloom.settings.getName();
		state.blockState = moobloom.settings.getBlockState();
		state.blockStateRendererScale = moobloom.settings.getBlockStateRendererScale();
		state.blockStateRendererTranslation = moobloom.settings.getBlockStateRendererTranslation();
		state.suncower = moobloom.isSuncower();
	}
}
