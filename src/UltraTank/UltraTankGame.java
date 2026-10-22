package UltraTank;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

import java.awt.*;

public class UltraTankGame extends Game {
    Tank tank;
    GamePad gamePad = new GamePad();

    @Override
    public void initialize() {
        tank = new Tank(gamePad, getWidth(), getHeight());
        addKeyListener(gamePad);
    }

    @Override
    public void update() {
        tank.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        tank.draw(canvas);
    }
}
