package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Character.Person;

import java.net.URL;

public class SolidTile extends Tile implements Collidable {
    private Picture picture;

    public SolidTile() {
        super(TileType.GROUND_BRICK);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/brick_floor_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for SolidTile");
        }
    }

    @Override
    public void onCollision(Person person, CollisionDetector.CollisionSide side) {
        switch (side) {
            case BOTTOM -> person.stopMovement(CollisionDetector.CollisionSide.BOTTOM);
            case TOP -> person.stopMovement(CollisionDetector.CollisionSide.TOP);
            case LEFT -> person.stopMovement(CollisionDetector.CollisionSide.LEFT);
            case RIGHT -> person.stopMovement(CollisionDetector.CollisionSide.RIGHT);
        }
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
