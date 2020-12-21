package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModItems;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class SleighEntity extends BoatEntity {
    private static final int MAX_PASSENGERS = 4;

    public SleighEntity(EntityType<? extends SleighEntity> entityType, World world) {
        super(entityType, world);
        this.stepHeight = 1.0F;
    }

    public SleighEntity(World world, double x, double y, double z) {
        this(ModEntityTypes.SLEIGH_ENTITY, world);
        this.updatePosition(x, y, z);
        this.setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    public void tick() {
        if (this.isLogicalSideForUpdatingMovement()) {
            this.move(MovementType.SELF, this.getVelocity().multiply(4, 1, 4));
        } else {
            this.setVelocity(Vec3d.ZERO);
        }

        super.tick();

        List<Entity> list = this.world.getOtherEntities(this, this.getBoundingBox().expand(0.2F, -0.01F, 0.2F), EntityPredicates.canBePushedBy(this));

        if (!list.isEmpty()) {

            boolean flag = !this.world.isClient && !(this.getPrimaryPassenger() instanceof PlayerEntity);

            for (Entity entity : list) {

                if (!entity.hasPassenger(this)) {

                    if (flag && this.getPassengerList().size() < MAX_PASSENGERS && !entity.hasVehicle() && entity.getWidth() < this.getWidth() && entity instanceof LivingEntity && !(entity instanceof WaterCreatureEntity) && !(entity instanceof PlayerEntity)) {
                        entity.startRiding(this);
                    } else this.pushAwayFrom(entity);
                }
            }
        }
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        if (this.hasPassenger(passenger)) {

            double passengerOffsetX = 0.0F;
            double passengerOffsetZ = 0.0F;
            float f1 = (float) ((this.removed ? (double) 0.01F : this.getMountedHeightOffset()) + passenger.getHeightOffset());

            if (getPassengerList().indexOf(passenger) == 0) passengerOffsetX = -0.39D;
            if (getPassengerList().size() > 1 && getPassengerList().indexOf(passenger) == 1) passengerOffsetX = 0.39D;

            if (getPassengerList().size() > 2 && getPassengerList().indexOf(passenger) == 2) {
                passengerOffsetX = -0.39D;
                f1 += 0.4D;
                passengerOffsetZ = -1.0D;
            }
            if (getPassengerList().size() > 3 && getPassengerList().indexOf(passenger) == 3) {
                passengerOffsetX = 0.39D;
                f1 += 0.4D;
                passengerOffsetZ = -1.0D;
            }

            Vec3d vector3d = (new Vec3d(-0.5D + passengerOffsetZ, 0D, passengerOffsetX)).rotateY(-this.yaw * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            passenger.setPos(this.getX() + vector3d.x, this.getY() + (double) f1, this.getZ() + vector3d.z);

            passenger.yaw += (yaw - prevYaw);
            passenger.setHeadYaw(passenger.getHeadYaw() + (yaw - prevYaw));

            this.copyEntityData(passenger);
        }
    }

    @Override
    public double getMountedHeightOffset() {
        return 0.85D;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
        if (!this.hasVehicle()) {

            if (onGround) {
                this.fallDistance = 0.0F;
            } else if (!this.world.getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && getY() < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - getY());
            }
        }
    }


    @Override
    public Item asItem() {
        return ModItems.SLEIGH;
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < MAX_PASSENGERS && !this.isSubmergedIn(FluidTags.WATER);
    }

    @Override
    public float method_7548() {
        return 0.8F;
    }

    @Override
    public boolean isSubmergedInWater() {
        return false;
    }

    @Override
    public Packet<?> createSpawnPacket() {
        final PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());

        buf.writeVarInt(this.getEntityId());
        buf.writeUuid(this.uuid);
        buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(this.getType()));
        buf.writeDouble(this.getX());
        buf.writeDouble(this.getY());
        buf.writeDouble(this.getZ());
        buf.writeByte(MathHelper.floor(this.pitch * 256.0F / 360.0F));
        buf.writeByte(MathHelper.floor(this.yaw * 256.0F / 360.0F));

        return ServerPlayNetworking.createS2CPacket(ChristmasSpirit.id("spawn_boat"), buf);
    }
}
