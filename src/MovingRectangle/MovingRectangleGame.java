package MovingRectangle;

import Engine.*;
import Engine.Canvas;

import java.awt.*;

public class MovingRectangleGame extends Game {
    private GamePad controller;
    Player player;
    Npc npc;

    @Override
    public void initialize() {
        controller = new GamePad();
        controller.useWASD();
        addKeyListener(controller);
        player = new Player(controller, getWidth(), getHeight());
        npc = new Npc();
    }

    @Override
    public void update() {
        if (controller.isQuitPressed()) {
            stop();
        }
        player.update();
        npc.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        player.draw(canvas);
        npc.draw(canvas);
    }

    private void drawBackground(Engine.Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }
}
