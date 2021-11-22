package io.github.frqnny.cspirit.client.screen;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.frqnny.cspirit.ChristmasSpirit;
import io.github.frqnny.cspirit.client.screen.widget.WPresentButton;
import io.github.frqnny.cspirit.init.ModPackets;
import io.github.frqnny.cspirit.init.ModSounds;
import io.github.frqnny.cspirit.present.PresentConstructor;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

import java.util.function.Function;

public class UnwrappedPresentGUI extends SyncedGuiDescription {

    private final Inventory inv;
    private final PresentConstructor constructor;
    private final WTextField textField;
    private final PlayerEntity player;
    private BlockPos pos;

    public UnwrappedPresentGUI(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ChristmasSpirit.UNWRAPPED_PRESENT_GUI, syncId, playerInventory, getBlockInventory(context), null);
        constructor = new PresentConstructor();
        inv = getBlockInventory(context);
        player = playerInventory.player;
        context.run((world, pos) -> {
            this.pos = pos;
        });

        WGridPanel root = new WGridPanel(1);
        setRootPanel(root);
        root.setSize(176, 194);

        WItemSlot slot = WItemSlot.of(blockInventory, 0);
        root.add(slot, 80, 18);

        textField = new WTextField();
        root.add(textField, 41, 39, 94, 12);

        WPresentButton daysButton = new WPresentButton(cycleThroughDays(), 32, constructor.day, true);
        root.add(daysButton, 26, 63, 50, 16);

        WPresentButton stylesButton = new WPresentButton(cycleThroughStyles(), 3, constructor.styleIndex, false);
        root.add(stylesButton, 100, 63, 50, 16);

        WButton wrapPresentButton = new WButton();
        wrapPresentButton.setOnClick(this::wrapPresent);
        wrapPresentButton.setLabel(new LiteralText("Wrap Present"));
        root.add(wrapPresentButton, 51, 84, 74, 16);

        root.add(this.createPlayerInventoryPanel(), 8, 104);
        root.validate(this);

    }


    public Function<Integer, String> cycleThroughDays() {
        return (id) -> {
            constructor.day = id;

            return "Days: " + id;
        };
    }

    public Function<Integer, String> cycleThroughStyles() {
        return (id) -> {
            constructor.setStyleIndex(id);

            return constructor.getStyle().getName();
        };
    }

    private boolean isPresentReady() {

        boolean notEmpty = !inv.getStack(0).isEmpty();
        boolean hasToPlayerName = !textField.getText().isEmpty();

        if (!notEmpty) {
            playerInventory.player.sendMessage(new LiteralText("The present is empty!").formatted(Formatting.RED), false);
        }
        if (!hasToPlayerName) {
            playerInventory.player.sendMessage(new LiteralText("The present needs a player to go to!").formatted(Formatting.RED), false);
        }


        return notEmpty && hasToPlayerName;
    }

    private void wrapPresent() {

        if (isPresentReady()) {


            constructor.fromPlayerName = player.getDisplayName().getString();
            constructor.toPlayerName = textField.getText();


            PacketByteBuf buf = PacketByteBufs.create();
            CompoundTag tag = new CompoundTag();
            constructor.toNBT(tag);
            buf.writeCompoundTag(tag);
            buf.writeBlockPos(pos);
            ClientPlayNetworking.send(ModPackets.WRAP_PACKET_ID, buf);

            player.playSound(ModSounds.PRESENT_WRAP, 1, 1);

            this.close(player);
            if (player instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity) player).closeHandledScreen();
            } else if (player instanceof ClientPlayerEntity) {
                ((ClientPlayerEntity) player).closeHandledScreen();
            }
        }
    }
}
