package io.github.frqnny.cspirit.util;

import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class SoundHelper {

    public static void sendSoundToClient(ServerPlayerEntity player, SoundEvent sound) {

        if (Registry.SOUND_EVENT.getId(sound) != null) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(Registry.SOUND_EVENT.getId(sound), SoundCategory.BLOCKS, player.getPos(), 1, 1));
        }
    }
}
