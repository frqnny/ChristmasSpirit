package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.blockentity.CookieTrayBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

public class CookieTrayBlockEntityRenderer implements BlockEntityRenderer<CookieTrayBlockEntity> {
    public CookieTrayBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(CookieTrayBlockEntity be, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        for (int i = 0; i < ((Inventory) be).getStack(0).getCount(); i++) {
            renderItem(((Inventory) be).getStack(0), 0.5F, 0.1F + (i * 0.029F), 0.6F, tickDelta, matrices, vertexConsumers, light);
        }

        for (int i = 0; i < ((Inventory) be).getStack(1).getCount(); i++) {
            renderItem(((Inventory) be).getStack(1), 0.9F, 0.099F + (i * 0.029F), 0.8F, tickDelta, matrices, vertexConsumers, light);
        }

        for (int i = 0; i < ((Inventory) be).getStack(2).getCount(); i++) {
            renderItem(((Inventory) be).getStack(2), 0.9F, 0.098F + (i * 0.029F), 0.35F, tickDelta, matrices, vertexConsumers, light);
        }
    }

    private void renderItem(ItemStack stack, float x, float y, float z, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider buffer, int combinedLight) {

        matrixStack.push();
        matrixStack.scale(0.7F, 0.7F, 0.7F);
        matrixStack.translate(x, y, z);
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90));
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, combinedLight, OverlayTexture.DEFAULT_UV, matrixStack, buffer, 0);
        matrixStack.pop();
    }
}
