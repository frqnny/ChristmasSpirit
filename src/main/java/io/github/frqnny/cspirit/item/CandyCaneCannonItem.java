package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.entity.CandyCaneProjectileEntity;
import io.github.frqnny.cspirit.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CandyCaneCannonItem extends Item {
    private static final int MAX_CHARGE_TIME = 20;

    public CandyCaneCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity) {

            PlayerEntity player = (PlayerEntity) entity;

            if (getMaxUseTime(stack) - player.getItemUseTimeLeft() == MAX_CHARGE_TIME) {
                player.playSound(SoundEvents.UI_BUTTON_CLICK, 1, 1);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemstack = user.getStackInHand(hand);

        if (hand == Hand.MAIN_HAND) {

            ItemStack candyCaneStack = ItemStack.EMPTY;
            int size = user.getInventory().size();

            for (int i = 0; i < size; i++) {

                ItemStack stackInSlot = user.getInventory().getStack(i);

                if (stackInSlot.getItem() instanceof CandyCaneItem) {
                    candyCaneStack = stackInSlot;
                    break;
                }
            }

            if (!candyCaneStack.isEmpty()) {
                user.setCurrentHand(hand);
            }
        }

        return TypedActionResult.consume(itemstack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {

            PlayerEntity player = (PlayerEntity) user;

            if (getMaxUseTime(stack) - remainingUseTicks >= MAX_CHARGE_TIME) {

                ItemStack candyCaneStack = ItemStack.EMPTY;

                int size = player.getInventory().size();
                for (int i = 0; i < size; i++) {

                    ItemStack stackInSlot = player.getInventory().getStack(i);

                    if (stackInSlot.getItem() instanceof CandyCaneItem) {
                        candyCaneStack = stackInSlot;
                        break;
                    }
                }

                if (!candyCaneStack.isEmpty()) {

                    byte candyType = 0;

                    if (candyCaneStack.getItem() == ModItems.CANDY_CANE_GREEN) {
                        candyType = 1;
                    } else if (candyCaneStack.getItem() == ModItems.CANDY_CANE_BLUE) {
                        candyType = 2;
                    }

                    CandyCaneProjectileEntity entity = new CandyCaneProjectileEntity(world, player, candyType);
                    entity.setCritical(true);
                    entity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 3, 1.0F);
                    entity.
                            world.spawnEntity(entity);
                    candyCaneStack.decrement(1);

                    player.playSound(SoundEvents.ITEM_TRIDENT_THROW, 1, 1);
                    player.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1, 1);
                }
            }
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
