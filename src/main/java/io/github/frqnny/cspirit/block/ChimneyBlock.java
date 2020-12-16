package io.github.frqnny.cspirit.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ChimneyBlock extends CSBlock {
    private static final VoxelShape first = Block.createCuboidShape(0, 0, 0, 2, 16, 16);
    private static final VoxelShape second = Block.createCuboidShape(14, 0, 0, 16, 16, 16);
    private static final VoxelShape third = Block.createCuboidShape(2, 0, 0, 14, 16, 2);
    private static final VoxelShape fourth = Block.createCuboidShape(2, 0, 14, 14, 16, 16);
    private static final VoxelShape complete = VoxelShapes.union(first, second, third, fourth);

    public ChimneyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return complete;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }
}
