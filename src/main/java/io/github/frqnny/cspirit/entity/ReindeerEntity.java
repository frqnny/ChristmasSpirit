package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModPackets;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ReindeerEntity extends HorseEntity implements Flutterer {
    public static final TrackedData<Boolean> JUMP_KEY = DataTracker.registerData(ReindeerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public ReindeerEntity(EntityType<? extends HorseEntity> entityType, World world) {
        super(entityType, world);
    }

    public ReindeerEntity(World world, double x, double y, double z) {
        this(ModEntityTypes.REINDEER_ENTITY, world);
        this.setPos(x, y, z);
        this.setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    public static DefaultAttributeContainer.Builder createReindeerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.2D)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH, 1);
    }

    public static void sendPacket(boolean jump) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeBoolean(jump);
        ClientPlayNetworking.send(ModPackets.REINDEER_JUMP_PACKET, buf);
    }

    @Override
    public void tick() {
        if (ChristmasSpirit.getConfig().misc.reindeerFlying) {

            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20, 0, true, false));

            if (world.isClient) {
                if (getPrimaryPassenger() != null) {

                    if (getPrimaryPassenger() instanceof ClientPlayerEntity player) {

                        if (isSaddled()) {

                            if (player.input.jumping && !dataTracker.get(JUMP_KEY)) {
                                sendPacket(true);
                                dataTracker.set(JUMP_KEY, true);
                            } else if (dataTracker.get(JUMP_KEY)) {
                                sendPacket(false);
                                dataTracker.set(JUMP_KEY, false);
                            }
                        }
                    }
                } else if (dataTracker.get(JUMP_KEY)) {
                    sendPacket(false);
                    dataTracker.set(JUMP_KEY, false);
                }
            } else {

                if (getPrimaryPassenger() == null) {

                    if (dataTracker.get(JUMP_KEY)) {
                        dataTracker.set(JUMP_KEY, false);
                    }
                }
            }

            if (dataTracker.get(JUMP_KEY)) {
                addVelocity(0, 0.2F, 0);
            }

        }

        super.tick();
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (ChristmasSpirit.getConfig().misc.reindeerFlying) {

            if (!onGround) {
                setMovementSpeed((float) getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * 5);
            } else {
                setMovementSpeed((float) getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
            }
        }

        super.travel(movementInput);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (ChristmasSpirit.getConfig().misc.reindeerFlying) {

            if (fallDistance > 1.0F) {
                playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4F, 1.0F);
            }

            return false;
        } else return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);
    }


    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        HorseBaseEntity reindeer = ModEntityTypes.REINDEER_ENTITY.create(world);
        setChildAttributes(entity, reindeer);
        return reindeer;
    }

    @Override
    public boolean canJump() {
        if (!ChristmasSpirit.getConfig().misc.reindeerFlying) {
            return super.canJump();
        }

        return false;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(JUMP_KEY, false);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        dataTracker.set(JUMP_KEY, nbt.getBoolean("jump"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("jump", dataTracker.get(JUMP_KEY));
    }

}