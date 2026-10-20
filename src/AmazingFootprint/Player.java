package AmazingFootprint;

import Engine.Canvas;
import Engine.MovableActor;
import Engine.MovementController;

import java.awt.*;

public class Player extends MovableActor {
    private MovementController controller;
    private final int maxWidth;
    private final int maxHeight;

    public Player(MovementController controller, int width, int height) {
        this.controller = controller;
        moveTo(200, 200);
        setDimensions(20, 60);
        setSpeed(3);
        maxHeight = height;
        maxWidth = width;
    }

    @Override
    public void update() {
        if (controller.isUpPressed()) {
            moveUp(0);
        } else if (controller.isDownPressed()) {
            moveDown(maxHeight);
        } else if (controller.isLeftPressed()) {
            moveLeft(0);
        } else if (controller.isRightPressed()) {
            moveRight(maxWidth);
        }
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
