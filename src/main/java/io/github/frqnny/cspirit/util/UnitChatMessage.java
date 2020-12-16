package io.github.frqnny.cspirit.util;

import net.minecraft.entity.Entity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

public class UnitChatMessage {

    private final String unitName;
    private final Entity[] players;

    public UnitChatMessage(String unitName, Entity... players) {
        this.unitName = unitName;
        this.players = players;
    }

    public void printMessage(Formatting format, String message) {

        for (Entity player : players) {

            LiteralText componentString = new LiteralText(getUnitName() + (format + message));
            player.sendSystemMessage(componentString, Util.NIL_UUID);
        }
    }

    private String getUnitName() {
        return "[" + unitName + "] ";
    }
}
