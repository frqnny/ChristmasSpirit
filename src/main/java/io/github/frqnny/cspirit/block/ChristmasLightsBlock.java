package io.github.frqnny.cspirit.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class ChristmasLightsBlock extends CSBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final VoxelShape SHAPE_N = Block.createCuboidShape(0, 4, 0, 16, 12, 2);
    public static final VoxelShape SHAPE_E = Block.createCuboidShape(14, 4, 0, 16, 12, 16);
    public static final VoxelShape SHAPE_S = Block.createCuboidShape(0, 4, 14, 16, 12, 16);
    public static final VoxelShape SHAPE_W = Block.createCuboidShape(0, 4, 0, 2, 12, 16);

    public ChristmasLightsBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getChristmasLights(BlockState state) {
        return switch (state.get(FACING)) {
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getChristmasLights(state);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
