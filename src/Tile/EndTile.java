package Tile;

import GameCharacter.GameCharacter;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;

import java.net.URL;

public class EndTile extends Tile implements Collidable {
    private Picture picture;
    public EndTile() {
        super(TileType.END_TILE);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/end_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for EndTile");
        }
    }

    @Override
    public void onCollision(GameCharacter person) {
        // TODO: Add gameover method
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
