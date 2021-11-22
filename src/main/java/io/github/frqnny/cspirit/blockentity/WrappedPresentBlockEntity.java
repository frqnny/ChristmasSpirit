package io.github.frqnny.cspirit.blockentity;

import io.github.frqnny.cspirit.init.ModBlocks;
import io.github.frqnny.cspirit.present.PresentConstructor;
import io.github.frqnny.cspirit.util.UnitChatMessage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class WrappedPresentBlockEntity extends CSBlockEntity {
    private PresentConstructor presentConstructor;

    public WrappedPresentBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.WRAPPED_PRESENT_BLOCK_ENTITY, pos, state);
        presentConstructor = new PresentConstructor();
    }

    public static UnitChatMessage getUnitName(PlayerEntity player) {
        return new UnitChatMessage("Wrapped Present", player);
    }

    public PresentConstructor getPresentConstructor() {
        return presentConstructor;
    }

    public void setPresentConstructor(PresentConstructor presentConstructor) {
        this.presentConstructor = presentConstructor;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        presentConstructor = PresentConstructor.fromNBT(tag);
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        presentConstructor.toNBT(tag);
    }
}
