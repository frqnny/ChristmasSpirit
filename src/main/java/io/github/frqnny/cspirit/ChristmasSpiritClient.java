package io.github.frqnny.cspirit;

import io.github.frqnny.cspirit.client.render.*;
import io.github.frqnny.cspirit.client.screen.CookieTrayGUI;
import io.github.frqnny.cspirit.client.screen.CookieTrayScreen;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentGUI;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentScreen;
import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import io.github.frqnny.cspirit.init.ModBlocks;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModPackets;
import io.github.frqnny.cspirit.util.BoatSpawnNetworkHandler;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import io.github.frqnny.cspirit.util.PacketHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

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

        ClientSidePacketRegistry.INSTANCE.register(ChristmasSpirit.id("spawnpacket"), PacketHelper::spawnFrom);
        BoatSpawnNetworkHandler.register();
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CANDY_CANE_PROJECTILE, (entityRenderDispatcher, context) -> new CandyCaneProjectileEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CHRISTMAS_TREE, (entityRenderDispatcher, context) -> new ChristmasTreeEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.SLEIGH_ENTITY, (entityRenderDispatcher, context) -> new SleighEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.JACK_FROST_ENTITY, (entityRenderDispatcher, context) -> new JackFrostEntityRenderer(entityRenderDispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.REINDEER_ENTITY, ((entityRenderDispatcher, context) -> new ReindeerEntityRenderer(entityRenderDispatcher)));
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
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.SPAWN_PACKET_TREE, (client, handler, buf, sender) -> {
            double x = buf.readDouble();
            double y = buf.readDouble();
            double z = buf.readDouble();
            int entityId = buf.readInt();
            UUID uuid = buf.readUuid();
            boolean isWhite = buf.readBoolean();
            ChristmasTreeEntity tree = new ChristmasTreeEntity(MinecraftClient.getInstance().world, new Vec3d(x, y, z), 0, isWhite);
            tree.updateTrackedPosition(new Vec3d(x, y, z));
            tree.setEntityId(entityId);
            tree.setUuid(uuid);
            MinecraftClient.getInstance().world.addEntity(entityId, tree);
        });
    }
}
