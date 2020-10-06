package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.entity.CluckshroomEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CluckshroomEntityRenderer extends MobEntityRenderer<CluckshroomEntity, CluckshroomEntityModel<CluckshroomEntity>> {

	public CluckshroomEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new CluckshroomEntityModel(), 0.3F);
		this.addFeature(new CluckshroomBlockStateRenderer(this));
	}

	@Override
	public Identifier getTexture(CluckshroomEntity cluckshroom) {
		String namespace = cluckshroom.settings.getName().getNamespace();
		String path = cluckshroom.settings.getName().getPath();
		return new Identifier(namespace, "textures/entity/" + path + ".png");
	}
	
	@Override
	protected float getAnimationProgress(CluckshroomEntity cluckshroom, float f) {
		float g = MathHelper.lerp(f, cluckshroom.prevFlapProgress, cluckshroom.flapProgress);
		float h = MathHelper.lerp(f, cluckshroom.prevMaxWingDeviation, cluckshroom.maxWingDeviation);
		return (MathHelper.sin(g) + 1.0F) * h;
	}
}
