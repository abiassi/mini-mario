package Tile;

import GameCharacter.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionUtil;


public class BreakableTile extends Tile implements Collidable {
    private int timesHit;
    private Picture picture;
    private boolean isDestroyed;

    public BreakableTile() {
        super(TileType.BREAKABLE_BRICK);
    }

    @Override
    public void render(int x, int y) {
            picture = new Picture(x, y, "src/Resources/brick_breakable_01.png");
            picture.draw();
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
