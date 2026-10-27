package UltraTank;

import Engine.Canvas;
import Engine.StaticActor;

import java.awt.*;

public class Brick extends StaticActor {

    public Brick(int x, int y) {
        moveTo(x, y);
        setDimensions(16,16);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
