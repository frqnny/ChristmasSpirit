package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.entity.JackFrostEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class JackFrostEntityRenderer extends BipedEntityRenderer<JackFrostEntity, BipedEntityModel<JackFrostEntity>> {
    public static final Identifier TEXTURE = ChristmasSpirit.id("textures/entity/jack_frost.png");

    public JackFrostEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(JackFrostEntity mobEntity) {
        return TEXTURE;
    }
}
