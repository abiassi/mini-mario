package GameCharacter;

import utils.Collectible;
import utils.Collidable;
import utils.CollisionDetector;
import java.util.List;
import java.util.Random;

public class Enemy extends GameCharacter implements Collidable {
    private static final double MOVE_DISTANCE = 1;
    private static final int MOVE_TIME = 36;
    private double initialX;
    private int direction;
    private long lastUpdate;


    /**
     * Constructor for Enemy class.
     */
    public Enemy(int x, int y) {
        super(x, y, "/img/goomba_01.png");
        initialX = x;
        lastUpdate = System.currentTimeMillis();
        Random random = new Random();
        direction = random.nextBoolean() ? 1 : -1;
    }

    @Override
    public void onCollision(GameCharacter person) {
        System.out.println("On Collision");
        if (person.velocityY > 1) { // Setting threshold since there is some jitter coming from gravity
            die();
            // TODO: add score
        } else {
            person.die();
            // TODO: Add gameOver
        }
    }

    public void update(List<Collidable> collidableTiles) {
        super.update(collidableTiles);

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdate >= 50) {
            positionX += direction * MOVE_DISTANCE;
            lastUpdate = currentTime;
        }

        if (positionX - initialX >= MOVE_TIME * MOVE_DISTANCE) {
            direction = -1;
        } else if (positionX - initialX <= -MOVE_TIME * MOVE_DISTANCE) {
            direction = 1;
        }

        picture.translate(positionX - picture.getX(), 0);
    }






}
