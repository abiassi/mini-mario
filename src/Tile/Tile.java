package Tile;

public abstract class Tile {
    private TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    // Add an abstract method for rendering the tile
    public abstract void render(int x, int y, int cellSize);
}
