package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;

import java.net.URL;

public class SolidTile extends Tile implements Collidable {
    private Picture picture;

    public SolidTile() {
        super(TileType.GROUND_BRICK);
    }

    @Override
    public void render(int x, int y) {
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
    public void onCollision(GameCharacter person) {
        return; // No special behavior
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
