package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import io.github.frqnny.cspirit.util.PresentHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class ModEvents {

    public static void init() {
        ServerEntityEvents.ENTITY_LOAD.register(
                ((entity, serverWorld) -> {
                    if (entity instanceof ServerPlayerEntity) {
                        if (DailyPresentDataFile.areDailyGiftsEnabled() && !DailyPresentDataFile.hasReceivedPreset((ServerPlayerEntity) entity)) {
                            PresentHelper.giveSantaPresent((ServerPlayerEntity) entity, TimeHelper.getCurrentDay() - 1);
                        }
                    }
                    
                })
        );
        ItemTooltipCallback.EVENT.register(
                (stack, context, lines) -> {
                    Item item = stack.getItem();
                    if (item.isFood() && item.getFoodComponent() != null) {
                        String hunger = "hunger.icon." + item.getFoodComponent().getHunger();
                        lines.add(new TranslatableText(hunger));
                        String saturation = "saturation.icon." + item.getFoodComponent().getSaturationModifier();
                        lines.add(new TranslatableText(saturation));
                    }

                    if (ChristmasSpirit.NAUGHTY.contains(item)) {
                        if (ChristmasSpirit.getConfig().misc.naughtyItems) {
                            lines.add(new LiteralText(""));
                            lines.add(new TranslatableText("grinch.icon"));
                        } else {
                            lines.add(new LiteralText(""));
                            lines.add(new TranslatableText(Formatting.RED + "Disabled by config!"));
                        }
                    }

                    if (item instanceof IItemSpiritSupplier) {
                        lines.add(new TranslatableText("santa.icon." + ((IItemSpiritSupplier) item).getMaxStacks()));
                    }
                }
        );
    }
}
