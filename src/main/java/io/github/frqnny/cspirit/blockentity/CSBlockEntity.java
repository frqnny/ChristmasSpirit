package io.github.frqnny.cspirit.blockentity;

import io.github.frqnny.cspirit.blockentity.inventory.CSBlockInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public abstract class CSBlockEntity extends BlockEntity implements CSBlockInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(getSizeInventory(), ItemStack.EMPTY);

    public CSBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public abstract int getSizeInventory();

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }


    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        Inventories.writeNbt(tag, items);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        Inventories.readNbt(tag, items);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this, BlockEntity::createNbt);
    }
}
