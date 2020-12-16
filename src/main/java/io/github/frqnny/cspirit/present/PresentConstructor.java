package io.github.frqnny.cspirit.present;

import io.github.frqnny.cspirit.util.ItemHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;

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
        CompoundTag nbt = ItemHelper.getNBT(stack);
        toNBT(nbt);
    }

    public static PresentConstructor fromStack(ItemStack stack) {
        CompoundTag nbt = ItemHelper.getNBT(stack);
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

    public int getActualDay() {
        return this.day + 1;
    }

    public void toStack(ItemStack stack) {
        CompoundTag nbt = ItemHelper.getNBT(stack);
        toNBT(nbt);
    }
    public static PresentConstructor fromBytes(PacketByteBuf buf) {
        PresentConstructor constructor = new PresentConstructor();
        constructor.fromPlayerName = buf.readString();
        constructor.toPlayerName = buf.readString();
        constructor.day = buf.readInt();
        constructor.styleIndex = buf.readInt();
        return constructor;
    }

    public static PresentConstructor fromNBT(CompoundTag nbt) {
        PresentConstructor constructor = new PresentConstructor();
        constructor.fromPlayerName = nbt.getString("Present-FromPlayerName");
        constructor.toPlayerName = nbt.getString("Present-ToPlayerName");
        constructor.day = nbt.getInt("Present-Day");
        constructor.styleIndex = nbt.getInt("Present-Style");
        return constructor;
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

    public void toNBT(CompoundTag nbt) {
        nbt.putString("Present-FromPlayerName", fromPlayerName);
        nbt.putString("Present-ToPlayerName", toPlayerName);
        nbt.putInt("Present-Day", day);
        nbt.putInt("Present-Style", styleIndex);
    }

    public void setStyleIndex(int styleIndex) {
        this.styleIndex = styleIndex;
    }
}
