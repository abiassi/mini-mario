package Tile;
import Character.Person;
import utils.CollisionDetector;

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
    public abstract void onCollision(Person person, CollisionDetector.CollisionSide side);
}
