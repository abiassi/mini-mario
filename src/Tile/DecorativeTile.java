package Tile;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DecorativeTile extends Tile {
    private Picture picture;

    public DecorativeTile() {
        super(TileType.DECORATIVE_TILE);
    }

    @Override // No decorative tile ex
    public void render(int x, int y) {
        // Render solid tile
            picture = new Picture(x, y, "src/Resources/decorative_01.png");
            picture.draw();
    }


}