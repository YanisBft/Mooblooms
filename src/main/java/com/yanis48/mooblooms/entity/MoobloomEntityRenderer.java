package com.yanis48.mooblooms.entity;

import com.yanis48.mooblooms.Mooblooms;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MoobloomEntityRenderer extends MobEntityRenderer<MoobloomEntity, CowEntityModel<MoobloomEntity>> {
	private static final Identifier BAMBMOO_SKIN = new Identifier(Mooblooms.MOD_ID, "textures/entity/bambmoo.png");
	
	public MoobloomEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher, new CowEntityModel(), 0.7F);
		this.addFeature(new MoobloomFlowerFeatureRenderer(this));
	}

	@Override
	public Identifier getTexture(MoobloomEntity moobloom) {
		if (moobloom.isBambmoo()) {
			return BAMBMOO_SKIN;
		} else {
			return new Identifier(Mooblooms.MOD_ID, "textures/entity/" + moobloom.id + ".png");
		}
	}	
}
