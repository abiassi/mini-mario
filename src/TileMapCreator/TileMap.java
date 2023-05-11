package TileMapCreator;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.net.URL;


public class TileMap {
    public static final int PADDING = 10;
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

                URL imageUrl = null;

                switch (tile.getType()) {
                    case SKY:
                        break;
                    case GROUND_BRICK:
                        imageUrl = getClass().getClassLoader().getResource("img/brick_floor_01.png");
                        break;
                    case MYSTERY_BOX:
                        imageUrl = getClass().getClassLoader().getResource("img/box_01.png");
                        break;
                    case BREAKABLE_BRICK:
                        imageUrl = getClass().getClassLoader().getResource("img/brick_breakable_01.png");
                        break;
                }

                if (imageUrl != null) {
                    String imagePath = imageUrl.getPath();
                    Picture picture = new Picture(PADDING + x * cellSize, PADDING + y * cellSize, imagePath);
                    picture.draw();
                }
            }
        }
    }
}
