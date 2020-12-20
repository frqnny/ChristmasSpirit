package io.github.frqnny.cspirit.mixin;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends LivingEntity{
    protected MixinLivingEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "applyDamage", at = @At("TAIL"))
    public void freezeYourEnemies(DamageSource source, float amount, CallbackInfo info) {
        if (source.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) source.getAttacker();

            boolean hasHelmet = attacker.getEquippedStack(EquipmentSlot.HEAD).getItem().equals(ModItems.FROST_HELMET);
            boolean hasChestplate = attacker.getEquippedStack(EquipmentSlot.CHEST).getItem().equals(ModItems.FROST_CHESTPLATE);
            boolean hasLeggings = attacker.getEquippedStack(EquipmentSlot.LEGS).getItem().equals(ModItems.FROST_LEGGINGS);
            boolean hasBoots = attacker.getEquippedStack(EquipmentSlot.FEET).getItem().equals(ModItems.FROST_BOOTS);

            if (hasHelmet && hasChestplate && hasLeggings && hasBoots) {

                EffectHelper.giveFrozenEffect(this, 2);
            }
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void events(CallbackInfo info) {

        //skating
        World world = this.getEntityWorld();

        ItemStack bootsStack = this.getEquippedStack(EquipmentSlot.FEET);

        if (!this.isSneaking() && !this.hasVehicle()) {

            if (bootsStack.getItem() == ModItems.ICE_SKATES) {

                BlockPos pos = new BlockPos(this.getPos().x, this.getBoundingBox().minY - 0.5D, this.getPos().z);

                double slipperiness = world.getBlockState(pos).getBlock().getSlipperiness();

                if (slipperiness > 0.7D) {
                    Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)).setBaseValue(this.isSprinting() ? 0.4F : 0.2F);
                    return;
                }
            }
        }

        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1F);

        //disable naughty items
        if (!ChristmasSpirit.getConfig().misc.naughtyItems) {

            if (!this.world.isClient) {

                if (world.getTime() % 20 * 60 == 0) {

                    if (((Object) this) instanceof PlayerEntity) {

                        PlayerEntity player = ((PlayerEntity)((Object) this));

                        for (int i = 0; i < player.inventory.size(); i++) {

                            ItemStack stackInSlot = player.inventory.getStack(i);

                            if (ChristmasSpirit.NAUGHTY.contains(stackInSlot.getItem())) {

                                player.inventory.setStack(i, ItemStack.EMPTY);
                            }
                        }
                    }
                }
            }
        }
    }
}
