package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.init.ModSounds;
import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SodaItem extends CSFoodItem {
    public SodaItem(int hunger, float saturation) {
        super(hunger, saturation, 1, 2, true);
    }

    private static boolean isOpened(ItemStack stack) {
        NbtCompound nbt = ItemHelper.getNBT(stack);
        return nbt.getBoolean("Opened");
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new LiteralText(isOpened(stack) ? "Opened" : "Unopened"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entityLiving) {
        if (!isOpened(stack)) {

            NbtCompound nbt = ItemHelper.getNBT(stack);
            nbt.putBoolean("Opened", true);

            entityLiving.playSound(ModSounds.CAN_OPEN, 1, 1);

            return stack;
        }

        return super.finishUsing(stack, world, entityLiving);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return isOpened(stack) ? UseAction.DRINK : UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return isOpened(stack) ? 40 : 20;
    }
}
