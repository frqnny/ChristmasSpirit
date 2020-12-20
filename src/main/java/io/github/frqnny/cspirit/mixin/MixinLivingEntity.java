package io.github.frqnny.cspirit.mixin;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.data.NaughtyListFile;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.FrostHelper;
import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
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
public abstract class MixinLivingEntity{

    @Inject(method = "applyDamage", at = @At("TAIL"))
    public void freezeYourEnemies(DamageSource source, float amount, CallbackInfo info) {
        if (source.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) source.getAttacker();
            LivingEntity whateverThisIs = ((LivingEntity) (Object) this);

            if (FrostHelper.doesEntityHaveFrostArmorSet(attacker)) {

                EffectHelper.giveFrozenEffect(whateverThisIs, 2);
            }
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void events(CallbackInfo info) {
        LivingEntity whateverThisIs = ((LivingEntity) (Object) this);
        //skating
        World world = whateverThisIs.getEntityWorld();

        ItemStack bootsStack = whateverThisIs.getEquippedStack(EquipmentSlot.FEET);

        if (!whateverThisIs.isSneaking() && !whateverThisIs.hasVehicle()) {

            if (bootsStack.getItem() == ModItems.ICE_SKATES) {

                BlockPos pos = new BlockPos(whateverThisIs.getPos().x, whateverThisIs.getBoundingBox().minY - 0.5D, whateverThisIs.getPos().z);

                double slipperiness = world.getBlockState(pos).getBlock().getSlipperiness();

                if (slipperiness > 0.7D) {
                    Objects.requireNonNull(whateverThisIs.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)).setBaseValue(whateverThisIs.isSprinting() ? 0.4F : 0.2F);
                    return;
                }
            }
        }

        Objects.requireNonNull(whateverThisIs.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)).setBaseValue(0.1F);

        //disable naughty items
        if (!ChristmasSpirit.getConfig().misc.naughtyItems) {

            if (!whateverThisIs.world.isClient) {

                if (world.getTime() % 20 * 60 == 0) {

                    if (((LivingEntity) (Object) this) instanceof PlayerEntity) {

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

    @Inject(method = "onDeath", at = @At("TAIL"))
    protected void naughtyNaughtyOhOh(DamageSource source, CallbackInfo info) {
        if (!((LivingEntity) (Object) this).world.isClient) {

            if (source.getAttacker() instanceof PlayerEntity) {

                LivingEntity killedEntity = ((LivingEntity) (Object) this);
                PlayerEntity killer = (PlayerEntity) source.getAttacker();

                boolean killedPlayer = killedEntity instanceof PlayerEntity;
                boolean killedWolf = killedEntity instanceof WolfEntity;
                boolean killedFox = killedEntity instanceof FoxEntity;
                boolean killedCat = killedEntity instanceof CatEntity;
                boolean killedHorse = killedEntity instanceof HorseEntity;
                boolean killedVillager = killedEntity instanceof VillagerEntity;
                boolean killedBaby = killedEntity instanceof AnimalEntity && killedEntity.isBaby();
                boolean killedNamedAnimal = killedEntity instanceof AnimalEntity && killedEntity.hasCustomName();

                if (killedPlayer && NaughtyListFile.isOnNaughtyList((PlayerEntity) killedEntity)) {
                    killedPlayer = false;
                }

                if (killedPlayer || killedWolf || killedFox || killedCat || killedHorse || killedVillager || killedBaby || killedNamedAnimal) {
                    EffectHelper.giveNaughtyStackEffect(killer);
                }
            }
        }
    }
}
