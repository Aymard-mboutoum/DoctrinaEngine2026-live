package Engine;

import java.awt.*;

public abstract class StaticActor {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public abstract void draw(Canvas canvas);

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean intersectsWith(StaticActor actor) {
        return getBounds().intersects(actor.getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
