package AmazingFootprint;

import Engine.Canvas;
import Engine.StaticActor;

import java.awt.*;
import java.util.Random;

public class Footprint extends StaticActor {
    private final int dimension = 5;

    public Footprint(int x, int y) {
        moveTo(x, y);
        setDimensions(dimension, dimension);
    }

    private int getRandomValue() {
        return new Random().nextInt(256);
    }

    @Override
    public void draw(Canvas canvas) {
        Color color = new Color(getRandomValue(),
                getRandomValue(), getRandomValue());
        canvas.drawRectangle(x, y, width, height, color);
    }

}
