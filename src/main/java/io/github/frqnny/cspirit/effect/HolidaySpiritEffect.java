package io.github.frqnny.cspirit.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class HolidaySpiritEffect extends StatusEffect {
    public HolidaySpiritEffect() {
        super(StatusEffectType.BENEFICIAL, 0);
    }

    @Override
    public String getTranslationKey() {
        return "Holiday Spirit";
    }
}
