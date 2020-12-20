package io.github.frqnny.cspirit.item.tier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum CSArmorTiers implements ArmorMaterial {

    CHRISTMAS_HAT("christmas_hat", ArmorMaterials.LEATHER, 100),
    BEANIE_BLACK("beanie_black", ArmorMaterials.LEATHER, 100),
    BEANIE_RED("beanie_red", ArmorMaterials.LEATHER, 100),
    BEANIE_GREEN("beanie_green", ArmorMaterials.LEATHER, 100),
    SWEATER_BLACK("sweater_black", ArmorMaterials.LEATHER, 100),
    SWEATER_RED("sweater_red", ArmorMaterials.LEATHER, 150),
    SWEATER_GREEN("sweater_green", ArmorMaterials.LEATHER, 150),
    WINTER_JEANS("winter_jeans", ArmorMaterials.LEATHER, 150),
    WINTER_BOOTS("winter_boots", ArmorMaterials.LEATHER, 150),
    ICE_SKATES("ice_skates", ArmorMaterials.LEATHER, 200),
    FROST("frost_armor", ArmorMaterials.DIAMOND, 250, 1);

    private final ArmorMaterials base;
    private final String name;
    private final int durabilityAddition;
    private final int protectionAddition;

    CSArmorTiers(String name, ArmorMaterials base, int durabilityAddition, int protectionAddition) {
        this.base = base;
        this.name = name;
        this.durabilityAddition = durabilityAddition;
        this.protectionAddition = protectionAddition;
    }

    CSArmorTiers(String name, ArmorMaterials base, int durabilityAddition) {
        this(name, base, durabilityAddition, 0);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return base.getDurability(slot) + durabilityAddition;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return base.getProtectionAmount(slot) + protectionAddition;
    }


    @Override
    public int getEnchantability() {
        return base.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return base.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return base.getRepairIngredient();
    }

    @Override
    public float getToughness() {
        return base.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return base.getKnockbackResistance();
    }
}
