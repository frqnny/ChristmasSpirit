package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.entity.SleighEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class SleighItem extends Item {
    public SleighItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() != null) {
            SleighEntity sleigh = new SleighEntity(context.getWorld(), context.getHitPos().x, context.getHitPos().y, context.getHitPos().z);
            sleigh.setYaw(context.getPlayerYaw());
            context.getWorld().spawnEntity(sleigh);
            context.getStack().decrement(1);

            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }
}
