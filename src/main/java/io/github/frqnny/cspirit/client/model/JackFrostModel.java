package io.github.frqnny.cspirit.client.model;

import io.github.frqnny.cspirit.entity.JackFrostEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class JackFrostModel extends BipedEntityModel<JackFrostEntity> {
    public JackFrostModel(float scale, boolean hasSmallTexture) {
        super(scale, 0, 64, hasSmallTexture ? 32 : 64);
    }
}
