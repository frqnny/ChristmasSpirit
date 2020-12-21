package io.github.frqnny.cspirit.client.render;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.client.model.JackFrostModel;
import io.github.frqnny.cspirit.entity.JackFrostEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

public class JackFrostEntityRenderer extends BipedEntityRenderer<JackFrostEntity, JackFrostModel> {
    public static final Identifier TEXTURE = ChristmasSpirit.id("textures/entity/jack_frost.png");

    public JackFrostEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new JackFrostModel(0.0F, false), 0.5F);
    }

    @Override
    public Identifier getTexture(JackFrostEntity mobEntity) {
        return TEXTURE;
    }
}
