package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CSFoodItem extends Item implements IItemSpiritSupplier {
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

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entityLiving) {
        EffectHelper.giveHolidaySpiritStackEffect((PlayerEntity)entityLiving, maxSpiritStack);

        return super.finishUsing(stack, world, entityLiving);
    }

    public UseAction getUseAction(ItemStack stack) {
        return drink ? UseAction.DRINK : UseAction.EAT;
    }

    @Override
    public int getMaxStacks() {
        return maxSpiritStack;
    }

}
