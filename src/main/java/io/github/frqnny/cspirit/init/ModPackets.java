package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.block.WrappedPresentBlock;
import io.github.frqnny.cspirit.blockentity.WrappedPresentBlockEntity;
import io.github.frqnny.cspirit.present.PresentConstructor;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModPackets {
    public static final Identifier WRAP_PACKET_ID = ChristmasSpirit.id("wrap_packet");

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(WRAP_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            World world = handler.player.world;
            PresentConstructor presentConstructor = PresentConstructor.fromNBT(buf.readCompoundTag());
            BlockPos pos = buf.readBlockPos();

            server.execute(() -> {
                Inventory inv = (Inventory) world.getBlockEntity(pos);
                ItemStack stack = inv.getStack(0);
                world.setBlockState(pos, presentConstructor.getStyle().getBlock().getDefaultState());
                BlockEntity be = world.getBlockEntity(pos);
                if (be instanceof WrappedPresentBlockEntity) {
                    ((WrappedPresentBlockEntity) be).setPresentConstructor(presentConstructor);
                }
                ((Inventory) be).setStack(0, stack);
            });
        });
    }
}
