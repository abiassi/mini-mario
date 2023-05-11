package TileMapCreator;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TileMap {
    public static final int PADDING = 10;
    private int cellSize = 50;
    private Tile[][] map;

    public TileMap(int width, int height) {
        map = new Tile[width][height];
    }

    public void init() {
        Rectangle field = new Rectangle(PADDING, PADDING, getWidth() * cellSize, getHeight() * cellSize);
        field.draw();
    }

    public void setTile(int x, int y, Tile tile) {
        map[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }
    public int getCellSize() {
        return cellSize;
    }



    // Need to render, update, etc

}
