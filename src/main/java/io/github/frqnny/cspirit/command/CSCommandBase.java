package io.github.frqnny.cspirit.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.data.SantaGiftListFile;
import io.github.frqnny.cspirit.util.ChatHelper;
import io.github.frqnny.cspirit.util.PresentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class CSCommandBase {

    /**
     * Registers all of the commands.
     */
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> csCommand = CommandManager.literal("cspirit");
        csCommand.requires(commandSource -> true)
                .then(gift().requires((player) -> player.hasPermissionLevel(2)))
                .then(reloadSantaGifts().requires((player) -> player.hasPermissionLevel(2)))
                .then(startDailyGiftEvent().requires((player) -> player.hasPermissionLevel(2)))
                .then(stopDailyGiftEvent().requires((player) -> player.hasPermissionLevel(2)))
                .then(removePresentData().requires((player) -> player.hasPermissionLevel(2)));
        dispatcher.register(csCommand);
    }

    private static ArgumentBuilder<ServerCommandSource, ?> startDailyGiftEvent() {

        return CommandManager.literal("startDailyGiftEvent").executes(ctx -> {

            DailyPresentDataFile.enableDailyGifts(true);
            ChatHelper.broadcastMessage(ctx.getSource().getWorld(), Formatting.GREEN + "" + Formatting.BOLD + "All players can now receive daily gifts! (Re-log to receive your gift!)");

            return Command.SINGLE_SUCCESS;
        });
    }

    private static ArgumentBuilder<ServerCommandSource, ?> stopDailyGiftEvent() {

        return CommandManager.literal("stopDailyGiftEvent").executes(ctx -> {

            DailyPresentDataFile.enableDailyGifts(false);
            ChatHelper.broadcastMessage(ctx.getSource().getWorld(), Formatting.GREEN + "" + Formatting.BOLD + "All players won't receive daily gifts anymore.");

            return Command.SINGLE_SUCCESS;
        });
    }

    private static ArgumentBuilder<ServerCommandSource, ?> gift() {

        return CommandManager.literal("gift").executes(ctx -> 0).then(CommandManager.argument("day", IntegerArgumentType.integer(1, 32)).executes(ctx -> {

            PresentHelper.giveSantaPresent(ctx.getSource().getPlayer(), IntegerArgumentType.getInteger(ctx, "day") - 1);
            return Command.SINGLE_SUCCESS;
        }));
    }

    private static ArgumentBuilder<ServerCommandSource, ?> reloadSantaGifts() {

        return CommandManager.literal("reloadSantaGifts").executes(ctx -> {

            SantaGiftListFile.init();

            List<SantaGiftListFile.GiftEntry> allGiftEntries = new ArrayList<>(SantaGiftListFile.santaGiftList.values());

            for (SantaGiftListFile.GiftEntry entry : allGiftEntries) {

                ItemStack giftStack = new ItemStack(Registry.ITEM.get(new Identifier(entry.stackStr)));

                if (giftStack.isEmpty()) {
                    ChatHelper.printModMessage(Formatting.RED, "COULD NOT ADD ITEM: " + entry.stackStr, ctx.getSource().getPlayer());
                }
            }

            ChatHelper.printModMessage(Formatting.GREEN, "Reload Complete!", ctx.getSource().getPlayer());

            return Command.SINGLE_SUCCESS;
        });
    }

    private static ArgumentBuilder<ServerCommandSource, ?> removePresentData() {

        return CommandManager.literal("removePresentData").executes(ctx -> {

            DailyPresentDataFile.clearEntries();
            ChatHelper.broadcastMessage(ctx.getSource().getWorld(), Formatting.RED + "" + Formatting.BOLD + "All players can now receive gifts for this day!");

            return Command.SINGLE_SUCCESS;
        });
    }
}
