package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.CluckshroomEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class CluckshroomBlockStateRenderer extends FeatureRenderer<CluckshroomEntityRenderState, ChickenEntityModel> {
	private final BlockRenderManager blockRenderManager;

	public CluckshroomBlockStateRenderer(FeatureRendererContext<CluckshroomEntityRenderState, ChickenEntityModel> context, BlockRenderManager blockRenderManager) {
		super(context);
		this.blockRenderManager = blockRenderManager;
	}

	@Override
	public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, CluckshroomEntityRenderState state, float limbAngle, float limbDistance) {
		if (!state.baby) {
			boolean renderAsModel = state.hasOutline() && state.invisible;
			if (!state.invisible || renderAsModel) {
				BlockState blockState = state.blockState;
				BlockStateModel blockStateModel = this.blockRenderManager.getModel(blockState);
				Vector3f scale = state.blockStateRendererScale;
				Vec3d translation = state.blockStateRendererTranslation;
				int overlay = LivingEntityRenderer.getOverlay(state, 0.0F);

				// Body block
				matrices.push();
				matrices.translate(0.0D, 0.36D, 0.15D);
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-6.0F));
				matrices.scale(scale.x, scale.y, scale.z);
				matrices.translate(translation.getX(), translation.getY(), translation.getZ());
				this.renderBlockState(matrices, queue, light, renderAsModel, state.outlineColor, blockState, overlay, blockStateModel);
				matrices.pop();

				// Head block
				matrices.push();
				this.getContextModel().getRootPart().getChild(EntityModelPartNames.HEAD).applyTransform(matrices);
				matrices.translate(0.02D, -0.8D, -0.03D);
				matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
				matrices.scale(scale.x, scale.y, scale.z);
				matrices.translate(translation.getX(), translation.getY(), translation.getZ());
				this.renderBlockState(matrices, queue, light, renderAsModel, state.outlineColor, blockState, overlay, blockStateModel);
				matrices.pop();
			}
		}
	}

	private void renderBlockState(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, boolean renderAsModel, int outlineColor, BlockState blockState, int overlay, BlockStateModel blockStateModel) {
		if (renderAsModel) {
			queue.submitBlockStateModel(matrices, RenderLayers.outlineNoCull(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE), blockStateModel, 0.0F, 0.0F, 0.0F, light, overlay, outlineColor);
		} else {
			queue.submitBlock(matrices, blockState, light, overlay, outlineColor);
		}
	}
}
