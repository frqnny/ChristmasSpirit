package io.github.frqnny.cspirit.present;

import io.github.frqnny.cspirit.init.ModBlocks;
import net.minecraft.block.Block;

public enum PresentStyle {

    RED(0, "Red", ModBlocks.PRESENT_WRAPPED_RED),
    GREEN(1, "Green", ModBlocks.PRESENT_WRAPPED_GREEN),
    BLUE(2, "Blue", ModBlocks.PRESENT_WRAPPED_BLUE);

    private final int index;
    private final String name;
    private final Block block;

    PresentStyle(int index, String name, Block block) {
        this.index = index;
        this.name = name;
        this.block = block;
    }

    public static PresentStyle fromIndex(int index) {

        PresentStyle foundColor = RED;

        for (PresentStyle color : PresentStyle.values()) {

            if (color.index == index) {
                foundColor = color;
                break;
            }
        }

        return foundColor;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public Block getBlock() {
        return this.block;
    }
}
