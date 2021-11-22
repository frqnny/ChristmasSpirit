package io.github.frqnny.cspirit.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HolidaySpiritEffect extends StatusEffect {
    public HolidaySpiritEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0);
    }

    @Override
    public String getTranslationKey() {
        return "Holiday Spirit";
    }
}
