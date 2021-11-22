package io.github.frqnny.cspirit.present;

import io.github.frqnny.cspirit.blockentity.UnwrappedPresentBlockEntity;
import io.github.frqnny.cspirit.blockentity.WrappedPresentBlockEntity;
import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PresentConstructor {

    public String fromPlayerName;
    public String toPlayerName;
    public int day;
    public int styleIndex;

    public PresentConstructor() {
        fromPlayerName = "";
        toPlayerName = "";
        day = 0;
        styleIndex = 0;
    }

    /*
    public String getFromPlayerName() {
        return this.fromPlayerName;
    }

    public String getToPlayerName() {
        return this.toPlayerName;
    }

    public int getDay() {
        return this.day;
    }

    public int getActualDay() {
        return this.day + 1;
    }

    public int getStyleIndex() {
        return this.styleIndex;
    }



    public void setFromPlayerName(String fromPlayerName) {
        this.fromPlayerName = fromPlayerName;
    }

    public void setToPlayerName(String toPlayerName) {
        this.toPlayerName = toPlayerName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStyleIndex(int styleIndex) {
        this.styleIndex = styleIndex;
    }

    public void toStack(ItemStack stack) {
        NbtCompound nbt = ItemHelper.getNBT(stack);
        toNBT(nbt);
    }

    public static PresentConstructor fromStack(ItemStack stack) {
        NbtCompound nbt = ItemHelper.getNBT(stack);
        return fromNBT(nbt);
    }

    public void toBlock(Location location) {

        ItemStack giftStack = ItemStack.EMPTY;

        if (location.getTileEntity() != null && location.getTileEntity() instanceof TileEntityPresentUnwrapped) {
            giftStack = ((TileEntityPresentUnwrapped)location.getTileEntity()).getInventory().getStackInSlot(0);
        }

        location.setBlock(getStyle().getBlock());

        if (location.getTileEntity() != null && location.getTileEntity() instanceof TileEntityPresentWrapped) {
            TileEntityPresentWrapped tileEntity = (TileEntityPresentWrapped) location.getTileEntity();
            tileEntity.setConstructor(this);
            tileEntity.getInventory().setStackInSlot(0, giftStack);
        }
    }




     */

    public static PresentConstructor fromBytes(PacketByteBuf buf) {
        PresentConstructor constructor = new PresentConstructor();
        constructor.fromPlayerName = buf.readString();
        constructor.toPlayerName = buf.readString();
        constructor.day = buf.readInt();
        constructor.styleIndex = buf.readInt();
        return constructor;
    }

    public static PresentConstructor fromNBT(NbtCompound nbt) {
        PresentConstructor constructor = new PresentConstructor();
        constructor.fromPlayerName = nbt.getString("Present-FromPlayerName");
        constructor.toPlayerName = nbt.getString("Present-ToPlayerName");
        constructor.day = nbt.getInt("Present-Day");
        constructor.styleIndex = nbt.getInt("Present-Style");
        return constructor;
    }

    public static PresentConstructor fromStack(ItemStack stack) {
        NbtCompound nbt = ItemHelper.getNBT(stack);
        return fromNBT(nbt);
    }

    public int getActualDay() {
        return this.day + 1;
    }

    public void toStack(ItemStack stack) {
        NbtCompound nbt = ItemHelper.getNBT(stack);
        toNBT(nbt);
    }

    public PresentStyle getStyle() {
        return PresentStyle.fromIndex(styleIndex);
    }

    public void toBytes(PacketByteBuf buf) {
        buf.writeString(fromPlayerName);
        buf.writeString(toPlayerName);
        buf.writeInt(day);
        buf.writeInt(styleIndex);
    }

    public void toNBT(NbtCompound nbt) {
        nbt.putString("Present-FromPlayerName", fromPlayerName);
        nbt.putString("Present-ToPlayerName", toPlayerName);
        nbt.putInt("Present-Day", day);
        nbt.putInt("Present-Style", styleIndex);
    }

    public void setStyleIndex(int styleIndex) {
        this.styleIndex = styleIndex;
    }

    public void toBlock(World world, BlockPos pos) {

        ItemStack giftStack = ItemStack.EMPTY;
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof UnwrappedPresentBlockEntity) {
            giftStack = ((Inventory) be).getStack(0);
        }

        world.setBlockState(pos, getStyle().getBlock().getDefaultState());
        BlockEntity newBe = world.getBlockEntity(pos);

        if (newBe instanceof WrappedPresentBlockEntity) {
            WrappedPresentBlockEntity tileEntity = (WrappedPresentBlockEntity) newBe;
            tileEntity.setPresentConstructor(this);
            ((Inventory) tileEntity).setStack(0, giftStack);
        }
    }
}
