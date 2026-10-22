package UltraTank;

import Engine.Canvas;
import Engine.ControllableActor;
import Engine.MovementController;

import java.awt.*;

public class Tank extends ControllableActor {

    public Tank(MovementController controller, int maxWidth, int maxHeight) {
        super(controller, maxWidth, maxHeight);
        setDimensions(30, 30);
        setSpeed(2);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);
    }
}
