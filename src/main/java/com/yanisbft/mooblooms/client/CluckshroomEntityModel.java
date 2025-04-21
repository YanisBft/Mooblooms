package com.yanisbft.mooblooms.client;

import com.yanisbft.mooblooms.client.renderstate.CluckshroomEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityModel extends EntityModel<CluckshroomEntityRenderState> {
	private final ModelPart head;
    private final ModelPart rightLeg;
	private final ModelPart leftLeg;
	private final ModelPart rightWing;
	private final ModelPart leftWing;
	private final ModelPart beak;
	private final ModelPart wattle;
	
	public CluckshroomEntityModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.beak = root.getChild("beak");
		this.wattle = root.getChild("wattle");
        this.rightLeg = root.getChild("right_leg");
		this.leftLeg = root.getChild("left_leg");
		this.rightWing = root.getChild("right_wing");
		this.leftWing = root.getChild("left_wing");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData data = new ModelData();
		ModelPartData root = data.getRoot();
		root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		root.addChild("beak", ModelPartBuilder.create().uv(14, 0).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		root.addChild("wattle", ModelPartBuilder.create().uv(14, 4).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F), ModelTransform.pivot(0.0F, 15.0F, -4.0F));
		root.addChild("body", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F), ModelTransform.of(0.0F, 16.0F, 0.0F, 1.5707964F, 0.0F, 0.0F));
		root.addChild("right_leg", ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F), ModelTransform.pivot(-2.0F, 19.0F, 1.0F));
		root.addChild("left_leg", ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F), ModelTransform.pivot(1.0F, 19.0F, 1.0F));
		root.addChild("right_wing", ModelPartBuilder.create().uv(24, 13).cuboid(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F), ModelTransform.pivot(-4.0F, 13.0F, 0.0F));
		root.addChild("left_wing", ModelPartBuilder.create().uv(24, 13).cuboid(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F), ModelTransform.pivot(4.0F, 13.0F, 0.0F));
		return TexturedModelData.of(data, 64, 32);
	}

	public ModelPart getHead() {
		return this.head;
	}

	@Override
	public void setAngles(CluckshroomEntityRenderState state) {
		super.setAngles(state);
		float animationProgress = (MathHelper.sin(state.flapProgress) + 1.0F) * state.maxWingDeviation;
		this.head.pitch = state.pitch * (float) (Math.PI / 180.0);
		this.head.yaw = state.yawDegrees * (float) (Math.PI / 180.0);
		this.beak.pitch = this.head.pitch;
		this.beak.yaw = this.head.yaw;
		this.wattle.pitch = this.head.pitch;
		this.wattle.yaw = this.head.yaw;
		this.rightLeg.pitch = MathHelper.cos(state.limbFrequency * 0.6662F) * 1.4F * state.limbAmplitudeMultiplier;
		this.leftLeg.pitch = MathHelper.cos(state.limbFrequency * 0.6662F + 3.1415927F) * 1.4F * state.limbAmplitudeMultiplier;
		this.rightWing.roll = animationProgress;
		this.leftWing.roll = -animationProgress;
	}
}
