package AmazingFootprint;

import Engine.*;
import Engine.Canvas;

import java.awt.*;

public class AmazingFootprintGame extends Game {
    private GamePad controller;
    Player player;

    @Override
    public void initialize() {
        controller = new GamePad();
        addKeyListener(controller);
        player = new Player(controller, getWidth(), getHeight());
    }

    @Override
    public void update() {
        if (controller.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        player.draw(canvas);
    }

    private void drawBackground(Engine.Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }
}
