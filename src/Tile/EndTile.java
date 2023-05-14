package Tile;

import GameCharacter.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;


public class EndTile extends Tile implements Collidable {
    private Picture picture;
    public EndTile() {
        super(TileType.END_TILE);
    }

    @Override
    public void render(int x, int y) {
            picture = new Picture(x, y, "src/Resources/end_01.png");
            picture.draw();

    }

    @Override
    public void onCollision(GameCharacter person) {
        if (person instanceof Person) {
            ((Person) person).finishLevel();
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
