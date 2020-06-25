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
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

@Environment(EnvType.CLIENT)
public class CluckshroomBlockStateRenderer<T extends CluckshroomEntity> extends FeatureRenderer<T, CluckshroomEntityModel<T>> {

	public CluckshroomBlockStateRenderer(FeatureRendererContext<T, CluckshroomEntityModel<T>> context) {
		super(context);
	}
	
	public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CluckshroomEntity entity, float f, float g, float h, float j, float k, float l) {
		if (!entity.isBaby() && !entity.isInvisible()) {
			BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = entity.settings.getBlockState();
			int overlay = LivingEntityRenderer.getOverlay(entity, 0.0F);
			
			matrixStack.push();
			matrixStack.translate(0.0D, 0.36D, 0.15D);
			matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-6.0F));
			matrixStack.scale(-1.0F, -1.0F, 1.0F);
			matrixStack.translate(-0.5D, -0.5D, -0.5D);
			blockRenderManager.renderBlockAsEntity(state, matrixStack, vertexConsumerProvider, i, overlay);
			matrixStack.pop();
			
			matrixStack.push();
			this.getContextModel().getHead().rotate(matrixStack);
			matrixStack.translate(0.02D, -0.8D, -0.03D);
			matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-48.0F));
			matrixStack.scale(-1.0F, -1.0F, 1.0F);
			matrixStack.translate(-0.5D, -0.5D, -0.5D);
			blockRenderManager.renderBlockAsEntity(state, matrixStack, vertexConsumerProvider, i, overlay);
			matrixStack.pop();
		}
	}
}
