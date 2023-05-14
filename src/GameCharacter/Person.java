package GameCharacter;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collectible;
import utils.Collidable;
import utils.CollisionDetector;

import java.util.List;

/**
 * Person class representing a character in the game.
 */
public class Person extends GameCharacter implements Collidable {

    /**
     * Constructor for Person class.
     */
    public Person(int x, int y, String resource) {
        super(x, y, resource);
    }

    public void update(List<Collidable> collidableTiles, List<Enemy> enemies) {
        velocityY += GRAVITY;
        positionY += velocityY;
        handleVerticalCollisions(collidableTiles);
        handleEnemyCollisions(enemies);

        positionX += velocityX;
        handleHorizontalCollisions(collidableTiles);
        handleEnemyCollisions(enemies);

        picture.translate(positionX - picture.getX(), positionY - picture.getY());
    }




    /**
     * Handle horizontal collisions with collidable tiles.
     */

    protected void handleVerticalCollisions(List<Collidable> collidableTiles) {
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


    protected void handleHorizontalCollisions(List<Collidable> collidableTiles) {
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

    private void handleEnemyCollisions(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (CollisionDetector.hasCollided(this, enemy)) {
                enemy.onCollision(this);
            }
        }
    }


    @Override
    public void onCollision(GameCharacter person) {
        // Intentionally left empty as Person does not have any specific behavior when colliding with other objects
    }


}
