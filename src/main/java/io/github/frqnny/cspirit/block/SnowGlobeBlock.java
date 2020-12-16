package io.github.frqnny.cspirit.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SnowGlobeBlock extends CSBlock {
    public static final VoxelShape first = Block.createCuboidShape(3, 0, 3, 13, 1, 13);
    public static final VoxelShape second = Block.createCuboidShape(3.5D, 1, 3.5D, 12.5D, 10, 12.5D);

    public SnowGlobeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ((ServerWorld) world).setWeather(0, 20 * 60 * 5, true, false);
        } else {
            for (int i = 0; i < 10; i++) {
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.SNOW_BLOCK.getDefaultState()), pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D, 0, 0, 0);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(first, second);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }
}
