package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.entity.ChristmasTreeEntity;
import io.github.frqnny.cspirit.util.IItemSpiritSupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class ChristmasTreeItem extends Item implements IItemSpiritSupplier {
    public boolean white;

    public ChristmasTreeItem(Settings settings, boolean bl) {
        super(settings);
        white = bl;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() != null) {

            ChristmasTreeEntity tree = new ChristmasTreeEntity(context.getWorld(), context.getHitPos(), context.getPlayerYaw() + 180, white);
            context.getWorld().spawnEntity(tree);

            context.getStack().decrement(1);

            if (!context.getWorld().isClient) {
                context.getPlayer().playSound(SoundEvents.BLOCK_WOOD_PLACE, 1, 1);
                context.getPlayer().playSound(SoundEvents.BLOCK_GRASS_PLACE, 1, 1);
            }

            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }


    @Override
    public int getMaxStacks() {
        return 2;
    }
}
