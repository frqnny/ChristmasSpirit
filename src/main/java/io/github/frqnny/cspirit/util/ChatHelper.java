package io.github.frqnny.cspirit.util;

import io.github.frqnny.cspirit.ChristmasSpirit;
import net.minecraft.entity.Entity;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.world.World;

import java.util.Objects;

public class ChatHelper {

    /**
     * Used to print the main mod's messages.
     *
     * @param format  The color or style of the message.
     * @param message The message.
     * @param players The Players that will receive the message.
     */
    public static void printModMessage(Formatting format, String message, Entity... players) {
        UnitChatMessage unitMessage = new UnitChatMessage(ChristmasSpirit.MODID, players);
        unitMessage.printMessage(format, message);
    }

    /**
     * Used to send a message to everyone.
     *
     * @param message The message.
     */
    public static void broadcastMessage(World world, String message) {
        Objects.requireNonNull(world.getServer()).getPlayerManager().broadcast(new LiteralText(message), MessageType.CHAT, Util.NIL_UUID);
    }
}
