package Tile;


public abstract class Tile {
    private final TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    // Add an abstract method for rendering the tile
    public abstract void render(int x, int y);


}
