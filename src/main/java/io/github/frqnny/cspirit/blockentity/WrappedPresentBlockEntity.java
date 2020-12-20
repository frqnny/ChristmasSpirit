package io.github.frqnny.cspirit.blockentity;

import io.github.frqnny.cspirit.init.ModBlocks;
import io.github.frqnny.cspirit.present.PresentConstructor;
import io.github.frqnny.cspirit.util.UnitChatMessage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

public class WrappedPresentBlockEntity extends CSBlockEntity {
    private PresentConstructor presentConstructor;

    public WrappedPresentBlockEntity() {
        super(ModBlocks.WRAPPED_PRESENT_BLOCK_ENTITY);
        presentConstructor = new PresentConstructor();
    }

    public PresentConstructor getPresentConstructor() {
        return presentConstructor;
    }

    public void setPresentConstructor(PresentConstructor presentConstructor) {
        this.presentConstructor = presentConstructor;
    }

    public UnitChatMessage getUnitName(PlayerEntity player) {
        return new UnitChatMessage("Wrapped Present", player);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        presentConstructor = PresentConstructor.fromNBT(tag);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        presentConstructor.toNBT(tag);
        return super.toTag(tag);
    }
}
