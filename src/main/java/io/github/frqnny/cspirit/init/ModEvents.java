package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.data.JackFrostData;
import io.github.frqnny.cspirit.entity.JackFrostEntity;
import io.github.frqnny.cspirit.util.ChatHelper;
import io.github.frqnny.cspirit.util.PresentHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Formatting;

import java.util.Random;

public class ModEvents {

    public static void init() {
        ServerEntityEvents.ENTITY_LOAD.register(
                ((entity, serverWorld) -> {
                    if (entity instanceof ServerPlayerEntity) {
                        if (DailyPresentDataFile.areDailyGiftsEnabled() && !DailyPresentDataFile.hasReceivedPreset((ServerPlayerEntity) entity)) {
                            PresentHelper.giveSantaPresent((ServerPlayerEntity) entity, TimeHelper.getCurrentDay() - 1);
                        }
                    } else if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity) {
                        Random random = ((HostileEntity) entity).getRandom();
                        if (random.nextInt(ChristmasSpirit.getConfig().misc.mobArmorRarity) == 0) {

                            MobEntity mob = (MobEntity) entity;

                            Item[] helmetList = new Item[]{ModItems.CHRISTMAS_HAT, ModItems.BEANIE_BLACK, ModItems.BEANIE_RED, ModItems.BEANIE_GREEN};
                            Item[] chestList = new Item[]{ModItems.SWEATER_BLACK, ModItems.SWEATER_RED, ModItems.SWEATER_GREEN};
                            Item[] legsList = new Item[]{ModItems.WINTER_JEANS};
                            Item[] bootsList = new Item[]{ModItems.WINTER_BOOTS, ModItems.ICE_SKATES};

                            Item helmet = helmetList[random.nextInt(helmetList.length)];
                            Item chest = chestList[random.nextInt(chestList.length)];
                            Item legs = legsList[random.nextInt(legsList.length)];
                            Item boots = bootsList[random.nextInt(bootsList.length)];

                            mob.equipStack(EquipmentSlot.HEAD, new ItemStack(helmet));
                            mob.equipStack(EquipmentSlot.CHEST, new ItemStack(chest));
                            mob.equipStack(EquipmentSlot.LEGS, new ItemStack(legs));
                            mob.equipStack(EquipmentSlot.FEET, new ItemStack(boots));

                            ItemStack giftStack = new ItemStack(ModItems.PRESENT_WRAPPED_RED_ITEM);
                            PresentHelper.getSantaPresent("Anybody", 0).toStack(giftStack);

                            mob.equipStack(EquipmentSlot.OFFHAND, giftStack);

                            mob.setEquipmentDropChance(EquipmentSlot.OFFHAND, 1);
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
