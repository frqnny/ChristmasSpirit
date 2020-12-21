package io.github.frqnny.cspirit.entity;

import io.github.frqnny.cspirit.data.CSDataSerializers;
import io.github.frqnny.cspirit.init.ModEntityTypes;
import io.github.frqnny.cspirit.init.ModItems;
import io.github.frqnny.cspirit.init.ModPackets;
import io.github.frqnny.cspirit.util.EffectHelper;
import io.github.frqnny.cspirit.util.ItemHelper;
import io.github.frqnny.cspirit.util.PacketHelper;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ChristmasTreeEntity extends Entity {
    private static final TrackedData<DefaultedList<ItemStack>> INVENTORY = DataTracker.registerData(ChristmasTreeEntity.class, CSDataSerializers.ITEMSTACK_ARRAY_4);
    private static final TrackedData<Boolean> WHITE = DataTracker.registerData(ChristmasTreeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean white_what;

    public ChristmasTreeEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public ChristmasTreeEntity(World world, Vec3d position, float yaw, boolean isWhite) {
        this(ModEntityTypes.CHRISTMAS_TREE, world);
        refreshPositionAndAngles(position.x, position.y, position.z, yaw, 0);
        this.white_what = isWhite;
    }

    public boolean isWhite() {
        return dataTracker.get(WHITE);
    }

    public ItemStack getItemStackFromSlot(EquipmentSlot slotIn) {

        if (slotIn.getType() == EquipmentSlot.Type.ARMOR) {
            return dataTracker.get(INVENTORY).get(slotIn.getEntitySlotId());
        }

        return ItemStack.EMPTY;
    }

    public ItemStack getItemStackFromID(int id) {
        return getItemStackFromSlot(getSlotTypeFromID(id));
    }

    public EquipmentSlot getSlotTypeFromID(int id) {

        switch (id) {
            case 0:
                return EquipmentSlot.FEET;
            case 1:
                return EquipmentSlot.LEGS;
            case 2:
                return EquipmentSlot.CHEST;
        }

        return EquipmentSlot.HEAD;
    }

    public void setItemStackToSlot(EquipmentSlot slotIn, ItemStack stack) {

        if (slotIn.getType() == EquipmentSlot.Type.ARMOR) {

            DefaultedList<ItemStack> newInv = DefaultedList.of();
            newInv.addAll(dataTracker.get(INVENTORY));
            newInv.set(slotIn.getEntitySlotId(), stack);
            dataTracker.set(INVENTORY, newInv);
        }
    }

    public boolean hasStar() {
        return !getItemStackFromSlot(EquipmentSlot.HEAD).isEmpty();
    }

    private boolean addDecoration(ItemStack stack) {

        ItemStack copiedStack = stack.copy();
        copiedStack.setCount(1);

        boolean added = false;

        if (!hasStar()) {
            setItemStackToSlot(EquipmentSlot.HEAD, copiedStack);
            return true;
        }

        for (int i = 0; i < 4; i++) {

            if (getItemStackFromID(i).isEmpty()) {
                setItemStackToSlot(getSlotTypeFromID(i), copiedStack);
                added = true;
                break;
            }
        }

        return added;
    }

    private ItemStack removeDecoration() {

        for (int i = 2; i >= 0; i--) {

            ItemStack removedStack = getItemStackFromID(i);

            if (!removedStack.isEmpty()) {
                setItemStackToSlot(getSlotTypeFromID(i), ItemStack.EMPTY);
                return removedStack;
            }
        }

        if (hasStar()) {
            ItemStack removedStack = getItemStackFromSlot(EquipmentSlot.HEAD);
            setItemStackToSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
            return removedStack;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();

        int radius = 10;

        int stack = 1;

        if (hasStar() && !getItemStackFromSlot(EquipmentSlot.CHEST).isEmpty() && !getItemStackFromSlot(EquipmentSlot.LEGS).isEmpty() && !getItemStackFromSlot(EquipmentSlot.FEET).isEmpty()) {
            stack = 2;
        }

        List<PlayerEntity> closePlayers = world.getEntitiesByClass(PlayerEntity.class, new Box(getPos().getX() - radius, getPos().getY() - radius, getPos().getZ() - radius, getPos().getX() + radius, getPos().getY() + radius, getPos().getZ() + radius), (player) -> true);

        for (PlayerEntity player : closePlayers) {
            EffectHelper.giveHolidaySpiritStackEffect(player, stack, 30);
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!stack.isEmpty()) {

            boolean added = addDecoration(stack);

            if (added) {
                stack.decrement(1);
            }
        } else {

            ItemStack removedStack = removeDecoration();

            if (!removedStack.isEmpty()) {
                ItemHelper.spawnStackAtEntity(world, player, removedStack);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {

        if (source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();
            if (player.getMainHandStack().getItem() instanceof AxeItem || player.isCreative()) {

                Item item = ModItems.CHRISTMAS_TREE;

                if (isWhite()) {
                    item = ModItems.CHRISTMAS_TREE_WHITE;
                }

                ItemHelper.spawnStack(world, getX(), getY(), getZ(), new ItemStack(item));

                ItemHelper.spawnStack(world, getX(), getY(), getZ(), getItemStackFromSlot(EquipmentSlot.HEAD));
                ItemHelper.spawnStack(world, getX(), getY(), getZ(), getItemStackFromSlot(EquipmentSlot.CHEST));
                ItemHelper.spawnStack(world, getX(), getY(), getZ(), getItemStackFromSlot(EquipmentSlot.LEGS));
                ItemHelper.spawnStack(world, getX(), getY(), getZ(), getItemStackFromSlot(EquipmentSlot.FEET));

                if (!world.isClient) {
                    playSound(SoundEvents.BLOCK_WOOD_BREAK, 1, 1);
                    playSound(SoundEvents.BLOCK_GRASS_BREAK, 1, 1);
                }

                remove();
            }

            return true;
        }

        return false;
    }

    @Override
    protected void initDataTracker() {
        dataTracker.startTracking(INVENTORY, DefaultedList.ofSize(4, ItemStack.EMPTY));

        dataTracker.startTracking(WHITE, white_what);
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {
        DefaultedList<ItemStack> newInv = DefaultedList.ofSize(4, ItemStack.EMPTY);

        newInv.set(0, ItemStack.fromTag(tag.getCompound("Head")));
        newInv.set(1, ItemStack.fromTag(tag.getCompound("Chest")));
        newInv.set(2, ItemStack.fromTag(tag.getCompound("Legs")));
        newInv.set(3, ItemStack.fromTag(tag.getCompound("Feet")));

        dataTracker.set(INVENTORY, newInv);

        dataTracker.set(WHITE, tag.getBoolean("White"));
    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {
        CompoundTag headTag = new CompoundTag();
        CompoundTag chestTag = new CompoundTag();
        CompoundTag legsTag = new CompoundTag();
        CompoundTag feetTag = new CompoundTag();
        dataTracker.get(INVENTORY).get(0).toTag(headTag);
        dataTracker.get(INVENTORY).get(1).toTag(chestTag);
        dataTracker.get(INVENTORY).get(2).toTag(legsTag);
        dataTracker.get(INVENTORY).get(3).toTag(feetTag);
        tag.put("Head", headTag);
        tag.put("Chest", chestTag);
        tag.put("Legs", legsTag);
        tag.put("Feet", feetTag);

        tag.putBoolean("White", dataTracker.get(WHITE));
    }

    @Override
    public Packet<?> createSpawnPacket() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeDouble(getX());
        buf.writeDouble(getY());
        buf.writeDouble(getZ());
        buf.writeInt(getEntityId());
        buf.writeUuid(getUuid());
        buf.writeBoolean(this.dataTracker.get(WHITE));
        return ServerPlayNetworking.createS2CPacket(ModPackets.SPAWN_PACKET_TREE, buf);
    }

    @Override
    public boolean collidesWith(Entity other) {
        return true;
    }

    @Override
    public boolean collides() {
        return true;
    }

    @Override
    protected boolean canClimb() {
        return false;
    }

    @Override
    public float getTargetingMargin() {
        return 0.0F;
    }


}
