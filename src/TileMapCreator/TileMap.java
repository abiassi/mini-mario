package TileMapCreator;
import Tile.Tile;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import utils.Collidable;

import java.util.ArrayList;
import java.util.List;

public class TileMap {
    public static final int PADDING = 16;
    private int cellSize = 16;
    private Tile[][] map;

    public TileMap(int width, int height) {
        map = new Tile[width][height];
    }

    public void init() {
        // Generate background
        Color backgroundColor = new Color(107, 140, 255);
        Rectangle background = new Rectangle(PADDING, PADDING, getWidth() * cellSize, getHeight() * cellSize);
        background.setColor(backgroundColor);
        background.fill();

        // Generate tilemap
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

    public void render() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                Tile tile = getTile(x, y);
                if (tile != null) {
                    tile.render(PADDING + x * cellSize, PADDING + y * cellSize, cellSize);
                }
            }
        }
    }

    public List<Collidable> getCollidableTiles() {
        // Compile list of collidable tiles
        List<Collidable> collidableTiles = new ArrayList<>();

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                Tile tile = getTile(x, y);
                if (tile instanceof Collidable) {
                    collidableTiles.add((Collidable) tile);
                }
            }
        }
        return collidableTiles;
    }
}
