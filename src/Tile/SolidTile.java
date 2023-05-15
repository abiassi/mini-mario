package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;


public class SolidTile extends Tile implements Collidable {
    private Picture picture;

    public SolidTile() {
        super(TileType.GROUND_BRICK);
    }

    @Override
    public void render(int x, int y) {
            picture = new Picture(x, y, "src/Resources/brick_floor_01.png");
            picture.draw();

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
