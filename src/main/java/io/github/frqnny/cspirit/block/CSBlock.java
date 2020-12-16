package io.github.frqnny.cspirit.block;


import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CSBlock extends Block {
    public CSBlock(Settings settings) {
        super(settings);
    }

    public void addDrops(BlockState state, World world, BlockPos pos, List<ItemStack> list) {
        list.add(new ItemStack(this.asItem()));
    }


    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {

            if (moved && PistonBlock.isMovable(state, world, pos, Direction.NORTH, false, Direction.NORTH)) {
                return;
            }

            List<ItemStack> drops = new ArrayList<>();
            addDrops(state, world, pos, drops);
            for (ItemStack stack : drops) {
                ItemHelper.spawnStack(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, stack);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
