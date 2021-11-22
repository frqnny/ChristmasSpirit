package io.github.frqnny.cspirit.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class NaughtyEffect extends StatusEffect {
    public NaughtyEffect() {
        super(StatusEffectCategory.HARMFUL, 0);
    }


    @Override
    public String getTranslationKey() {
        return "Naughty";
    }
}
