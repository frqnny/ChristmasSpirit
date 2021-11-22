package io.github.frqnny.cspirit.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class ItemHelper {
    public static ItemEntity spawnStack(World world, double x, double y, double z, double motionX, double motionY, double motionZ, ItemStack stack) {
        ItemEntity item = new ItemEntity(world, x, y, z, stack);
        item.setToDefaultPickupDelay();
        world.spawnEntity(item);
        return item;
    }

    public static ItemEntity spawnStack(World world, double x, double y, double z, ItemStack stack) {
        return spawnStack(world, x, y, z, 0, 0.2D, 0, stack);
    }

    public static void spawnStackAtEntity(World world, Entity entity, ItemStack stack) {
        spawnStack(world, entity.getX(), entity.getY(), entity.getZ(), stack);
    }

    public static NbtCompound getNBT(ItemStack is) {

        if (is.getNbt() == null) {
            is.setNbt(new NbtCompound());
        }

        return is.getNbt();
    }
}
