package Engine;

public class Collision {
    private final MovableActor actor;

    public Collision(MovableActor actor) {
        this.actor = actor;
    }

    public int getAllowedSpeed(Direction direction) {
        return switch (direction) {
            case UP -> getAllowedUpSpeed();
            case DOWN -> getAllowedDownSpeed();
            case LEFT -> getAllowedLeftSpeed();
            case RIGHT -> getAllowedRightSpeed();
        };
    }

    public int getAllowedRightSpeed() {
        return distance(other ->
                other.x - (actor.x + actor.width));
    }

    public int getAllowedDownSpeed() {
        return distance(other ->
                other.y - (actor.y + actor.height));
    }

    public int getAllowedLeftSpeed() {
        return distance(other ->
                actor.x - (other.x + other.width));
    }

    public int getAllowedUpSpeed() {
        return distance(other ->
                actor.y - (other.y + other.height));
    }

    private int distance(DistanceCalculator distanceCalculator) {
        int allowedSpeed = actor.getSpeed();

        for (StaticActor other : CollidableRepository.getInstance()) {
            if (actor.hitBoxIntersectsWith(other)) {
                int distance = distanceCalculator.calculatesWith(other);
                allowedSpeed = Math.min(allowedSpeed, distance);
            }
        }
        return allowedSpeed;
    }

    private interface DistanceCalculator {
        int calculatesWith(StaticActor other);
    }
}
