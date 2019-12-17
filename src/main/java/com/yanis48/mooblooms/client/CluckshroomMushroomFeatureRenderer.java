package com.yanis48.mooblooms.client;

import com.yanis48.mooblooms.entity.CluckshroomEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

@Environment(EnvType.CLIENT)
public class CluckshroomMushroomFeatureRenderer<T extends CluckshroomEntity> extends FeatureRenderer<T, ChickenEntityModel<T>> {

	public CluckshroomMushroomFeatureRenderer(FeatureRendererContext<T, ChickenEntityModel<T>> context) {
		super(context);
	}
	
	public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T cluckshroom, float f, float g, float h, float j, float k, float l) {
		if (!cluckshroom.isBaby() && !cluckshroom.isInvisible()) {
			BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = cluckshroom.getMushroomState();
			int m = LivingEntityRenderer.getOverlay(cluckshroom, 0.0F);
			
			matrixStack.push();
			matrixStack.translate(0.0D, 0.36D, 0.15D);
			matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-6.0F));
			matrixStack.scale(-1.0F, -1.0F, 1.0F);
			matrixStack.translate(-0.5D, -0.5D, -0.5D);
			blockRenderManager.renderBlockAsEntity(state, matrixStack, vertexConsumerProvider, i, m);
			matrixStack.pop();
			
			matrixStack.push();
			matrixStack.translate(0.03D, 0.08D, -0.28D);
			matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-48.0F));
			matrixStack.scale(-1.0F, -1.0F, 1.0F);
			matrixStack.translate(-0.5D, -0.5D, -0.5D);
			blockRenderManager.renderBlockAsEntity(state, matrixStack, vertexConsumerProvider, i, m);
			matrixStack.pop();
		}
	}
}
