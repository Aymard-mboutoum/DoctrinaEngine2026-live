package UltraTank;

import Engine.Canvas;
import Engine.ControllableActor;
import Engine.Direction;

import java.awt.*;

public class Tank extends ControllableActor {
    private int cooldown;
    private final static int COOLDOWN = 50;

    public Tank(UltraTankGamePad controller, int maxWidth, int maxHeight) {
        super(controller, maxWidth, maxHeight);
        setDimensions(30, 40);
        setSpeed(2);
        cooldown = 0;
    }

    @Override
    public void update() {
        moveWithController();
        if (getDirection() == Direction.LEFT || getDirection() == Direction.RIGHT) {
            setDimensions(40, 30);
        } else {
            setDimensions(30, 40);
        }
        if (cooldown > 0) {
            cooldown--;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int cooldownWidth = cooldown * width / COOLDOWN;
        canvas.drawRectangle(x, y-12, cooldownWidth,2, Color.RED);
        canvas.drawRectangle(this, Color.GREEN);
        if (getDirection() == Direction.LEFT) {
            canvas.drawRectangle(getX()-5, getY()+(getHeight()/2)-2, 8, 4, Color.GREEN);
        } else if (getDirection() == Direction.RIGHT) {
            canvas.drawRectangle(getX()+getWidth(), getY()+(getHeight()/2)-2, 8, 4, Color.GREEN);
        } else if (getDirection() == Direction.UP) {
            canvas.drawRectangle(getX()+getWidth()/2-2, getY()-8, 4, 8, Color.GREEN);
        } else if (getDirection() == Direction.DOWN) {
            canvas.drawRectangle(getX()+getWidth()/2-2, getY()+getHeight(), 4, 8, Color.GREEN);
        }
    }

    public Missile fire() {
        if (cooldown == 0) {
            cooldown = COOLDOWN;
            return new Missile(this, 99999, 9999);
        }
        return null;
    }
}
