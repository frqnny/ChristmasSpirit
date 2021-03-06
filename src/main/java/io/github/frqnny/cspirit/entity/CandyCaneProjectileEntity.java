package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.util.PacketHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
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
        switch (getCandyType()) {
            case 0:
                return new ItemStack(ModItems.CANDY_CANE_RED);
            case 1:
                return new ItemStack(ModItems.CANDY_CANE_GREEN);
            case 2:
                return new ItemStack(ModItems.CANDY_CANE_BLUE);
            default:
                throw new RuntimeException("Candy Cane Projectile has bad byte id");
        }

    }

    public byte getCandyType() {
        return dataTracker.get(CANDY_TYPE);
    }

    @Override
    protected ItemStack asItemStack() {
        return getCandyCaneStack();
    }

    @Override
    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putByte("candy_type", dataTracker.get(CANDY_TYPE));
    }

    @Override
    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        dataTracker.set(CANDY_TYPE, tag.getByte("candy_type"));
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return PacketHelper.newSpawnPacket(this);
    }
}
