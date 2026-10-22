package UltraTank;

import Engine.Canvas;
import Engine.Direction;
import Engine.MovableActor;

import java.awt.*;

public class Missile extends MovableActor {
    private Tank tank;

    public Missile(Tank tank, int maxWidth, int maxHeight) {
        super(maxWidth, maxHeight);
        this.tank = tank;
        setSpeed(5);
        setDirection(tank.getDirection());
        initialize();
    }

    private void initialize() {
        if (tank.getDirection() == Direction.UP) {
            moveTo(tank.getX()+tank.getWidth()/2, tank.getY()-4);
            setDimensions(2,4);
        } else if (tank.getDirection() == Direction.DOWN) {
            moveTo(tank.getX()+tank.getWidth()/2, tank.getY()+tank.getHeight()+4);
            setDimensions(2,4);
        } else if (tank.getDirection() == Direction.LEFT) {
            moveTo(tank.getX()-4, tank.getY()+tank.getHeight()/2);
            setDimensions(4,2);
        } else if (tank.getDirection() == Direction.RIGHT) {
            moveTo(tank.getX()+tank.getWidth()+4, tank.getY()+tank.getHeight()/2);
            setDimensions(4,2);
        }
    }

    @Override
    public void update() {
        move(getDirection());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }
}
