package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;

import java.net.URL;

public class MysteryBoxTile extends Tile implements Collidable {
    private Picture picture;
    private boolean isDestroyed;

    public MysteryBoxTile() {
        super(TileType.MYSTERY_BOX);
    }

    @Override
    public void render(int x, int y, int cellSize) {
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
        return; // TODO: add interaction that adds a coin tile to the above this box
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

