package io.github.frqnny.cspirit.blockentity;

import io.github.frqnny.cspirit.blockentity.inventory.CSBlockInventory;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public abstract class CSBlockEntity extends BlockEntity implements CSBlockInventory, BlockEntityClientSerializable {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(getSizeInventory(), ItemStack.EMPTY);

    public CSBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public abstract int getSizeInventory();

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, items);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        return super.toTag(tag);
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        Inventories.fromTag(tag, items);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        return tag;
    }
}
