package io.github.frqnny.cspirit.item;

import io.github.frqnny.cspirit.item.tier.CSArmorTiers;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostArmorItem extends ArmorItem {
    public FrostArmorItem(EquipmentSlot slot, Settings settings) {
        super(CSArmorTiers.FROST, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText("Set Bonus: " + Formatting.BLUE + "Freezes attackers"));
    }
}
