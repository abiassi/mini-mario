import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(12);
        game.init();
        game.start();

    }
}