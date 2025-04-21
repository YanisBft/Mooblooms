package com.yanisbft.mooblooms.client.renderstate;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class MoobloomEntityRenderState extends LivingEntityRenderState {
    public Identifier name;
    public BlockState blockState;
    public Vector3f blockStateRendererScale;
    public Vec3d blockStateRendererTranslation;
    public boolean suncower;
}
