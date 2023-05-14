package GameCharacter;

import ScoringSystem.CoinScore;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;

import java.util.List;

public abstract class GameCharacter implements Collidable {
    protected Picture picture;
    protected int positionX;
    protected int positionY;
    protected double velocityX;
    protected double velocityY;
    protected static final double SPEED = 3;
    protected static final float GRAVITY = 0.6f;
    protected boolean dead;
    protected boolean onGround;


    public GameCharacter(int x, int y, String resource) {
        positionX = x;
        positionY = y;
        picture = new Picture(x, y, resource);
        picture.draw();
    }

    public void moveUp() {
        if (onGround) { // Only allow jumping if on the ground
            velocityY += -SPEED * 3;
            onGround = false; // Set onGround flag to false after jumping
        }
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
    protected void handleVerticalCollisions(List<Collidable> collidableTiles) {
        for (Collidable tile : collidableTiles) {
            if (CollisionDetector.hasCollided(this, tile)) {
                tile.onCollision(this);
                if (velocityY > 0) {
                    positionY = tile.getY() - getHeight();
                    velocityY = 0;
                } else if (velocityY < 0) {
                    positionY = tile.getY() + tile.getHeight();
                    velocityY = 0;
                }
                onGround = true;
            }
        }
    }

    /**
     * Handle horizontal collisions with collidable tiles.
     */
    protected void handleHorizontalCollisions(List<Collidable> collidableTiles) {
        for (Collidable tile : collidableTiles) {
            if (CollisionDetector.hasCollided(this, tile)) {
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

    public void die() {
        picture.delete();
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }
}
