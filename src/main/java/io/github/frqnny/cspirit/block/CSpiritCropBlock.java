package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class CSpiritCropBlock extends CropBlock {
    public static final VoxelShape first = Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    public static final VoxelShape second = Block.createCuboidShape(0, 0, 0, 16, 2, 16);
    public static final VoxelShape third = Block.createCuboidShape(0, 0, 0, 16, 4, 16);
    public static final VoxelShape fourth = Block.createCuboidShape(0, 0, 0, 16, 4, 16);
    public static final VoxelShape fifth = Block.createCuboidShape(0, 0, 0, 16, 6, 16);
    public static final VoxelShape sixth = Block.createCuboidShape(0, 0, 0, 16, 6, 16);
    public static final VoxelShape seventh = Block.createCuboidShape(0, 0, 0, 16, 8, 16);
    public static final VoxelShape eighth = Block.createCuboidShape(0, 0, 0, 16, 8, 16);

    public CSpiritCropBlock(Settings settings) {
        super(settings);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(first, second, third, fourth, fifth, sixth, seventh, eighth);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return this.asItem();
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {

            Random random = new Random();
            Item cropItem = getSeedsItem().asItem();

            int seedAmount = 1 + (state.get(AGE) == 7 ? random.nextInt(2) : 0);
            int cropAmount = state.get(AGE) == 7 ? random.nextInt(2) + 1 : 0;

            if (cropItem == null) {
                seedAmount = 1 + (state.get(AGE) == 7 ? random.nextInt(2) + 1 : 0);
            }

            ///System.out.println(getSeedsItem());

            ItemHelper.spawnStack(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, new ItemStack(getSeedsItem(), seedAmount));
            if (cropItem != null)
                ItemHelper.spawnStack(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, new ItemStack(cropItem, cropAmount));

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
