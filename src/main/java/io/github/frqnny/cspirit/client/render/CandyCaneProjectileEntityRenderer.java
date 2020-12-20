package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.entity.CandyCaneProjectileEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class CandyCaneProjectileEntityRenderer extends EntityRenderer<CandyCaneProjectileEntity> {
    public CandyCaneProjectileEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    private static void renderItem(ItemStack stack, float x, float y, float z, MatrixStack matrixStack, VertexConsumerProvider buffer, int combinedLight) {

        matrixStack.push();
        matrixStack.scale(1, 1, 1);
        matrixStack.translate(x + 0.25F, y, z);
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, combinedLight, OverlayTexture.DEFAULT_UV, matrixStack, buffer);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(CandyCaneProjectileEntity entity) {
        return null;
    }

    @Override
    public void render(CandyCaneProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);

        ItemStack cane = entity.getCandyCaneStack();

        matrices.push();

        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevYaw, entity.yaw) - 90.0F));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevPitch + 90, entity.pitch + 90)));

        renderItem(cane, 0, 0, 0, matrices, vertexConsumers, light);

        matrices.pop();
    }
}
