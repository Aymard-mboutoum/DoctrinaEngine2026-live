package UltraTank;

import Engine.GamePad;

import java.awt.event.KeyEvent;

public class UltraTankGamePad extends GamePad {
    private int fireKey = KeyEvent.VK_SPACE;

    public UltraTankGamePad() {
        bindKey(fireKey);
    }

    public boolean isFirePressed() {
        return isKeyPressed(fireKey);
    }
}
