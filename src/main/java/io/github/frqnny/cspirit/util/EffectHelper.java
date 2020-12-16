package io.github.frqnny.cspirit.util;

import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.init.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;

public class EffectHelper {

    public static void giveFrozenEffect(LivingEntity entity, int seconds) {

        entity.addStatusEffect(new StatusEffectInstance(ModEffects.FROZEN, seconds));

        if (!entity.world.isClient) {
            if (entity instanceof PlayerEntity)
                SoundHelper.sendSoundToClient((ServerPlayerEntity) entity, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE);
        }

        entity.playSound(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, 0.7F, 1);
    }

    public static void giveHolidaySpiritStackEffect(PlayerEntity player, int maxStackSize) {
        giveHolidaySpiritStackEffect(player, maxStackSize, 60 * 5);
    }

    public static void giveHolidaySpiritStackEffect(PlayerEntity player, int maxStackSize, int seconds) {

        if (player.getStatusEffect(ModEffects.NAUGHTY_EFFECT) == null && !NaughtyListFile.isOnNaughtyList(player)) {
            stackEffect(player, ModEffects.HOLIDAY_SPIRIT, seconds, maxStackSize);
        }
    }

    public static void giveNaughtyStackEffect(PlayerEntity player) {
        player.removeStatusEffect(ModEffects.HOLIDAY_SPIRIT);
        stackEffect(player, ModEffects.NAUGHTY_EFFECT, 30 * 60, 5);

        if (!NaughtyListFile.isOnNaughtyList(player)) {

            int naughtyStacks = player.getStatusEffect(ModEffects.NAUGHTY_EFFECT).getAmplifier();

            if (naughtyStacks == 2) {
                ChatHelper.printModMessage(Formatting.RED, "Be careful! You've been pretty naughty!", player);
                ChatHelper.printModMessage(Formatting.RED, "Do a few more naughty deeds, and you'll be marked on the Naughty List!", player);
            }

            if (naughtyStacks >= 4) {

                NaughtyListFile.addToNaughtyList(player);

                ChatHelper.printModMessage(Formatting.RED, "You've been very naughty! You are now on the Naughty List!", player);
                ChatHelper.printModMessage(Formatting.RED, "Eat a Santa Cookie to be removed.", player);
            }
        }
    }

    public static void stackEffect(PlayerEntity player, StatusEffect effect, int seconds, int maxStackSize) {

        int spiritStack = 0;

        if (player.getStatusEffect(effect) != null) {
            spiritStack = player.getStatusEffect(effect).getAmplifier() + 1;
        }

        if (spiritStack < maxStackSize) {
            player.addStatusEffect(new StatusEffectInstance(effect, 20 * seconds, spiritStack));
        } else player.addStatusEffect(new StatusEffectInstance(effect, 20 * seconds, maxStackSize - 1));
    }
}
