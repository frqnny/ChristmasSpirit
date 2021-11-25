package io.github.frqnny.cspirit.client.render.feature;

import io.github.frqnny.cspirit.client.model.ReindeerModel;
import io.github.frqnny.cspirit.entity.ReindeerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;

public class ReindeerLeatherArmorFeatureRenderer extends FeatureRenderer<ReindeerEntity, ReindeerModel<ReindeerEntity>> {
    private final ReindeerModel<ReindeerEntity> model;


    public ReindeerLeatherArmorFeatureRenderer(FeatureRendererContext<ReindeerEntity, ReindeerModel<ReindeerEntity>> context, EntityModelLoader loader) {
        super(context);
        this.model = new ReindeerModel<>(loader.getModelPart(EntityModelLayers.HORSE_ARMOR));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ReindeerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemstack = entity.getArmorType();
        if (itemstack.getItem() instanceof HorseArmorItem horsearmoritem) {
            this.getContextModel().copyStateTo(this.model);
            this.model.animateModel(entity, limbAngle, limbAngle, tickDelta);
            this.model.setAngles(entity, limbAngle, limbAngle, animationProgress, tickDelta, headPitch);
            float f;
            float f1;
            float f2;
            if (horsearmoritem instanceof DyeableHorseArmorItem) {
                int i = ((DyeableHorseArmorItem) horsearmoritem).getColor(itemstack);
                f = (float) (i >> 16 & 255) / 255.0F;
                f1 = (float) (i >> 8 & 255) / 255.0F;
                f2 = (float) (i & 255) / 255.0F;
            } else {
                f = 1.0F;
                f1 = 1.0F;
                f2 = 1.0F;
            }

            VertexConsumer ivertexbuilder = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(horsearmoritem.getEntityTexture()));
            this.model.render(matrices, ivertexbuilder, light, OverlayTexture.DEFAULT_UV, f, f1, f2, 1.0F);
        }
    }
}
