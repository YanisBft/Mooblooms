package com.yanis48.mooblooms.client;

import com.yanis48.mooblooms.Mooblooms;
import com.yanis48.mooblooms.entity.CluckshroomEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CluckshroomEntityRenderer extends MobEntityRenderer<CluckshroomEntity, CluckshroomEntityModel<CluckshroomEntity>> {
	private static final Identifier SKIN = new Identifier(Mooblooms.MOD_ID, "textures/entity/cluckshroom.png");
	
	public CluckshroomEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new CluckshroomEntityModel(), 0.3F);
		this.addFeature(new CluckshroomMushroomFeatureRenderer(this));
	}

	@Override
	public Identifier getTexture(CluckshroomEntity cluckshroom) {
		return SKIN;
	}
	
	@Override
	protected float getAnimationProgress(CluckshroomEntity cluckshroom, float f) {
		float g = MathHelper.lerp(f, cluckshroom.prevFlapProgress, cluckshroom.flapProgress);
		float h = MathHelper.lerp(f, cluckshroom.prevMaxWingDeviation, cluckshroom.maxWingDeviation);
		return (MathHelper.sin(g) + 1.0F) * h;
	}
}
