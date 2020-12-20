package io.github.frqnny.cspirit.data;

import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;

public class CSDataSerializers {

    public static final TrackedDataHandler<DefaultedList<ItemStack>> ITEMSTACK_ARRAY_4 = new TrackedDataHandler<DefaultedList<ItemStack>>() {

        @Override
        public void write(PacketByteBuf buf, DefaultedList<ItemStack> value) {

            for (ItemStack stack : value) {
                buf.writeItemStack(stack);
            }
        }

        @Override
        public DefaultedList<ItemStack> read(PacketByteBuf buf) {

            DefaultedList<ItemStack> list = DefaultedList.ofSize(4, ItemStack.EMPTY);

            for (int i = 0; i < 4; i++) {
                list.set(i, buf.readItemStack());
            }

            return list;
        }

        @Override
        public DefaultedList<ItemStack> copy(DefaultedList<ItemStack> value) {

            DefaultedList<ItemStack> list = DefaultedList.ofSize(4, ItemStack.EMPTY);

            for (int i = 0; i < 4; i++) {
                list.set(i, value.get(i).copy());
            }

            return list;
        }
    };
}
