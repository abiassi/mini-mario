package Tests;
import TileMapCreator.TileMap;
import TileMapCreator.CSVParser;


// TestCSVParser.java
public class TestCSVParser {
    public static void main(String[] args) {
        TileMap tileMap = CSVParser.parse("src/Tests/Resources/level1.csv");

        if (tileMap != null) {
            tileMap.init();
            tileMap.render();
        } else {
            System.out.println("Error parsing CSV file.");
        }
    }
}
