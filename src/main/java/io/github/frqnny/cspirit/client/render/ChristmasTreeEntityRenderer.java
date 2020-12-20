package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.client.model.ChristmasTreeModel;
import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import io.github.frqnny.cspirit.init.ModBlocks;
import io.github.frqnny.cspirit.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.Random;

public class ChristmasTreeEntityRenderer extends EntityRenderer<ChristmasTreeEntity> {

    private static final Identifier TEXTURE = ChristmasSpirit.id("textures/entity/christmas_tree.png");
    private static final Identifier TEXTURE_WHITE = ChristmasSpirit.id("textures/entity/christmas_tree_white.png");
    private final ChristmasTreeModel christmasTree = new ChristmasTreeModel();

    public ChristmasTreeEntityRenderer(EntityRenderDispatcher renderManager) {
        super(renderManager);
    }

    @Override
    public void render(ChristmasTreeEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.hasStar()) {
            matrices.push();
            matrices.multiply(Vector3f.NEGATIVE_Y.getDegreesQuaternion(yaw));
            renderDecoration(entity.getItemStackFromSlot(EquipmentSlot.HEAD), 0, 0, 1.235F, 0, tickDelta, matrices, vertexConsumers, light);
            matrices.pop();
        }

        ItemStack firstDecor = entity.getItemStackFromSlot(EquipmentSlot.FEET);
        ItemStack secondDecor = entity.getItemStackFromSlot(EquipmentSlot.LEGS);
        ItemStack thirdDecor = entity.getItemStackFromSlot(EquipmentSlot.CHEST);

        if (!firstDecor.isEmpty()) {

            Random random1 = new Random(50000);
            Random random2 = new Random(60000);
            Random random3 = new Random(70000);

            float randomY1 = random1.nextFloat() * 0.1F - 0.045F;
            float randomY2 = random2.nextFloat() * 0.1F - 0.045F;
            float randomY3 = random3.nextFloat() * 0.1F - 0.045F;

            renderDecoration(firstDecor, randomY1, 0.2F, 0.12F + randomY1, -0.315F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY2, -0.315F, 0.12F + randomY2, 0.2F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY3, -0.1F, 0.12F + randomY1, 0.315F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(firstDecor, randomY1, -0.1F, 0.3F + randomY1, -0.264F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY2, 0.264F, 0.3F + randomY2, -0.1F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY3, -0.264F, 0.3F + randomY3, -0.1F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(firstDecor, randomY1, -0.21F, 0.48F + randomY1, 0.1F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY2, 0.21F, 0.48F + randomY2, -0.05F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(firstDecor, randomY1, -0.1F, 0.66F + randomY1, -0.155F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(firstDecor, randomY2, 0.1F, 0.66F + randomY2, 0.155F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(firstDecor, randomY1, 0.11F, 0.84F + randomY1, 0F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(firstDecor, randomY1, -0.06F, 1.02F + randomY1, 0F, tickDelta, matrices, vertexConsumers, light);
        }

        if (!firstDecor.isEmpty()) {

            Random random1 = new Random(80000);
            Random random2 = new Random(90000);
            Random random3 = new Random(100000);

            float randomY1 = random1.nextFloat() * 0.1F - 0.05F;
            float randomY2 = random2.nextFloat() * 0.1F - 0.05F;
            float randomY3 = random3.nextFloat() * 0.1F - 0.05F;

            renderDecoration(secondDecor, randomY1, -0.15F, 0.12F + randomY1, -0.315F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY2, 0.315F, 0.12F + randomY2, -0.15F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY3, 0.315F, 0.12F + randomY3, 0.15F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(secondDecor, randomY1, 0.1F, 0.3F + randomY1, -0.264F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY2, 0.264F, 0.3F + randomY2, 0.1F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY3, 0.15F, 0.3F + randomY3, 0.264F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(secondDecor, randomY1, -0.1F, 0.48F + randomY1, -0.21F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY2, -0.1F, 0.48F + randomY2, 0.21F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(secondDecor, randomY1, -0.155F, 0.66F + randomY1, -0.1F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(secondDecor, randomY2, 0.155F, 0.66F + randomY2, 0.1F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(secondDecor, randomY1, 0F, 0.84F + randomY1, 0.11F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(secondDecor, randomY1, 0.06F, 1.02F + randomY1, 0F, tickDelta, matrices, vertexConsumers, light);
        }

        if (!firstDecor.isEmpty()) {

            Random random1 = new Random(110000);
            Random random2 = new Random(120000);
            Random random3 = new Random(1300000);

            float randomY1 = random1.nextFloat() * 0.1F - 0.05F;
            float randomY2 = random2.nextFloat() * 0.1F - 0.05F;
            float randomY3 = random3.nextFloat() * 0.1F - 0.05F;

            renderDecoration(thirdDecor, randomY1, -0.315F, 0.12F + randomY1, -0.14F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(thirdDecor, randomY2, 0.15F, 0.12F + randomY2, 0.315F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(thirdDecor, randomY3, 0.05F, 0.12F + randomY3, -0.315F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(thirdDecor, randomY1, -0.1F, 0.3F + randomY1, 0.264F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(thirdDecor, randomY2, -0.264F, 0.3F + randomY2, 0.1F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(thirdDecor, randomY1, 0.1F, 0.48F + randomY1, -0.21F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(thirdDecor, randomY2, -0.21F, 0.48F + randomY2, -0.1F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(thirdDecor, randomY1, -0.1F, 0.66F + randomY1, 0.155F, tickDelta, matrices, vertexConsumers, light);
            renderDecoration(thirdDecor, randomY2, 0.155F, 0.66F + randomY2, -0.1F, tickDelta, matrices, vertexConsumers, light);

            renderDecoration(thirdDecor, randomY1, -0.11F, 0.84F + randomY1, 0.05F, tickDelta, matrices, vertexConsumers, light);
        }

        matrices.push();
        matrices.translate(0.0D, 1.5D, 0.0D);
        matrices.scale(-1.0F, -1.0F, 1.0F);

        VertexConsumer ivertexbuilder = vertexConsumers.getBuffer(christmasTree.getLayer(getTexture(entity)));
        christmasTree.render(matrices, ivertexbuilder, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }

    private void renderDecoration(ItemStack stack, float yRot, float x, float y, float z, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider buffer, int combinedLight) {

        matrixStack.push();
        matrixStack.scale(2.4F, 2.4F, 2.4F);
        matrixStack.translate(x, y, z);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(yRot * 360 * 8));

        if (Block.getBlockFromItem(stack.getItem()) != ModBlocks.ORNAMENT_RED && Block.getBlockFromItem(stack.getItem()) != ModBlocks.ORNAMENT_GREEN && Block.getBlockFromItem(stack.getItem()) != ModBlocks.ORNAMENT_BLUE) {

            if (stack.getItem() != ModItems.CHRISTMAS_LIGHT_WHITE && stack.getItem() != ModItems.CHRISTMAS_LIGHT_RED && stack.getItem() != ModItems.CHRISTMAS_LIGHT_GREEN && stack.getItem() != ModItems.CHRISTMAS_LIGHT_BLUE) {

                if (Block.getBlockFromItem(stack.getItem()) != ModBlocks.STAR) {
                    matrixStack.scale(0.5F, 0.5F, 0.5F);
                }
            }
        }

        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, combinedLight, OverlayTexture.DEFAULT_UV, matrixStack, buffer);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(ChristmasTreeEntity entity) {
        return entity.isWhite() ? TEXTURE_WHITE : TEXTURE;
    }
}
