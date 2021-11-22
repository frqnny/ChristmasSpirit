package io.github.frqnny.cspirit.client.screen;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.frqnny.cspirit.ChristmasSpirit;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class CookieTrayGUI extends SyncedGuiDescription {
    public CookieTrayGUI(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ChristmasSpirit.COOKIE_TRAY_GUI, syncId, playerInventory, getBlockInventory(context), null);
        WGridPanel root = new WGridPanel(1);
        setRootPanel(root);
        root.setSize(176, 132);

        WItemSlot slots = WItemSlot.of(blockInventory, 0, 3, 1);
        root.add(slots, 62, 18);

        root.add(this.createPlayerInventoryPanel(), 8, 102);
        root.validate(this);

    }
}
