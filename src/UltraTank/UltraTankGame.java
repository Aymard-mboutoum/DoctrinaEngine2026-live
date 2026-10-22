package UltraTank;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

import java.awt.*;
import java.util.ArrayList;

public class UltraTankGame extends Game {
    Tank tank;
    UltraTankGamePad gamePad = new UltraTankGamePad();
    ArrayList<Missile> missiles;

    @Override
    public void initialize() {
        tank = new Tank(gamePad, getWidth(), getHeight());
        addKeyListener(gamePad);
        missiles = new ArrayList<Missile>();
    }

    @Override
    public void update() {
        tank.update();
        if (gamePad.isFirePressed()) {
            Missile firedMissile = tank.fire();
            if (firedMissile != null) {
                missiles.add(firedMissile);
            }
        }

        ArrayList<Missile> toRemove = new ArrayList<>();
        for(Missile missile : missiles) {
            missile.update();
            if (missile.getX() > getWidth() || missile.getY() > getHeight()) {
                toRemove.add(missile);
            }
        }

        for(Missile missile : toRemove) {
            missiles.remove(missile);
        }
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        tank.draw(canvas);
        for(Missile missile : missiles) {
            missile.draw(canvas);
        }
    }
}
