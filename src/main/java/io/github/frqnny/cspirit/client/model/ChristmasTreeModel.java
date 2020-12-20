package io.github.frqnny.cspirit.client.model;

import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ChristmasTreeModel extends EntityModel<ChristmasTreeEntity> {

    private final ModelPart bb_main;

    public ChristmasTreeModel() {

        textureWidth = 128;
        textureHeight = 128;

        bb_main = new ModelPart(this);
        bb_main.setPivot(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(0, 0).addCuboid(-2.0F, -14.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);
        bb_main.setTextureOffset(16, 0).addCuboid(-1.5F, -28.0F, -1.5F, 3.0F, 14.0F, 3.0F, 0.0F, false);
        bb_main.setTextureOffset(28, 0).addCuboid(-1.0F, -42.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-12.0F, -15.0F, -12.0F, 24.0F, 7.0F, 24.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-10.0F, -22.1F, -10.0F, 20.0F, 14.0F, 20.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-8.0F, -29.1F, -8.0F, 16.0F, 14.0F, 16.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-6.0F, -36.3F, -6.0F, 12.0F, 14.0F, 12.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-4.0F, -43.2F, -4.0F, 8.0F, 14.0F, 8.0F, 0.0F, false);
        bb_main.setTextureOffset(0, 18).addCuboid(-2.0F, -50.1F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setAngles(ChristmasTreeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertices, light, overlay);

    }
}