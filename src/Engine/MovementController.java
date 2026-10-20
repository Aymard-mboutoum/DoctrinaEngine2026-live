package Engine;

import java.awt.event.KeyEvent;

public class MovementController extends Controller {
    private int keyUp = KeyEvent.VK_UP;
    private int keyDown = KeyEvent.VK_DOWN;
    private int keyLeft = KeyEvent.VK_LEFT;
    private int keyRight = KeyEvent.VK_RIGHT;

    public MovementController() {
        bindMovement();
    }

    public void useWASD() {
        unbindMovement();
        keyUp = KeyEvent.VK_W;
        keyDown = KeyEvent.VK_S;
        keyLeft = KeyEvent.VK_A;
        keyRight = KeyEvent.VK_D;
        bindMovement();
    }

    private void unbindMovement() {
        unbindKey(keyUp);
        unbindKey(keyDown);
        unbindKey(keyLeft);
        unbindKey(keyRight);
    }

    private void bindMovement() {
        bindKey(keyUp);
        bindKey(keyDown);
        bindKey(keyLeft);
        bindKey(keyRight);
    }

    public boolean isUpPressed() {
        return isKeyPressed(keyUp);
    }

    public boolean isDownPressed() {
        return isKeyPressed(keyDown);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(keyLeft);
    }

    public boolean isRightPressed() {
        return isKeyPressed(keyRight);
    }

    public boolean isMoving() {
        return isUpPressed()
                || isDownPressed()
                || isLeftPressed()
                || isRightPressed();
    }
}
