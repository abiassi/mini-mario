package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.URL;

public class SolidTile extends Tile {

    public SolidTile() {
        super(TileType.GROUND_BRICK);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/brick_floor_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            Picture picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for SolidTile");
        }
    }
}
