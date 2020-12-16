package io.github.frqnny.cspirit.util;

import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class SoundHelper {

    public static void sendSoundToClient(ServerPlayerEntity player, SoundEvent sound) {

        if (sound.getId() != null) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(sound.getId(), SoundCategory.BLOCKS, player.getPos(), 1, 1));
        }
    }
}
