package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.init.ModEffects;
import io.github.frqnny.cspirit.util.ChatHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class SantaCookieItem extends CSFoodItem {
    public SantaCookieItem(Settings settings) {
        super(settings, 5, false);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity) {

            PlayerEntity player = (PlayerEntity) user;

            player.removeStatusEffect(ModEffects.NAUGHTY_EFFECT);

            player.addStatusEffect(new StatusEffectInstance(ModEffects.HOLIDAY_SPIRIT, 20 * 60, 4));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 60, 2));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 60, 2));

            if (NaughtyListFile.isOnNaughtyList(player)) {

                NaughtyListFile.removeFromNaughtyList(player);
                ChatHelper.printModMessage(Formatting.GREEN, "You've been removed from the Naughty List!", player);
            }
        }

        return this.isFood() ? user.eatFood(world, stack) : stack;
    }
}
