package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.client.model.SleighModel;
import io.github.frqnny.cspirit.entity.SleighEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SleighEntityRenderer extends EntityRenderer<SleighEntity> {
    public static final Identifier TEXTURE = ChristmasSpirit.id("textures/entity/sleigh.png");
    private final SleighModel sleigh = new SleighModel();

    public SleighEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(SleighEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.translate(0.0D, 1.1D, 0.0D);
        matrices.scale(-1.0F, -1.0F, 1.0F);
        matrices.scale(0.9F, 0.9F, 0.9F);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevYaw, entity.yaw) - 180));
        matrices.translate(0.0D, 0.0D, -0.5D);

        VertexConsumer ivertexbuilder = vertexConsumers.getBuffer(sleigh.getLayer(getTexture(entity)));
        sleigh.render(matrices, ivertexbuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }

    @Override
    public Identifier getTexture(SleighEntity entity) {
        return TEXTURE;
    }
}
