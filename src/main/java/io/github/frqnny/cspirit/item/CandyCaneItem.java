package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CandyCaneItem extends BlockItem implements IItemSpiritSupplier {
    public CandyCaneItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        EffectHelper.giveHolidaySpiritStackEffect((PlayerEntity) user, 2);

        return super.finishUsing(stack, world, user);
    }

    @Override
    public int getMaxStacks() {
        return 2;
    }
}
