package io.github.frqnny.cspirit.mixin;

import io.github.frqnny.cspirit.ChristmasSpirit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void naughtyItemsAreBeingNaughty(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo info) {
        if (ChristmasSpirit.NAUGHTY.contains(stack.getItem()) && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack stackToThrow = stack.copy();
            player.inventory.setStack(slot, ItemStack.EMPTY);
            player.dropItem(stackToThrow, true, true);


        }
    }
}
