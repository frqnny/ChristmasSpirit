package io.github.frqnny.cspirit;

import io.github.frqnny.cspirit.client.model.ChristmasTreeModel;
import io.github.frqnny.cspirit.client.model.ReindeerModel;
import io.github.frqnny.cspirit.client.model.SleighModel;
import io.github.frqnny.cspirit.client.render.*;
import io.github.frqnny.cspirit.client.screen.CookieTrayGUI;
import io.github.frqnny.cspirit.client.screen.CookieTrayScreen;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentGUI;
import io.github.frqnny.cspirit.client.screen.UnwrappedPresentScreen;
import io.github.frqnny.cspirit.entity.CandyCaneProjectileEntity;
import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import io.github.frqnny.cspirit.init.ModBlocks;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModPackets;
import io.github.frqnny.cspirit.util.BoatSpawnNetworkHandler;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.item.Item;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

public class ChristmasSpiritClient implements ClientModInitializer {
    public static final EntityModelLayer CHRISTMAS_TREE = new EntityModelLayer(ChristmasSpirit.id("christmas_tree"), "christmas_tree");
    public static final EntityModelLayer REINDEER = new EntityModelLayer(ChristmasSpirit.id("reindeer"), "reindeer");
    public static final EntityModelLayer SLEIGH = new EntityModelLayer(ChristmasSpirit.id("sleigh"), "sleigh");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CHRISTMAS_TREE, ChristmasTreeModel::getModelData);
        EntityModelLayerRegistry.registerModelLayer(SLEIGH, SleighModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(REINDEER, ReindeerModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_UNWRAPPED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRESENT_WRAPPED_PINK, RenderLayer.getCutout());
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

        BlockEntityRendererRegistry.register(ModBlocks.COOKIE_TRAY_BLOCK_ENTITY, CookieTrayBlockEntityRenderer::new);

        BoatSpawnNetworkHandler.register();
        EntityRendererRegistry.register(ModEntityTypes.CANDY_CANE_PROJECTILE, CandyCaneProjectileEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CHRISTMAS_TREE, ChristmasTreeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SLEIGH_ENTITY, SleighEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.JACK_FROST_ENTITY, JackFrostEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.REINDEER_ENTITY, ReindeerEntityRenderer::new);
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
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.TREE_SPAWN_PACKET, (client, handler, buf, sender) -> {
            double x = buf.readDouble();
            double y = buf.readDouble();
            double z = buf.readDouble();
            int entityId = buf.readInt();
            UUID uuid = buf.readUuid();
            boolean isWhite = buf.readBoolean();
            ChristmasTreeEntity tree = new ChristmasTreeEntity(MinecraftClient.getInstance().world, new Vec3d(x, y, z), 0, isWhite);
            tree.updateTrackedPosition(new Vec3d(x, y, z));
            tree.setId(entityId);
            tree.setUuid(uuid);
            handler.getWorld().addEntity(entityId, tree);
        });
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.CANDY_CANE_SPAWN_PACKET, (client, handler, buf, sender) -> {
            double x = buf.readDouble();
            double y = buf.readDouble();
            double z = buf.readDouble();
            int entityId = buf.readInt();
            UUID uuid = buf.readUuid();
            UUID ownerUUID = buf.readUuid();
            byte type = buf.readByte();
            CandyCaneProjectileEntity candyCane = new CandyCaneProjectileEntity(MinecraftClient.getInstance().world, handler.getWorld().getPlayerByUuid(ownerUUID), type);
            candyCane.updateTrackedPosition(new Vec3d(x, y, z));
            candyCane.setId(entityId);
            candyCane.setUuid(uuid);
            handler.getWorld().addEntity(entityId, candyCane);
        });
    }
}
