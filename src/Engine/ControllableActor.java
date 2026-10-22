package Engine;

public abstract class ControllableActor extends MovableActor {
    private MovementController controller;

    public ControllableActor(MovementController controller, int maxWidth, int maxHeight) {
        super(maxWidth, maxHeight);
        this.controller = controller;
        moveTo(200, 200);
        setDimensions(20, 60);
        setSpeed(3);
    }

    public void moveWithController() {
        if (controller.isUpPressed()) {
            moveUp();
        } else if (controller.isDownPressed()) {
            moveDown();
        } else if (controller.isLeftPressed()) {
            moveLeft();
        } else if (controller.isRightPressed()) {
            moveRight();
        }
    }
}
