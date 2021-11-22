package io.github.frqnny.cspirit.client.model;

import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ChristmasTreeModel extends EntityModel<ChristmasTreeEntity> {

    private final ModelPart bb_main;

    public ChristmasTreeModel(ModelPart root) {
        bb_main = root.getChild("bb_main");

    }

    public static ModelData getModelData(Dilation dilation, float pivotOffsetY) {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild("bb_main",
                ModelPartBuilder.create()
                        .cuboid(-2.0F, -14.0F, -2.0F, 4.0F, 14.0F, 4.0F)
                        .uv(16, 0).cuboid(-1.5F, -28.0F, -1.5F, 3.0F, 14.0F, 3.0F)
                        .uv(28, 0).cuboid(-1.0F, -42.0F, -1.0F, 2.0F, 14.0F, 2.0F)
                        .uv(0, 18).cuboid(-12.0F, -15.0F, -12.0F, 24.0F, 7.0F, 24.0F)
                        .cuboid(-10.0F, -22.1F, -10.0F, 20.0F, 14.0F, 20.0F)
                        .cuboid(-8.0F, -29.1F, -8.0F, 16.0F, 14.0F, 16.0F)
                        .cuboid(-6.0F, -36.3F, -6.0F, 12.0F, 14.0F, 12.0F)
                        .cuboid(-4.0F, -43.2F, -4.0F, 8.0F, 14.0F, 8.0F)
                        .cuboid(-2.0F, -50.1F, -2.0F, 4.0F, 14.0F, 4.0F),
                ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        return modelData;
    }

    @Override
    public void setAngles(ChristmasTreeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrices, vertices, light, overlay);

    }
}