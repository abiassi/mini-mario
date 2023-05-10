package Tests;
import TileMapCreator.Tile;
import TileMapCreator.TileMap;
import TileMapCreator.CSVParser;


// TestCSVParser.java
public class TestCSVParser {
    public static void main(String[] args) {
        TileMap tileMap = CSVParser.parse("src/Tests/Resources/level1.csv");

        if (tileMap != null) {
            int width = tileMap.getWidth();
            int height = tileMap.getHeight();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Tile tile = tileMap.getTile(x, y);
                    System.out.print(tile.getType().getValue() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Error parsing CSV file.");
        }
    }
}
