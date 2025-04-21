package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.CluckshroomEntityRenderState;
import com.yanisbft.mooblooms.entity.CluckshroomEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityRenderer extends AgeableMobEntityRenderer<CluckshroomEntity, CluckshroomEntityRenderState, ChickenEntityModel> {

	public CluckshroomEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ChickenEntityModel(context.getPart(EntityModelLayers.CHICKEN)), new ChickenEntityModel(context.getPart(EntityModelLayers.CHICKEN_BABY)), 0.3F);
		this.addFeature(new CluckshroomBlockStateRenderer(this, context.getBlockRenderManager()));
	}

	@Override
	public CluckshroomEntityRenderState createRenderState() {
		return new CluckshroomEntityRenderState();
	}

	@Override
	public Identifier getTexture(CluckshroomEntityRenderState state) {
		String namespace = state.name.getNamespace();
		String path = state.name.getPath();
		return Identifier.of(namespace, "textures/entity/" + path + ".png");
	}

	@Override
	public void updateRenderState(CluckshroomEntity cluckshroom, CluckshroomEntityRenderState state, float f) {
		super.updateRenderState(cluckshroom, state, f);
		state.flapProgress = MathHelper.lerp(f, cluckshroom.prevFlapProgress, cluckshroom.flapProgress);
		state.maxWingDeviation = MathHelper.lerp(f, cluckshroom.prevMaxWingDeviation, cluckshroom.maxWingDeviation);
		state.name = cluckshroom.settings.getName();
		state.blockState = cluckshroom.settings.getBlockState();
		state.blockStateRendererScale = cluckshroom.settings.getBlockStateRendererScale();
		state.blockStateRendererTranslation = cluckshroom.settings.getBlockStateRendererTranslation();
	}
}
