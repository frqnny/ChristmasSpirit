package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.effect.FrozenEffect;
import io.github.frqnny.cspirit.effect.HolidaySpiritEffect;
import io.github.frqnny.cspirit.effect.NaughtyEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect FROZEN;
    public static StatusEffect HOLIDAY_SPIRIT;
    public static StatusEffect NAUGHTY_EFFECT;

    public static void init() {
        FROZEN = Registry.register(Registry.STATUS_EFFECT, ChristmasSpirit.id("frozen"), new FrozenEffect());
        HOLIDAY_SPIRIT = Registry.register(Registry.STATUS_EFFECT, ChristmasSpirit.id("holiday_spirit"), new HolidaySpiritEffect());
        NAUGHTY_EFFECT = Registry.register(Registry.STATUS_EFFECT, ChristmasSpirit.id("naughty"), new NaughtyEffect());
    }
}
