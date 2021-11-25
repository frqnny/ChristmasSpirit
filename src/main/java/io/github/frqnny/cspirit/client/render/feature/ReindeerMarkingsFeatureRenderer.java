package io.github.frqnny.cspirit.client.render.feature;

import com.google.common.collect.Maps;
import io.github.frqnny.cspirit.client.model.ReindeerModel;
import io.github.frqnny.cspirit.entity.ReindeerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.HorseEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.HorseMarking;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ReindeerMarkingsFeatureRenderer extends FeatureRenderer<ReindeerEntity, ReindeerModel<ReindeerEntity>> {
    private static final Map<HorseMarking, Identifier> field_239405_a_ = Util.make(Maps.newEnumMap(HorseMarking.class), (p_239406_0_) -> {
        p_239406_0_.put(HorseMarking.NONE, null);
        p_239406_0_.put(HorseMarking.WHITE, new Identifier("textures/entity/horse/horse_markings_white.png"));
        p_239406_0_.put(HorseMarking.WHITE_FIELD, new Identifier("textures/entity/horse/horse_markings_whitefield.png"));
        p_239406_0_.put(HorseMarking.WHITE_DOTS, new Identifier("textures/entity/horse/horse_markings_whitedots.png"));
        p_239406_0_.put(HorseMarking.BLACK_DOTS, new Identifier("textures/entity/horse/horse_markings_blackdots.png"));
    });

    public ReindeerMarkingsFeatureRenderer(FeatureRendererContext<ReindeerEntity, ReindeerModel<ReindeerEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ReindeerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Identifier resourcelocation = field_239405_a_.get(entity.getMarking());
        if (resourcelocation != null && !entity.isInvisible()) {
            VertexConsumer ivertexbuilder = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(resourcelocation));
            this.getContextModel().render(matrices, ivertexbuilder, light, LivingEntityRenderer.getOverlay(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
