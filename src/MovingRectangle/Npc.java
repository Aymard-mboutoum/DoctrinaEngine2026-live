package MovingRectangle;

import Engine.Canvas;
import Engine.MovableActor;

import java.awt.*;

public class Npc extends MovableActor {
    private boolean path1 = true;
    private boolean path2 = false;
    private boolean path3 = false;
    private boolean path4 = false;

    public Npc() {
        moveTo(400, 200);
        setDimensions(10, 10);
        setSpeed(2);
    }

    @Override
    public void update() {
        if (path1) {
            moveDown(500);
            if (y >= 500-height) {
                path1 = false;
                path2 = true;
            }
        } else if (path2) {
            moveLeft(100);
            if (x <= 100+width) {
                path2 = false;
                path3 = true;
            }
        } else if (path3) {
            moveUp(200);
            if (y <= 200+height) {
                path3 = false;
                path4 = true;
            }
        } else if (path4) {
            moveRight(400);
            if (x >= 400-width) {
                path4 = false;
                path1 = true;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }
}
