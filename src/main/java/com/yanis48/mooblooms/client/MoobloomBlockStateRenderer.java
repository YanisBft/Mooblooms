package com.yanis48.mooblooms.client;

import com.yanis48.mooblooms.entity.MoobloomEntity;

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
public class MoobloomBlockStateRenderer<T extends MoobloomEntity> extends FeatureRenderer<T, CowEntityModel<T>> {
	
	public MoobloomBlockStateRenderer(FeatureRendererContext<T, CowEntityModel<T>> context) {
		super(context);
	}
	
	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, MoobloomEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		if (!entity.isBaby() && !entity.isInvisible()) {
			BlockRenderManager manager = MinecraftClient.getInstance().getBlockRenderManager();
			BlockState state = entity.settings.getBlockState();
			int overlay = LivingEntityRenderer.getOverlay(entity, 0.0F);
			
			matrices.push();
			matrices.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
			float degrees_1 = entity.isSuncower() ? -78.0F : -48.0F;
			matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(degrees_1));
			matrices.scale(-1.0F, -1.0F, 1.0F);
			matrices.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
			matrices.pop();
			
			matrices.push();
			matrices.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
			matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(42.0F));
			matrices.translate(0.10000000149011612D, 0.0D, -0.6000000238418579D);
			float degrees_2 = entity.isSuncower() ? -120.0F : -48.0F;
			matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(degrees_2));
			matrices.scale(-1.0F, -1.0F, 1.0F);
			matrices.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
			matrices.pop();
			
			matrices.push();
			this.getContextModel().getHead().rotate(matrices);
			matrices.translate(0.0D, -0.699999988079071D, -0.20000000298023224D);
			matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-78.0F));
			matrices.scale(-1.0F, -1.0F, 1.0F);
			matrices.translate(-0.5D, -0.5D, -0.5D);
			manager.renderBlockAsEntity(state, matrices, vertexConsumers, light, overlay);
			matrices.pop();
		}
	}
}
