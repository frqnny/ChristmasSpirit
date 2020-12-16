package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.blockentity.UnwrappedPresentBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UnwrappedPresentBlock extends Block implements BlockEntityProvider {
    public UnwrappedPresentBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new UnwrappedPresentBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof UnwrappedPresentBlockEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory) be);
            }
        }
        return ActionResult.SUCCESS;
    }
}
