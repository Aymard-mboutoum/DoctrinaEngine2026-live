package AmazingFootprint;

import Engine.*;
import Engine.Canvas;

import java.awt.*;
import java.util.ArrayList;

public class AmazingFootprintGame extends Game {
    private GamePad controller;
    Player player;
    ArrayList<Footprint> footprints;

    @Override
    public void initialize() {
        controller = new GamePad();
        addKeyListener(controller);
        player = new Player(controller, getWidth(), getHeight());
        footprints = new ArrayList<>();
    }

    @Override
    public void update() {
        if (controller.isQuitPressed()) {
            stop();
        }
        player.update();

        if (controller.isMoving()) {
            footprints.add(player.layFootprint());
        }
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        for (Footprint footprint : footprints) {
            footprint.draw(canvas);
        }
        player.draw(canvas);
    }

    private void drawBackground(Engine.Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }
}
