package io.github.frqnny.cspirit.item.tier;

import io.github.frqnny.cspirit.util.EffectHelper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class FrostmourneItem extends SwordItem {
    public FrostmourneItem(Settings settings) {
        super(ToolMaterials.DIAMOND, 3, -2.4F, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText(Formatting.BLUE + "Randomly freezes enemies"));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();

        stack.damage(1, attacker, (entity) -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

        if (random.nextInt(3) == 0) {
            EffectHelper.giveFrozenEffect(target, 2);
        }

        return true;
    }
}
