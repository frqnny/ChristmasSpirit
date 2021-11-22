package io.github.frqnny.cspirit.init;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.blockentity.WrappedPresentBlockEntity;
import io.github.frqnny.cspirit.entity.ReindeerEntity;
import io.github.frqnny.cspirit.present.PresentConstructor;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModPackets {
    public static final Identifier WRAP_PACKET_ID = ChristmasSpirit.id("wrap_packet");
    public static final Identifier REINDEER_JUMP_PACKET = ChristmasSpirit.id("reindeer_jump");
    public static final Identifier SPAWN_PACKET_TREE = ChristmasSpirit.id("christmas_tree_spawn_packet");

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(WRAP_PACKET_ID, (server, player, handler, buf, responseSender) -> {
            World world = handler.player.world;
            PresentConstructor presentConstructor = PresentConstructor.fromNBT(buf.readNbt());
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

        ServerPlayNetworking.registerGlobalReceiver(REINDEER_JUMP_PACKET, (server, player, handler, buf, responseSender) -> {

            server.execute(() -> {

                if (player != null && player.getVehicle() instanceof ReindeerEntity reindeer) {
                    reindeer.getDataTracker().set(ReindeerEntity.JUMP_KEY, buf.readBoolean());
                }
            });
        });
    }
}
