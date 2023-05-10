package TileMapCreator;

public class Tile {
    private TileType type;
    // Will hold properties like position, image

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
    public TileType setTileType(TileType type) {
        this.type = type;
        return this.getType();
    }

}
