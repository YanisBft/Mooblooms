package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.CluckshroomEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
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
public class CluckshroomBlockStateRenderer extends FeatureRenderer<CluckshroomEntityRenderState, CluckshroomEntityModel> {
	private final BlockRenderManager blockRenderManager;

	public CluckshroomBlockStateRenderer(FeatureRendererContext<CluckshroomEntityRenderState, CluckshroomEntityModel> context, BlockRenderManager blockRenderManager) {
		super(context);
		this.blockRenderManager = blockRenderManager;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CluckshroomEntityRenderState state, float limbAngle, float limbDistance) {
		if (!state.baby && !state.invisible) {
			BlockState blockState = state.blockState;
			Vector3f scale = state.blockStateRendererScale;
			Vec3d translation = state.blockStateRendererTranslation;
			int overlay = LivingEntityRenderer.getOverlay(state, 0.0F);
			
			matrices.push();
			matrices.translate(0.0D, 0.36D, 0.15D);
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-6.0F));
			matrices.scale(scale.x, scale.y, scale.z);
			matrices.translate(translation.getX(), translation.getY(), translation.getZ());
			blockRenderManager.renderBlockAsEntity(blockState, matrices, vertexConsumers, light, overlay);
			matrices.pop();
			
			matrices.push();
			this.getContextModel().getHead().rotate(matrices);
			matrices.translate(0.02D, -0.8D, -0.03D);
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
			matrices.scale(scale.x, scale.y, scale.z);
			matrices.translate(translation.getX(), translation.getY(), translation.getZ());
			blockRenderManager.renderBlockAsEntity(blockState, matrices, vertexConsumers, light, overlay);
			matrices.pop();
		}
	}
}
