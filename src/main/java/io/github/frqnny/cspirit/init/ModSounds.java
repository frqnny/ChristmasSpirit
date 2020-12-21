package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent MCCHRISTMAS = new SoundEvent(ChristmasSpirit.id("disc.mcchristmas"));
    public static SoundEvent JARED = new SoundEvent(ChristmasSpirit.id("disc.jared"));
    public static SoundEvent CONGRATS = new SoundEvent(ChristmasSpirit.id("congrats"));
    public static SoundEvent PRESENT_WRAP = new SoundEvent(ChristmasSpirit.id("present.wrap"));
    public static SoundEvent PRESENT_UNWRAP = new SoundEvent(ChristmasSpirit.id("present.unwrap"));
    public static SoundEvent CAN_OPEN = new SoundEvent(ChristmasSpirit.id("can.open"));
    public static SoundEvent WANNA_SPRITE_CRANBERRY = new SoundEvent(ChristmasSpirit.id("wanna.sprite.cranberry"));
    public static SoundEvent THE_ANSWER_IS_CLEAR = new SoundEvent(ChristmasSpirit.id("the.answer.is.clear"));

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("disc.mcchristmas"), MCCHRISTMAS);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("disc.jared"), JARED);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("congrats"), CONGRATS);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("present.wrap"), PRESENT_WRAP);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("present.unwrap"), PRESENT_UNWRAP);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("can.open"), CAN_OPEN);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("wanna.sprite.cranberry"), WANNA_SPRITE_CRANBERRY);
        Registry.register(Registry.SOUND_EVENT, ChristmasSpirit.id("the.answer.is.clear"), THE_ANSWER_IS_CLEAR);


    }
}
