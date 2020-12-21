package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.data.JackFrostData;
import io.github.frqnny.cspirit.entity.JackFrostEntity;
import io.github.frqnny.cspirit.util.ChatHelper;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import io.github.frqnny.cspirit.util.PresentHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import java.util.Random;

public class ModEvents {
    public boolean canSpawn;

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


        int SPAWN_RANGE = 500;

        ServerTickEvents.END_WORLD_TICK.register(
                (world) -> {
                    if (world.getPlayers().size() > 0) {

                        PlayerEntity player = world.getPlayers().get(0);

                        if (world.getTimeOfDay() == 18000) {

                            if (world.isRaining()) {
                                boolean canSpawn = ((JackFrostData) world).canSpawnJackFrost();
                                if (canSpawn) {

                                    Random random = new Random();

                                    if (random.nextInt(5) == 0) {

                                        ((JackFrostData) world).setCanSpawnJackFrost(false);

                                        int randX = world.getLevelProperties().getSpawnX() + (SPAWN_RANGE - random.nextInt(SPAWN_RANGE << 1));
                                        int randZ = world.getLevelProperties().getSpawnZ() + (SPAWN_RANGE - random.nextInt(SPAWN_RANGE << 1));

                                        JackFrostEntity entity = new JackFrostEntity(world, (int) player.getX(), 256, (int) player.getZ());
                                        world.spawnEntity(entity);
                                        entity.refreshPositionAndAngles(randX, 256, randZ, 0, 0);

                                        if (!world.isClient) {
                                            ChatHelper.broadcastMessage(world, Formatting.AQUA + "" + Formatting.BOLD + "Jack Frost has appeared at [" + randX + ", " + randZ + "]!");
                                        }
                                        world.syncGlobalEvent(1023, entity.getBlockPos(), 0);
                                    }
                                }
                            }
                        } else {
                            ((JackFrostData) world).setCanSpawnJackFrost(true);
                        }
                    }
                }
        );
    }
}
