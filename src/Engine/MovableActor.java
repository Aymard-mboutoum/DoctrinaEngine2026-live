package Engine;

public abstract class MovableActor extends StaticActor {
    private int speed = 3;
    private final int maxWidth;
    private final int maxHeight;

    private Direction direction = Direction.UP;

    public MovableActor(int maxWidth, int maxHeight) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public abstract void update();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        x = x + direction.calculateVelocityX(speed);
        y = y + direction.calculateVelocityY(speed);
    }

    public void move(Direction direction) {
        this.direction = direction;
        move();
    }

    public void moveUp(int min) {
        if (y >= min) {
            move(Direction.UP);
        }
    }

    public void moveUp() {
        if (y >= 0) {
            move(Direction.UP);
        }
    }

    public void moveLeft(int min) {
        if (x >= min) {
            move(Direction.LEFT);
        }
    }

    public void moveLeft() {
        if (x >= 0) {
            move(Direction.LEFT);
        }
    }

    public void moveDown(int max) {
        if (y <= max - height) {
            move(Direction.DOWN);
        }
    }

    public void moveDown() {
        if (y <= maxHeight - height) {
            move(Direction.DOWN);
        }
    }

    public void moveRight(int max) {
        if (x <= max-width) {
            move(Direction.RIGHT);
        }
    }

    public void moveRight() {
        if (x <= maxHeight-width) {
            move(Direction.RIGHT);
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
