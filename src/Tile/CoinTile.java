package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Character.Person;

import java.net.URL;

public class CoinTile extends Tile implements Collidable {
    private Picture picture;
    private boolean collected;

    public CoinTile() {
        super(TileType.COIN);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/coin_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for CoinTile");
        }
    }

    public void onCollision(Person person, CollisionDetector.CollisionSide side) {
        if (collected) {
            return;
        }
        picture.delete();
        collected = true;
        // TODO: Add increment coin score action
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
