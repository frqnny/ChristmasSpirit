package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrostedGlassPaneBlock extends PaneBlock {
    public FrostedGlassPaneBlock(Settings settings) {
        super(settings);
    }


    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            ItemHelper.spawnStack(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, new ItemStack(asItem()));
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


}
