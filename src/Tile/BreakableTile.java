package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Character.Person;

import java.net.URL;

public class BreakableTile extends Tile implements Collidable {
    private int timesHit;
    private Picture picture;
    private boolean isDestroyed;

    public BreakableTile() {
        super(TileType.BREAKABLE_BRICK);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/brick_breakable_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for BreakableTile");
        }
    }

    @Override
    public void onCollision(Person person, CollisionDetector.CollisionSide side) {
        /*
        if (isDestroyed) {
            return;
        }

        switch (side) {
            case BOTTOM -> {
                person.stopMovement(CollisionDetector.CollisionSide.BOTTOM, this);
                timesHit++;
                if (timesHit >= 2) {
                    picture.delete();
                    isDestroyed = true;
                }
            }
            case TOP -> person.stopMovement(CollisionDetector.CollisionSide.TOP, this);
            case LEFT -> person.stopMovement(CollisionDetector.CollisionSide.LEFT, this);
            case RIGHT -> person.stopMovement(CollisionDetector.CollisionSide.RIGHT, this);
        }

         */
    }

    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }
}
