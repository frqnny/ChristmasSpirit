package io.github.frqnny.cspirit.item;

import net.minecraft.item.Item;

public class ChristmasTreeItem extends Item {
    public static boolean white;

    public ChristmasTreeItem(Settings settings, boolean bl) {
        super(settings);
        white = bl;
    }
}
