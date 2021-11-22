package io.github.frqnny.cspirit.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FrozenEffect extends StatusEffect {
    public FrozenEffect() {
        super(StatusEffectCategory.HARMFUL, 0);
        addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -100F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

    }


    @Override
    public String getTranslationKey() {
        return "Frozen";
    }

}
