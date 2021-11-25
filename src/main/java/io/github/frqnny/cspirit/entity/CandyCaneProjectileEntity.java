package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.init.ModPackets;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;

public class CandyCaneProjectileEntity extends PersistentProjectileEntity {
    private static final TrackedData<Byte> CANDY_TYPE = DataTracker.registerData(CandyCaneProjectileEntity.class, TrackedDataHandlerRegistry.BYTE);
    private byte i;

    public CandyCaneProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public CandyCaneProjectileEntity(World world, PlayerEntity shooter, byte candyCaneType) {
        super(ModEntityTypes.CANDY_CANE_PROJECTILE, shooter, world);
        i = candyCaneType;
        dataTracker.set(CANDY_TYPE, candyCaneType);
        setDamage(2.5F);
        this.age -= (20 * 60);
    }


    @Override
    public void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(CANDY_TYPE, i);
    }

    public ItemStack getCandyCaneStack() {
        return switch (getCandyType()) {
            case 0 -> new ItemStack(ModItems.CANDY_CANE_RED);
            case 1 -> new ItemStack(ModItems.CANDY_CANE_GREEN);
            case 2 -> new ItemStack(ModItems.CANDY_CANE_BLUE);
            default -> throw new RuntimeException("Candy Cane Projectile has bad byte id");
        };

    }

    public byte getCandyType() {
        return dataTracker.get(CANDY_TYPE);
    }

    @Override
    protected ItemStack asItemStack() {
        return getCandyCaneStack();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("candy_type", dataTracker.get(CANDY_TYPE));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        dataTracker.set(CANDY_TYPE, tag.getByte("candy_type"));
    }

    @Override
    public Packet<?> createSpawnPacket() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeDouble(getX());
        buf.writeDouble(getY());
        buf.writeDouble(getZ());
        buf.writeInt(this.getId());
        buf.writeUuid(getUuid());
        buf.writeUuid(this.getOwner().getUuid());
        buf.writeByte(this.getCandyType());
        return ServerPlayNetworking.createS2CPacket(ModPackets.CANDY_CANE_SPAWN_PACKET, buf);
    }
}
