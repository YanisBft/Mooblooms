package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.entity.CluckshroomEntity;
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
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class CluckshroomBlockStateRenderer<T extends CluckshroomEntity> extends FeatureRenderer<T, CluckshroomEntityModel<T>> {

	public CluckshroomBlockStateRenderer(FeatureRendererContext<T, CluckshroomEntityModel<T>> context) {
		super(context);
	}
	
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CluckshroomEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		if (!entity.isBaby() && !entity.isInvisible()) {
			BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = entity.settings.getBlockState();
			Vector3f scale = entity.settings.getBlockStateRendererScale();
			Vec3d translation = entity.settings.getBlockStateRendererTranslation();
			int overlay = LivingEntityRenderer.getOverlay(entity, 0.0F);
			
			matrices.push();
			matrices.translate(0.0D, 0.36D, 0.15D);
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-6.0F));
			matrices.scale(scale.x, scale.y, scale.z);
			matrices.translate(translation.getX(), translation.getY(), translation.getZ());
			blockRenderManager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
			matrices.pop();
			
			matrices.push();
			this.getContextModel().getHead().rotate(matrices);
			matrices.translate(0.02D, -0.8D, -0.03D);
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
			matrices.scale(scale.x, scale.y, scale.z);
			matrices.translate(translation.getX(), translation.getY(), translation.getZ());
			blockRenderManager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
			matrices.pop();
		}
	}
}
