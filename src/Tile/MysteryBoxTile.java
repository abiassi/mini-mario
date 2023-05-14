package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionUtil;

import java.net.URL;

public class MysteryBoxTile extends Tile implements Collidable {
    private Picture picture;
    private boolean isDestroyed;

    public MysteryBoxTile() {
        super(TileType.MYSTERY_BOX);
    }

    @Override
    public void render(int x, int y) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/box_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for MysteryBoxTile");
        }
    }

    @Override
    public void onCollision(GameCharacter person) {
         return; // Using onCollisionMysteryBox special method here
    }


    public CoinTile onCollisionMysteryBox(GameCharacter person) {
        if (!isDestroyed() && CollisionUtil.isHitFromBelow(person, this)) {
            isDestroyed = true;
            CoinTile coinTile = new CoinTile();
            coinTile.render(getX(), getY() - getHeight());
            picture.delete();
            return coinTile;
        }
        return null;
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

