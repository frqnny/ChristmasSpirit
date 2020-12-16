package io.github.frqnny.cspirit.util;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.DyeColor;

import java.util.List;

public class FireworkHelper {

    public static void spawnFirework(PlayerEntity player, byte flight, boolean doesFlicker, boolean doesTrail, DyeColor color1, DyeColor color2) {

        ItemStack fireworkStack = new ItemStack(Items.FIREWORK_ROCKET);
        CompoundTag fireworkNBT = fireworkStack.getOrCreateSubTag("Fireworks");

        CompoundTag explosionNBT = fireworkNBT.getCompound("Explosion");
        ListTag listnbt = new ListTag();
        listnbt.add(explosionNBT);

        explosionNBT.putBoolean("Flicker", doesFlicker);
        explosionNBT.putBoolean("Trail", doesTrail);

        List<Integer> colorList = Lists.newArrayList();

        colorList.add(color1.getFireworkColor());
        colorList.add(color2.getFireworkColor());

        explosionNBT.putIntArray("Colors", colorList);
        explosionNBT.putByte("Type", (byte) FireworkItem.Type.STAR.getId());

        fireworkNBT.putByte("Flight", flight);
        fireworkNBT.put("Explosions", listnbt);

        FireworkRocketEntity fireworkEntity = new FireworkRocketEntity(player.world, player.getX(), player.getY(), player.getZ(), fireworkStack);
        player.world.spawnEntity(fireworkEntity);
    }
}
