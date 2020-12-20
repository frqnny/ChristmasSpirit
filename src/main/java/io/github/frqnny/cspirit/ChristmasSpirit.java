package io.github.frqnny.cspirit;

import io.github.frqnny.cspirit.blockentity.CookieTrayBlockEntity;
import io.github.frqnny.cspirit.blockentity.UnwrappedPresentBlockEntity;
import io.github.frqnny.cspirit.client.screen.CookieTrayGUI;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentGUI;
import io.github.frqnny.cspirit.command.CSCommandBase;
import io.github.frqnny.cspirit.config.ChristmasSpiritConfig;
import io.github.frqnny.cspirit.data.CSDataSerializers;
import io.github.frqnny.cspirit.data.DailyPresentDataFile;
import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.data.SantaGiftListFile;
import io.github.frqnny.cspirit.init.*;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import java.util.Set;
import java.util.function.Predicate;

public class ChristmasSpirit implements ModInitializer {
    public static final String MODID = "cspirit";
    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(
            id("main_item_group"),
            () -> new ItemStack(ModItems.CHRISTMAS_HAT));
    public static final ItemGroup BAKING = FabricItemGroupBuilder.build(
            id("baking_item_group"),
            () -> new ItemStack(ModItems.SUGAR_COOKIE_CIRCLE));
    public static final ItemGroup DECORATION = FabricItemGroupBuilder.build(
            id("decoration_item_group"),
            () -> new ItemStack(ModItems.GINGERBREAD_HOUSE));

    public static ScreenHandlerType<CookieTrayGUI> COOKIE_TRAY_GUI;
    public static ScreenHandlerType<UnwrappedPresentGUI> UNWRAPPED_PRESENT_GUI;
    public static Set<Item> NAUGHTY;
    private static ChristmasSpiritConfig config;

    public static Identifier id(String namespace) {
        return new Identifier(MODID, namespace);
    }

    public static ChristmasSpiritConfig getConfig() {
        config = AutoConfig.getConfigHolder(ChristmasSpiritConfig.class).getConfig();
        return config;
    }

    public static Predicate<BiomeSelectionContext> shouldFreezeOceanBiomeIfOcean() {
        return (context) -> {
            if (context.getBiome().getCategory() == Biome.Category.OCEAN) {
                return getConfig().worldGen.freezeOceans;
            } else {
                return true;
            }
        };
    }

    public static Predicate<BiomeSelectionContext> freezeTheWorld() {
        return (context) -> getConfig().worldGen.freezeWorld;
    }

    @Override
    public void onInitialize() {
        AutoConfig.register(ChristmasSpiritConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ChristmasSpiritConfig.class).getConfig();
        NaughtyListFile.init();
        DailyPresentDataFile.init();
        SantaGiftListFile.init();

        ModBlocks.init();
        ModItems.init();
        ModSounds.init();
        ModEffects.init();
        ModPackets.init();
        CommandRegistrationCallback.EVENT.register(((commandDispatcher, b) -> CSCommandBase.register(commandDispatcher)));
        ModEvents.init();
        ModEntityTypes.init();

        BiomeModifications.create(
                id("frozen_world"))
                .add(ModificationPhase.POST_PROCESSING,
                        BiomeSelectors.foundInOverworld().and(shouldFreezeOceanBiomeIfOcean()).and(freezeTheWorld()),
                        (context) -> context.getWeather().setTemperature(0F)
                );

        COOKIE_TRAY_GUI = ScreenHandlerRegistry.registerExtended(id("cookie_tray"), (syncId, inventory, buf) -> {

            BlockEntity be = inventory.player.world.getBlockEntity(buf.readBlockPos());
            if (be instanceof CookieTrayBlockEntity) {
                return new CookieTrayGUI(syncId, inventory, (Inventory) be, null);
            } else {
                throw new RuntimeException("Cookie Tray Block GUI activated, but the block entity is not a CookieTrayBlockEntity");
            }
        });

        UNWRAPPED_PRESENT_GUI = ScreenHandlerRegistry.registerExtended(id("present_unwrapped"), (syncId, inventory, buf) -> {
            BlockPos pos = buf.readBlockPos();
            BlockEntity be = inventory.player.world.getBlockEntity(pos);
            if (be instanceof UnwrappedPresentBlockEntity) {
                return new UnwrappedPresentGUI(syncId, inventory, (Inventory) be, pos);
            } else {
                throw new RuntimeException("Unwrapped Present Block GUI activated, but the block entity is not a UnwrappedPresentBlockEntity");
            }
        });

        TrackedDataHandlerRegistry.register(CSDataSerializers.ITEMSTACK_ARRAY_4);
        NAUGHTY = new ObjectOpenHashSet<>(8);
        NAUGHTY.add(ModItems.LUMP_OF_COAL);
        NAUGHTY.add(ModItems.FROST_INGOT);
        NAUGHTY.add(ModItems.FROST_HELMET);
        NAUGHTY.add(ModItems.FROST_CHESTPLATE);
        NAUGHTY.add(ModItems.FROST_LEGGINGS);
        NAUGHTY.add(ModItems.FROST_BOOTS);
        NAUGHTY.add(ModItems.FROSTMOURNE);
        NAUGHTY.add(ModItems.CANDY_CANE_CANNON);
    }
}
