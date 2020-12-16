package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FruitCakeBlock extends CakeBlock implements IItemSpiritSupplier {
    public static final VoxelShape first = Block.createCuboidShape(1.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape second = Block.createCuboidShape(3.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape third = Block.createCuboidShape(5.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape fourth = Block.createCuboidShape(7.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape fifth = Block.createCuboidShape(9.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape sixth = Block.createCuboidShape(11.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);
    public static final VoxelShape seventh = Block.createCuboidShape(13.0D, 0.0D, 4.0D, 15.0D, 8.0D, 12.0D);

    public FruitCakeBlock(Settings settings) {
        super(settings);
    }

    private static ActionResult eatSlice(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        player.incrementStat(Stats.EAT_CAKE_SLICE);
        if (player.canConsume(false)) {
            player.getHungerManager().add(4, 0.3F);
        }
        EffectHelper.giveHolidaySpiritStackEffect(player, 3);

        int i = state.get(BITES);

        if (i < 6) world.setBlockState(pos, state.with(BITES, i + 1), 3);
        else world.removeBlock(pos, false);

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(first, second, third, fourth, fifth, sixth, seventh);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("hunger.icon.4"));
        tooltip.add(new TranslatableText("saturation.icon.0.3"));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {

            ItemStack itemstack = player.getStackInHand(hand);

            if (FruitCakeBlock.eatSlice(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return FruitCakeBlock.eatSlice(world, pos, state, player);
    }

    @Override
    public int getMaxStacks() {
        return 3;
    }
}
