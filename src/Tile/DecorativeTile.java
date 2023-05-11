package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.URL;

public class DecorativeTile extends Tile {

    public DecorativeTile() {
        super(TileType.DECORATIVE_TILE);
    }

    @Override // No decorative tile ex
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/decorative_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            Picture picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for Decorative Tile");
        }
    }
}