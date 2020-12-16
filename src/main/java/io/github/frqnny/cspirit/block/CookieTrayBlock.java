package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.blockentity.CookieTrayBlockEntity;
import io.github.frqnny.cspirit.blockentity.inventory.CSBlockInventory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CookieTrayBlock extends CSBlock implements BlockEntityProvider {
    public static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 1, 14);

    public CookieTrayBlock(Settings settings) {
        super(settings);
    }

    public static void takeNextCookie(PlayerEntity player, CSBlockInventory inv) {

        int size = inv.getItems().size();
        for (int i = 0; i < size; i++) {

            if (inv.getStack(i).getCount() > 0) {

                ItemStack stack = inv.getStack(i).copy();
                stack.setCount(1);

                if (player.giveItemStack(stack)) {
                    inv.getStack(i).decrement(1);
                    break;
                }

            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CookieTrayBlockEntity();
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.isSneaking()) {

            BlockEntity be = world.getBlockEntity(pos);

            if (be instanceof CookieTrayBlockEntity) {
                takeNextCookie(player, (CSBlockInventory) be);
            }

            return ActionResult.SUCCESS;
        } else if (player.isSneaking() && player.getStackInHand(hand).isEmpty()) {
            BlockEntity be = world.getBlockEntity(pos);

            if (be instanceof CookieTrayBlockEntity) {
                player.openHandledScreen((NamedScreenHandlerFactory) be);
            }


            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CookieTrayBlockEntity) {
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
