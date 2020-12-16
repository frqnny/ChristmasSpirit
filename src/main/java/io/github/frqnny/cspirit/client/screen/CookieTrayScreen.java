package io.github.frqnny.cspirit.client.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class CookieTrayScreen extends CottonInventoryScreen<CookieTrayGUI> {
    public CookieTrayScreen(CookieTrayGUI description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
