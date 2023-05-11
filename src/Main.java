import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! 123");

        /*
            Code to test TileMap generation
             */
        TileMap tileMap = CSVParser.parse("src/Tests/Resources/level1.csv");

        if (tileMap != null) {
            tileMap.init();
            tileMap.render();
        }
    }
}