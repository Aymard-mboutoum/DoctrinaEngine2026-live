package Engine;

public class Collision {
    private final MovableActor actor;

    public Collision(MovableActor actor) {
        this.actor = actor;
    }

    public int getAllowedSpeed(Direction direction) {
        switch(direction) {
            case UP: return getAllowedUpSpeed();
            case DOWN: return getAllowedDownSpeed();
            case LEFT: return getAllowedLeftSpeed();
            case RIGHT: return getAllowedRightSpeed();
        }
        return 0;
    }

    public int getAllowedRightSpeed() {
        int allowedSpeed = actor.getSpeed();

        for (StaticActor other : CollidableRepository.getInstance()) {
            if (actor.hitBoxIntersectsWith(other)) {
                int distance = other.x - (actor.x + actor.width);
                allowedSpeed = Math.min(allowedSpeed, distance);
            }
        }
        return allowedSpeed;
    }

    public int getAllowedDownSpeed() {
        int allowedSpeed = actor.getSpeed();

        for (StaticActor other : CollidableRepository.getInstance()) {
            if (actor.hitBoxIntersectsWith(other)) {
                int distance = other.y - (actor.y + actor.height);
                allowedSpeed = Math.min(allowedSpeed, distance);
            }
        }
        return allowedSpeed;
    }

    public int getAllowedLeftSpeed() {
        int allowedSpeed = actor.getSpeed();

        for (StaticActor other : CollidableRepository.getInstance()) {
            if (actor.hitBoxIntersectsWith(other)) {
                int distance = actor.x - (other.x + other.width);
                allowedSpeed = Math.min(allowedSpeed, distance);
            }
        }
        return allowedSpeed;
    }

    public int getAllowedUpSpeed() {
        int allowedSpeed = actor.getSpeed();

        for (StaticActor other : CollidableRepository.getInstance()) {
            if (actor.hitBoxIntersectsWith(other)) {
                int distance = actor.y - (other.y + other.height);
                allowedSpeed = Math.min(allowedSpeed, distance);
            }
        }
        return allowedSpeed;
    }
}
