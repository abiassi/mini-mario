package TileMapCreator;

public class TileMap {
    private Tile[][] map;

    public TileMap(int width, int height) {
        map = new Tile[width][height];
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


    // Need to render, update, etc

}
