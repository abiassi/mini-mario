package Character;

import ScoringSystem.CoinScore;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collectible;
import utils.Collidable;
import utils.CollisionDetector;

import java.util.List;

/**
 * Person class representing a character in the game.
 */
public class Person implements Collidable {
    private final Picture picture;
    private int positionX;
    private int positionY;
    private double velocityX;
    private double velocityY;
    private static final double SPEED = 3;
    private static final float GRAVITY = 0.6f;

    private CoinScore coinscore;

    /**
     * Constructor for Person class.
     */
    public Person(int x, int y, String resource) {
        positionX = x;
        positionY = y;
        picture = new Picture(x, y, resource);
        picture.draw();
    }

    public void moveUp() {
        velocityY = -SPEED * 3;
    }

    public void moveLeft() {
        velocityX = -SPEED;
    }

    public void moveRight() {
        velocityX = SPEED;
    }

    public void stopHorizontal() {
        velocityX = 0;
    }

    public int getX() {
        return positionX;
    }

    @Override
    public int getY() {
        return positionY;
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    public double getVelocityY() {
        return velocityY;
    }
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * Update method to handle character movement and collisions.
     */
    public void update(List<Collidable> collidableTiles) {
        velocityY += GRAVITY;
        positionY += velocityY;
        handleVerticalCollisions(collidableTiles);

        positionX += velocityX;
        handleHorizontalCollisions(collidableTiles);

        picture.translate(positionX - picture.getX(), positionY - picture.getY());
    }

    /**
     * Handle vertical collisions with collidable tiles.
     */

    /**
     * Handle horizontal collisions with collidable tiles.
     */
    private void handleVerticalCollisions(List<Collidable> collidableTiles) {
        for (Collidable tile : collidableTiles) {
            if (CollisionDetector.hasCollided(this, tile) && !handleCollectible(tile)) {
                tile.onCollision(this);
                if (velocityY > 0) {
                    positionY = tile.getY() - getHeight();
                    velocityY = 0;
                } else if (velocityY < 0) {
                    positionY = tile.getY() + tile.getHeight();
                    velocityY = 0;
                }
            }
        }
    }

    private void handleHorizontalCollisions(List<Collidable> collidableTiles) {
        for (Collidable tile : collidableTiles) {
            if (CollisionDetector.hasCollided(this, tile) && !handleCollectible(tile)) {
                tile.onCollision(this);
                if (velocityX > 0) {
                    positionX = tile.getX() - getWidth();
                    velocityX = 0;
                } else if (velocityX < 0) {
                    positionX = tile.getX() + tile.getWidth();
                    velocityX = 0;
                }
            }
        }
    }


    private boolean handleCollectible(Collidable tile) {
        if (tile instanceof Collectible) {
            tile.onCollision(this);
            return true;
        }
        return false;
    }



    @Override
    public void onCollision(Person person) {
        // Intentionally left empty as Person does not have any specific behavior when colliding with other objects
    }


}
