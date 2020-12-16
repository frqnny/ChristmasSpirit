package io.github.frqnny.cspirit.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class NaughtyEffect extends StatusEffect {
    public NaughtyEffect() {
        super(StatusEffectType.HARMFUL, 0);
    }


    @Override
    public String getTranslationKey() {
        return "Naughty";
    }
}
