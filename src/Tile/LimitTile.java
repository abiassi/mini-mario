package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;


public class LimitTile extends Tile implements Collidable {
    private Picture picture;

    public LimitTile() {
        super(TileType.LIMIT);
    }

    @Override
    public void render(int x, int y) {
        picture = new Picture(x, y, "src/Resources/limit_01.png");
        picture.draw();
    }

    @Override
    public void onCollision(GameCharacter person) {
        if (person.getVelocityY() > 1) { // If player hits limit from above, means he's falling
            person.die();
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
