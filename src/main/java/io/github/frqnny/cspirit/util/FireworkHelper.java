package io.github.frqnny.cspirit.util;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.DyeColor;

import java.util.List;

public class FireworkHelper {

    public static void spawnFirework(PlayerEntity player, byte flight, boolean doesFlicker, boolean doesTrail, DyeColor color1, DyeColor color2) {

        ItemStack fireworkStack = new ItemStack(Items.FIREWORK_ROCKET);
        NbtCompound fireworkNBT = fireworkStack.getOrCreateSubNbt("Fireworks");

        NbtCompound explosionNBT = fireworkNBT.getCompound("Explosion");
        NbtList listnbt = new NbtList();
        listnbt.add(explosionNBT);

        explosionNBT.putBoolean("Flicker", doesFlicker);
        explosionNBT.putBoolean("Trail", doesTrail);

        List<Integer> colorList = Lists.newArrayList();

        colorList.add(color1.getFireworkColor());
        colorList.add(color2.getFireworkColor());

        explosionNBT.putIntArray("Colors", colorList);
        explosionNBT.putByte("Type", (byte) FireworkRocketItem.Type.STAR.getId());

        fireworkNBT.putByte("Flight", flight);
        fireworkNBT.put("Explosions", listnbt);

        FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(player.world, player.getX(), player.getY(), player.getZ(), fireworkStack);
        player.world.spawnEntity(fireworkEntity);
    }
}
