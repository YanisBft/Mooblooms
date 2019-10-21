package com.yanis48.mooblooms.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LayeredVertexConsumerStorage;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class MoobloomFlowerFeatureRenderer<T extends MoobloomEntity> extends FeatureRenderer<T, CowEntityModel<T>> {
	
	public MoobloomFlowerFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> rendererContext) {
		super(rendererContext);
	}

	@Override
	public void render(MatrixStack matrix, LayeredVertexConsumerStorage consumerStorage, int int_1, MoobloomEntity moobloom, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6, float float_7) {
		if (!moobloom.isBaby() && !moobloom.isInvisible()) {
			BlockRenderManager manager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = moobloom.getFlowerState();
			matrix.push();
			matrix.scale(-1.0F, -1.0F, 1.0F);
			matrix.translate(-0.20000000298023224D, 0.3499999940395355D, 0.5D);
			matrix.multiply(Vector3f.POSITIVE_Y.getRotationQuaternion(-42.0F));
			int int_2 = LivingEntityRenderer.method_23622(moobloom, 0.0F);
			matrix.push();
			matrix.translate(-0.5D, -0.5D, 0.5D);
			manager.renderDynamic(state, matrix, consumerStorage, int_1, int_2);
			matrix.pop();
			matrix.push();
			matrix.translate(-0.10000000149011612D, 0.0D, -0.6000000238418579D);
			matrix.multiply(Vector3f.POSITIVE_Y.getRotationQuaternion(-42.0F));
			matrix.translate(-0.5D, -0.5D, 0.5D);
			manager.renderDynamic(state, matrix, consumerStorage, int_1, int_2);
			matrix.pop();
			matrix.pop();
			matrix.push();
			this.getModel().getHead().rotate(matrix, 0.0625F);
			matrix.scale(-1.0F, -1.0F, 1.0F);
			matrix.translate(0.0D, 0.699999988079071D, -0.20000000298023224D);
			matrix.multiply(Vector3f.POSITIVE_Y.getRotationQuaternion(-12.0F));
			matrix.translate(-0.5D, -0.5D, 0.5D);
			manager.renderDynamic(state, matrix, consumerStorage, int_1, int_2);
			matrix.pop();
		}
	}
}
