package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionUtil;

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
    public void onCollision(GameCharacter person) {
        if (CollisionUtil.isHitFromBelow(person, this)) {
            timesHit++;

            if (timesHit >= 2) {
                isDestroyed = true;
                picture.delete();
            }
        }
    }


    public boolean isDestroyed() {
        return isDestroyed;
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
