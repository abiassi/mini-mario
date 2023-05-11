package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.URL;

public class BreakableTile extends Tile {

    public BreakableTile() {
        super(TileType.BREAKABLE_BRICK);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/brick_breakable_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            Picture picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for BreakableTile");
        }
    }
}
