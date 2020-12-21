package io.github.frqnny.cspirit.util;

import io.github.frqnny.cspirit.init.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class FrostHelper {

    public static boolean doesEntityHaveFrostArmorSet(LivingEntity entity) {
        boolean hasHelmet = entity.getEquippedStack(EquipmentSlot.HEAD).getItem().equals(ModItems.FROST_HELMET);
        boolean hasChestplate = entity.getEquippedStack(EquipmentSlot.CHEST).getItem().equals(ModItems.FROST_CHESTPLATE);
        boolean hasLeggings = entity.getEquippedStack(EquipmentSlot.LEGS).getItem().equals(ModItems.FROST_LEGGINGS);
        boolean hasBoots = entity.getEquippedStack(EquipmentSlot.FEET).getItem().equals(ModItems.FROST_BOOTS);

        return hasHelmet && hasChestplate && hasLeggings && hasBoots;
    }
}
