package io.github.frqnny.cspirit.util;

import io.github.frqnny.cspirit.block.WrappedPresentBlock;
import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.data.SantaGiftListFile;
import io.github.frqnny.cspirit.init.ModEffects;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.init.ModSounds;
import io.github.frqnny.cspirit.present.PresentConstructor;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PresentHelper {

    public static void giveSantaPresent(ServerPlayerEntity player, int day) {

        World world = player.world;
        WrappedPresentBlock.spawnPresent(world, player.getBlockPos() , getSantaPresent(player.getDisplayName().getString(), day), ItemStack.EMPTY);

        //Visuals
        FireworkHelper.spawnFirework(player, (byte)1, true, true, DyeColor.RED, DyeColor.GREEN);
        SoundHelper.sendSoundToClient(player, ModSounds.CONGRATS);
        ChatHelper.broadcastMessage(world, Formatting.GREEN + "" + Formatting.BOLD + player.getDisplayName().getString() + " has received their daily present!");
    }

    public static PresentConstructor getSantaPresent(String toPlayerName, int day) {
        PresentConstructor constructor = new PresentConstructor();
        constructor.day = day;
        constructor.fromPlayerName = "Santa";
        constructor.toPlayerName = toPlayerName;
        constructor.setStyleIndex(0);
        return constructor;
    }

    public static ItemStack getSantaGiftedStack(PlayerEntity player, int day) {

        Random random = new Random();

        if (NaughtyListFile.isOnNaughtyList(player)) {

            int naughtyEffectStack = 0;

            StatusEffectInstance naughtyEffect = player.getStatusEffect(ModEffects.NAUGHTY_EFFECT);

            if (naughtyEffect != null) {
                naughtyEffectStack = naughtyEffect.getAmplifier() + 1;
            }

            return new ItemStack(ModItems.LUMP_OF_COAL, random.nextInt(naughtyEffectStack * 2 + 1) + 1);
        }

        List<SantaGiftListFile.GiftEntry> allGiftEntries = new ArrayList<>(SantaGiftListFile.santaGiftList.values());
        List<SantaGiftListFile.GiftEntry> availableGifts = new ArrayList<>();

        int spiritEffectStack = 0;

        StatusEffectInstance spiritEffect = player.getStatusEffect(ModEffects.HOLIDAY_SPIRIT);

        if (spiritEffect != null) {
            spiritEffectStack = spiritEffect.getAmplifier() + 1;
        }

        int firstRarity = 50;
        int secondRarity = 20 + (spiritEffectStack * 2);
        int thirdRarity = 15 + (spiritEffectStack * 5);
        int fourthRarity = 10 + (spiritEffectStack * 10);
        int fifthRarity = 5 + (spiritEffectStack * 20);

        int giftRarityIndex = RandomHelper.getWeightedRandom(firstRarity, secondRarity, thirdRarity, fourthRarity, fifthRarity);

        for (SantaGiftListFile.GiftEntry giftEntry : allGiftEntries) {

            if (day >= giftEntry.minDay && day <= giftEntry.maxDay) {

                if (giftEntry.rarityIndex == giftRarityIndex) {
                    availableGifts.add(giftEntry);
                }
            }
        }

        if (availableGifts.size() == 0) {
            return getSantaGiftedStack(player, day);
        }

        SantaGiftListFile.GiftEntry giftEntry = availableGifts.get(random.nextInt(availableGifts.size()));

        ItemStack giftStack = giftEntry.getGiftStack();
        giftStack.setCount(random.nextInt(giftEntry.maxAmount) + 1);

        return giftStack;
    }
}
