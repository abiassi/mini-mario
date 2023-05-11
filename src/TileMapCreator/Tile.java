package TileMapCreator;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile {
    private Rectangle rectangle;

    private TileType type;
    // Will hold properties like position, image

    public Tile(TileType type) {
        this.type = type;
        this.rectangle = new Rectangle();
        rectangle.fill();
    }

    public TileType getType() {
        return type;
    }
    public TileType setTileType(TileType type) {
        this.type = type;
        return this.getType();
    }

}
