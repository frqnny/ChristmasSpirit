package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.ChristmasSpirit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class CSFoodItem extends Item {
    private final int maxSpiritStack;
    private final boolean drink;

    public CSFoodItem(Settings properties, int maxSpiritStack, boolean drink) {
        super(properties);
        this.drink = drink;
        this.maxSpiritStack = maxSpiritStack;
    }

    public CSFoodItem(int hunger, float saturation, int stackSize, int maxSpiritStack, boolean drink) {
        this(new FabricItemSettings().maxCount(stackSize).group(ChristmasSpirit.BAKING).food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).alwaysEdible().build()), maxSpiritStack, drink);
    }

    public CSFoodItem(int hunger, float saturation, int maxSpiritStack, boolean drink) {
        this(hunger, saturation, 64, maxSpiritStack, drink);
    }


}
