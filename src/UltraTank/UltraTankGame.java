package UltraTank;

import Engine.*;
import Engine.Canvas;

import java.awt.*;
import java.util.ArrayList;

public class UltraTankGame extends Game {
    Tank tank;
    UltraTankGamePad gamePad = new UltraTankGamePad();
    ArrayList<Missile> missiles;
    ArrayList<Brick> bricks;

    @Override
    public void initialize() {
        tank = new Tank(gamePad, getWidth(), getHeight());
        addKeyListener(gamePad);
        missiles = new ArrayList<Missile>();
        bricks = new ArrayList<>();
        initializeBricks();
    }

    private void initializeBricks() {
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(484, 148));
        bricks.add(new Brick(500, 164));
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
        ArrayList<StaticActor> destroyedActors = new ArrayList<>();
        for(Missile missile : missiles) {
            missile.update();
            for(Brick brick : bricks) {
                if (missile.hitBoxIntersectsWith(brick)) {
                    destroyedActors.add(missile);
                    destroyedActors.add(brick);
                }
            }
            if (missile.getX() > getWidth() || missile.getY() > getHeight()) {
                toRemove.add(missile);
            }
        }

        for(StaticActor actor: destroyedActors) {
            if (actor instanceof Brick) {
                bricks.remove(actor);
            } else if (actor instanceof Missile) {
                missiles.remove(actor);
            }
        }
        CollidableRepository.getInstance().unregisterActors(destroyedActors);

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
        for(Brick brick : bricks) {
            brick.draw(canvas);
        }
    }
}
