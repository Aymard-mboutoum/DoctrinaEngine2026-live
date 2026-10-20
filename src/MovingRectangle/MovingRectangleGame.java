package MovingRectangle;

import Engine.Canvas;
import Engine.Controller;
import Engine.Game;
import Engine.MovementController;

import java.awt.*;

public class MovingRectangleGame extends Game {
    private MovementController controller;
    Player player;
    Npc npc;

    @Override
    public void initialize() {
        controller = new MovementController();
        controller.useWASD();
        addKeyListener(controller);
        player = new Player(controller, getWidth(), getHeight());
        npc = new Npc();
    }

    @Override
    public void update() {
        player.update();
        npc.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        player.draw(canvas);
        npc.draw(canvas);
    }

    private void drawBackground(Engine.Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }
}
