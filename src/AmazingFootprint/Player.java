package AmazingFootprint;

import Engine.Canvas;
import Engine.ControllableActor;
import Engine.MovableActor;
import Engine.MovementController;

import java.awt.*;

public class Player extends ControllableActor {

    public Player(MovementController controller, int maxWidth, int maxHeight) {
        super(controller, maxWidth, maxHeight);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }
}
