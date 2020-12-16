package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent WISHBACKGROUND = new SoundEvent(ChristmasSpirit.id("disc.wishbackground"));
    public static SoundEvent MCCHRISTMAS = new SoundEvent(ChristmasSpirit.id("disc.mcchristmas"));
    public static SoundEvent JARED = new SoundEvent(ChristmasSpirit.id("disc.jared"));
    public static SoundEvent CONGRATS = new SoundEvent(ChristmasSpirit.id("congrats"));
    public static SoundEvent PRESENT_WRAP = new SoundEvent(ChristmasSpirit.id("present.wrap"));
    public static SoundEvent PRESENT_UNWRAP = new SoundEvent(ChristmasSpirit.id("present.unwrap"));
    public static SoundEvent CAN_OPEN = new SoundEvent(ChristmasSpirit.id("can.open"));
    public static SoundEvent WANNA_SPRITE_CRANBERRY = new SoundEvent(ChristmasSpirit.id("wanna.sprite.cranberry"));
    public static SoundEvent THE_ANSWER_IS_CLEAR = new SoundEvent(ChristmasSpirit.id("the.answer.is.clear"));

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, WISHBACKGROUND.getId(), WISHBACKGROUND);
        Registry.register(Registry.SOUND_EVENT, MCCHRISTMAS.getId(), MCCHRISTMAS);
        Registry.register(Registry.SOUND_EVENT, JARED.getId(), JARED);
        Registry.register(Registry.SOUND_EVENT, CONGRATS.getId(), CONGRATS);
        Registry.register(Registry.SOUND_EVENT, PRESENT_WRAP.getId(), PRESENT_WRAP);
        Registry.register(Registry.SOUND_EVENT, PRESENT_UNWRAP.getId(), PRESENT_UNWRAP);
        Registry.register(Registry.SOUND_EVENT, CAN_OPEN.getId(), CAN_OPEN);
        Registry.register(Registry.SOUND_EVENT, WANNA_SPRITE_CRANBERRY.getId(), WANNA_SPRITE_CRANBERRY);
        Registry.register(Registry.SOUND_EVENT, THE_ANSWER_IS_CLEAR.getId(), THE_ANSWER_IS_CLEAR);


    }
}
