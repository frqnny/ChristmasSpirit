package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.entity.CandyCaneProjectileEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class CandyCaneProjectileEntityRenderer extends EntityRenderer<CandyCaneProjectileEntity> {
    public CandyCaneProjectileEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    private static void renderItem(ItemStack stack, MatrixStack matrixStack, VertexConsumerProvider buffer, int combinedLight) {

        matrixStack.push();
        matrixStack.scale(1, 1, 1);
        matrixStack.translate((float) 0 + 0.25F, (float) 0, (float) 0);
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, combinedLight, OverlayTexture.DEFAULT_UV, matrixStack, buffer, 0);
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

        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevPitch + 90, entity.getPitch() + 90)));

        renderItem(cane, matrices, vertexConsumers, light);

        matrices.pop();
    }
}
