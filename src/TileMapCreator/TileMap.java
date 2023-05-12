package TileMapCreator;
import Tile.Tile;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import Camera.Camera;

public class TileMap {
    public static final int PADDING = 16;
    private int cellSize = 16;
    private Tile[][] map;
    private Camera camera;

    public TileMap(int width, int height) {
        map = new Tile[width][height];
        camera = new Camera();
    }

    public void init() {
        // Generate background
        Color backgroundColor = new Color(107, 140, 255);
        Rectangle background = new Rectangle(PADDING, PADDING, camera.getWidth(), camera.getHeight());
        background.setColor(backgroundColor);
        background.fill();

        // Generate tilemap
        Rectangle field = new Rectangle(PADDING, PADDING, camera.getWidth(), camera.getHeight());
        field.draw();
    }

    public void setTile(int x, int y, Tile tile) {
        map[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return null;
        }
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
        // Clear the canvas with a black background
        // TODO: size needs adjustment
        Rectangle blackBackground = new Rectangle(PADDING, PADDING, camera.getWidth(), camera.getHeight());
        blackBackground.setColor(Color.WHITE);
        blackBackground.fill();

        // Draw the blue background
        Color backgroundColor = new Color(107, 140, 255);
        Rectangle blueBackground = new Rectangle(PADDING, PADDING, camera.getWidth(), camera.getHeight());
        blueBackground.setColor(backgroundColor);
        blueBackground.fill();

        int cameraX = camera.getX() / cellSize;
        int cameraY = camera.getY() / cellSize;
        int cameraWidth = camera.getWidth() / cellSize;
        int cameraHeight = camera.getHeight() / cellSize;

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                Tile tile = getTile(x, y);
                if (tile != null && x >= cameraX && x < cameraX + cameraWidth && y >= cameraY && y < cameraY + cameraHeight) {
                    tile.render(PADDING + x * cellSize - camera.getX(), PADDING + y * cellSize - camera.getY(), cellSize);
                }
            }
        }
    }




    public void updateCamera(int playerX, int playerY, int levelWidth, int levelHeight) {
        camera.update(playerX, playerY, levelWidth, levelHeight);
    }
}
