package io.github.frqnny.cspirit.block;

import io.github.frqnny.cspirit.blockentity.WrappedPresentBlockEntity;
import io.github.frqnny.cspirit.init.ModSounds;
import io.github.frqnny.cspirit.present.PresentConstructor;
import io.github.frqnny.cspirit.util.ItemHelper;
import io.github.frqnny.cspirit.util.PresentHelper;
import io.github.frqnny.cspirit.util.SoundHelper;
import io.github.frqnny.cspirit.util.TimeHelper;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WrappedPresentBlock extends UnwrappedPresentBlock implements BlockEntityProvider {
    public static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 13, 15);

    public WrappedPresentBlock(Settings settings) {
        super(settings);
    }

    public static void spawnPresent(World world, BlockPos pos, PresentConstructor constructor, ItemStack giftStack) {

        ItemStack stack = new ItemStack(constructor.getStyle().getBlock().asItem());

        constructor.toStack(stack);

        NbtCompound nbt = ItemHelper.getNBT(stack);
        DefaultedList<ItemStack> giftList = DefaultedList.of();
        giftList.add(0, giftStack);
        Inventories.writeNbt(nbt, giftList);

        ItemHelper.spawnStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return super.canReplace(state, context);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity be = world.getBlockEntity(pos);

        if (!world.isClient) {

            if (be instanceof WrappedPresentBlockEntity) {

                WrappedPresentBlockEntity present = (WrappedPresentBlockEntity) be;
                boolean isAnybody = present.getPresentConstructor().toPlayerName.equalsIgnoreCase("anybody");
                boolean isToPlayer = player.getDisplayName().getString().equalsIgnoreCase(present.getPresentConstructor().toPlayerName);
                boolean isFromPlayer = player.getDisplayName().getString().equalsIgnoreCase(present.getPresentConstructor().toPlayerName);

                if (isAnybody || isToPlayer || isFromPlayer || player.isCreative()) {
                    spawnPresent(world, pos, present.getPresentConstructor(), ((Inventory) present).getStack(0));
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                } else {
                    WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.RED, "This present belongs to " + present.getPresentConstructor().toPlayerName + "! You can't pick it up!");
                    world.setBlockState(pos, present.getPresentConstructor().getStyle().getBlock().getDefaultState());
                    ((WrappedPresentBlockEntity) world.getBlockEntity(pos)).setPresentConstructor(present.getPresentConstructor());
                }
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {

            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof WrappedPresentBlockEntity) {

                WrappedPresentBlockEntity present = (WrappedPresentBlockEntity) be;

                if (player.isSneaking()) {
                    WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.WHITE, "From: " + present.getPresentConstructor().fromPlayerName);
                    WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.WHITE, "To: " + present.getPresentConstructor().toPlayerName);
                    WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.WHITE, "Open on the " + TimeHelper.getFormattedDay(present.getPresentConstructor().getActualDay()));
                } else if (player.getDisplayName().getString().equalsIgnoreCase(present.getPresentConstructor().toPlayerName) || present.getPresentConstructor().toPlayerName.equalsIgnoreCase("anybody")) {

                    if (TimeHelper.getCurrentDay() >= present.getPresentConstructor().getActualDay()) {

                        ItemStack stack = present.getStack(0);

                        if (present.getPresentConstructor().fromPlayerName.equalsIgnoreCase("santa")) {
                            stack = PresentHelper.getSantaGiftedStack(player, present.getPresentConstructor().day);
                        }

                        ItemHelper.spawnStack(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, stack);
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());

                        player.playSound(ModSounds.PRESENT_UNWRAP, 1, 1);
                        SoundHelper.sendSoundToClient((ServerPlayerEntity) player, ModSounds.PRESENT_UNWRAP);
                    } else {
                        WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.RED, "You can't open this present yet!");
                        WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.RED, "You must wait until the " + TimeHelper.getFormattedDay(present.getPresentConstructor().getActualDay()) + "!");
                    }
                } else {
                    WrappedPresentBlockEntity.getUnitName(player).printMessage(Formatting.RED, "This present belongs to " + present.getPresentConstructor().toPlayerName + "! You can't open it!");
                }
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WrappedPresentBlockEntity(pos, state);
    }
}
