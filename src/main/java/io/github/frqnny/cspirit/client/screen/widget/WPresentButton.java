package io.github.frqnny.cspirit.client.screen.widget;

import io.github.cottonmc.cotton.gui.client.LibGui;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.frqnny.cspirit.present.PresentStyle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class WPresentButton extends WButton {
    private static final Identifier DARK_WIDGETS_LOCATION = new Identifier("libgui", "textures/widget/dark_widgets.png");
    public Function<Integer, String> dynamicText;
    public int max;
    public int id;
    public boolean isDay;

    public WPresentButton(Function<Integer, String> dynamicText, int max, int id, boolean isDay) {
        this.dynamicText = dynamicText;
        this.max = max;
        this.id = id;
        this.isDay = isDay;
    }

    @Environment(EnvType.CLIENT)
    static Identifier getTexture() {
        return LibGui.isDarkMode() ? DARK_WIDGETS_LOCATION : ClickableWidget.WIDGETS_TEXTURE;
    }

    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        boolean hovered = mouseX >= 0 && mouseY >= 0 && mouseX < this.getWidth() && mouseY < this.getHeight();
        int state = 1;
        if (!this.isEnabled()) {
            state = 0;
        } else if (hovered || this.isFocused()) {
            state = 2;
        }

        float px = 0.00390625F;
        float buttonLeft = 0.0F * px;
        float buttonTop = (float) (46 + state * 20) * px;
        int halfWidth = this.getWidth() / 2;
        if (halfWidth > 198) {
            halfWidth = 198;
        }

        float buttonWidth = (float) halfWidth * px;
        float buttonHeight = 20.0F * px;
        float buttonEndLeft = (float) (200 - this.getWidth() / 2) * px;
        Identifier texture = getTexture();
        ScreenDrawing.texturedRect(matrices, x, y, this.getWidth() / 2, 20, texture, buttonLeft, buttonTop, buttonLeft + buttonWidth, buttonTop + buttonHeight, -1);
        ScreenDrawing.texturedRect(matrices, x + this.getWidth() / 2, y, this.getWidth() / 2, 20, texture, buttonEndLeft, buttonTop, 200.0F * px, buttonTop + buttonHeight, -1);
        if (this.getIcon() != null) {
            this.getIcon().paint(matrices, x + 1, y + 1, 16);
        }

        if (this.dynamicText != null) {
            int color = 14737632;
            if (!this.isEnabled()) {
                color = 10526880;
            }

            ScreenDrawing.drawString(matrices, this.dynamicText.apply(id), this.alignment, x, y + 6, this.width, color);
        }

    }

    @Environment(EnvType.CLIENT)
    public InputResult onClick(int x, int y, int button) {
        super.onClick(x, y, button);
        if (this.isEnabled() && this.isWithinBounds(x, y)) {
            id++;
            if (isDay) {
                if (id > 32) {
                    id = 0;
                }
            } else {
                if (id > PresentStyle.values().length - 1) {
                    id = 0;
                }
            }

        }

        return InputResult.PROCESSED;
    }
}
