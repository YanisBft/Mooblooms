package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.MoobloomEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class MoobloomBlockStateRenderer extends FeatureRenderer<MoobloomEntityRenderState, CowEntityModel> {
	private final BlockRenderManager blockRenderManager;

	public MoobloomBlockStateRenderer(FeatureRendererContext<MoobloomEntityRenderState, CowEntityModel> context, BlockRenderManager blockRenderManager) {
		super(context);
		this.blockRenderManager = blockRenderManager;
	}
	
	@Override
	public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, MoobloomEntityRenderState state, float limbAngle, float limbDistance) {
		if (!state.baby) {
			boolean renderAsModel = state.hasOutline() && state.invisible;
			if (!state.invisible || renderAsModel) {
				BlockState blockState = state.blockState;
				BlockStateModel blockStateModel = this.blockRenderManager.getModel(blockState);
				Vector3f scale = state.blockStateRendererScale;
				Vec3d translation = state.blockStateRendererTranslation;
				int overlay = LivingEntityRenderer.getOverlay(state, 0.0F);

				// Head block
				matrices.push();
				this.getContextModel().getHead().applyTransform(matrices);
				matrices.translate(0.0D, -0.699999988079071D, -0.20000000298023224D);
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-78.0F));
				matrices.scale(scale.x, scale.y, scale.z);
				matrices.translate(translation.getX(), translation.getY(), translation.getZ());
				this.renderBlockState(matrices, queue, light, renderAsModel, state.outlineColor, blockState, overlay, blockStateModel);
				matrices.pop();

				// Middle block
				matrices.push();
				matrices.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(42.0F));
				matrices.translate(0.10000000149011612D, 0.0D, -0.6000000238418579D);
				float degrees_2 = state.suncower ? -120.0F : -48.0F;
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(degrees_2));
				matrices.scale(scale.x, scale.y, scale.z);
				matrices.translate(translation.getX(), translation.getY(), translation.getZ());
				this.renderBlockState(matrices, queue, light, renderAsModel, state.outlineColor, blockState, overlay, blockStateModel);
				matrices.pop();

				// Tail block
				matrices.push();
				matrices.translate(0.20000000298023224D, -0.3499999940395355D, 0.5D);
				float degrees_1 = state.suncower ? -78.0F : -48.0F;
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(degrees_1));
				matrices.scale(scale.x, scale.y, scale.z);
				matrices.translate(translation.getX(), translation.getY(), translation.getZ());
				this.renderBlockState(matrices, queue, light, renderAsModel, state.outlineColor, blockState, overlay, blockStateModel);
				matrices.pop();
			}
		}
	}

	private void renderBlockState(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, boolean renderAsModel, int i, BlockState blockState, int j, BlockStateModel blockStateModel) {
		if (renderAsModel) {
			queue.submitBlockStateModel(matrices, RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE), blockStateModel, 0.0F, 0.0F, 0.0F, light, j, i);
		} else {
			queue.submitBlock(matrices, blockState, light, j, i);
		}
	}
}
