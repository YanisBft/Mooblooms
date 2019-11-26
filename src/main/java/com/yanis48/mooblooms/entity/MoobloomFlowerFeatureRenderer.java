package com.yanis48.mooblooms.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

@Environment(EnvType.CLIENT)
public class MoobloomFlowerFeatureRenderer<T extends MoobloomEntity> extends FeatureRenderer<T, CowEntityModel<T>> {
	
	public MoobloomFlowerFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> rendererContext) {
		super(rendererContext);
	}

	@Override
	public void render(MatrixStack matrix, VertexConsumerProvider vertexConsumerProvider, int i, MoobloomEntity moobloom, float f, float g, float h, float j, float k, float l) {
		if (!moobloom.isBaby() && !moobloom.isInvisible()) {
			BlockRenderManager manager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = moobloom.getFlowerState();
			int m = LivingEntityRenderer.method_23622(moobloom, 0.0F);
			matrix.push();
			matrix.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
			matrix.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-48.0F));
			matrix.scale(-1.0F, -1.0F, 1.0F);
			matrix.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrix, vertexConsumerProvider, i, m);
			matrix.pop();
			matrix.push();
			matrix.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
			matrix.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(42.0F));
			matrix.translate(0.10000000149011612D, 0.0D, -0.6000000238418579D);
			matrix.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-48.0F));
			matrix.scale(-1.0F, -1.0F, 1.0F);
			matrix.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrix, vertexConsumerProvider, i, m);
			matrix.pop();
			matrix.push();
			this.getModel().getHead().rotate(matrix);
			matrix.translate(0.0D, -0.699999988079071D, -0.20000000298023224D);
			matrix.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-78.0F));
			matrix.scale(-1.0F, -1.0F, 1.0F);
			matrix.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrix, vertexConsumerProvider, i, m);
			matrix.pop();
		}
	}
}
