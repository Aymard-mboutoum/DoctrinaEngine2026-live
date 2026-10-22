package AmazingFootprint;

import Engine.*;
import Engine.Canvas;

import java.awt.*;
import java.util.ArrayList;

public class AmazingFootprintGame extends Game {
    private GamePad controllerOne;
    private GamePad controllerTwo;
    Player playerOne;
    Player playerTwo;
    ArrayList<Footprint> footprints;

    @Override
    public void initialize() {
        controllerOne = new GamePad();
        controllerTwo = new GamePad();
        controllerTwo.useWASD();
        addKeyListener(controllerOne);
        addKeyListener(controllerTwo);
        playerOne = new Player(controllerOne, getWidth(), getHeight());
        playerTwo = new Player(controllerTwo, getWidth(), getHeight());
        footprints = new ArrayList<>();
    }

    @Override
    public void update() {
        if (controllerOne.isQuitPressed() || controllerOne.isQuitPressed()) {
            stop();
        }
        playerOne.update();
        playerTwo.update();

        if (controllerOne.isMoving()) {
            footprints.add(playerOne.layFootprint());
        }

        if (controllerTwo.isMoving()) {
            footprints.add(playerTwo.layFootprint());
        }
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        for (Footprint footprint : footprints) {
            footprint.draw(canvas);
        }
        playerOne.draw(canvas);
        playerTwo.draw(canvas);
    }

    private void drawBackground(Engine.Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }
}
