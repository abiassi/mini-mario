package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.URL;

public class EndTile extends Tile {

    public EndTile() {
        super(TileType.END_TILE);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        // Render solid tile
        URL imageUrl = getClass().getClassLoader().getResource("img/end_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            Picture picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for EndTile");
        }
    }
}
