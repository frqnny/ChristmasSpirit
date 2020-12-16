package io.github.frqnny.cspirit;

import io.github.frqnny.cspirit.client.render.CookieTrayBlockEntityRenderer;
import io.github.frqnny.cspirit.client.screen.CookieTrayGUI;
import io.github.frqnny.cspirit.client.screen.CookieTrayScreen;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentGUI;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentScreen;
import io.github.frqnny.cspirit.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class ChristmasSpiritClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_UNWRAPPED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STOCKING_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STOCKING_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STOCKING_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORNAMENT_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORNAMENT_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORNAMENT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINGER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEPPERMINT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REEF, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLAND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINGERBREAD_HOUSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINGERBREAD_HOUSE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MISTLETOE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICICLES, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FROSTED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FROSTED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SNOW_GLOBE, RenderLayer.getCutout());

        ScreenRegistry.Factory<CookieTrayGUI, CookieTrayScreen> COOKIE_TRAY_SCREEN = (gui, inventory, title) -> new CookieTrayScreen(gui, inventory.player, title);
        ScreenRegistry.register(ChristmasSpirit.COOKIE_TRAY_GUI, COOKIE_TRAY_SCREEN);

        ScreenRegistry.Factory<UnwrappedPresentGUI, UnwrappedPresentScreen> UNWRAPPED_PRESENT_SCREEN = (gui, inventory, title) -> new UnwrappedPresentScreen(gui, inventory.player, title);
        ScreenRegistry.register(ChristmasSpirit.UNWRAPPED_PRESENT_GUI, UNWRAPPED_PRESENT_SCREEN);

        BlockEntityRendererRegistry.INSTANCE.register(ModBlocks.COOKIE_TRAY_BLOCK_ENTITY, CookieTrayBlockEntityRenderer::new);
    }
}
