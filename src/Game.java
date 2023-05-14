import ScoringSystem.CoinScore;
import ScoringSystem.Countdown;
import ScoringSystem.Score;
import Tile.*;
import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;
import utils.Collectible;
import utils.Collidable;
import Character.Person;

import java.util.List;

public class Game {
    private static final String PREFIX = "resources/";
    private final int delay;
    private Person person;
    private Score score;
    private CoinScore coinScore;
    private Countdown countdown;

    private List<Collidable> collidableTiles;

    public Game(int delay) { //incomplete
        this.delay = delay;
    }


    public void init() {
        // Parse CSV and render tilemap
        TileMap tileMap = CSVParser.parse("src/Tests/Resources/level1.csv");
        if (tileMap != null) {
            tileMap.init();
            tileMap.render();
            collidableTiles = tileMap.getCollidableTiles();  // Get collidable blocks list
        }

        // Create Character.Person
        person = new Person(30, 180, "img/mario_01.png");

        //Create Score
        score = new Score(30, 30, 0);

        //Create CoinScore
        coinScore = new CoinScore(70, 30,0);

        //Create Countdown
        countdown = new Countdown(100, 30, 100);
        countdown.start();

        // Create Keyboard handlers
        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPerson(person);
}

    public void start() throws InterruptedException {
        // Runs loop that updates all parts
        while (true) {
            Thread.sleep(delay);
            person.update(collidableTiles);
            collidableTiles.removeIf(collidable -> collidable instanceof Collectible && ((Collectible) collidable).isCollected());
            collidableTiles.removeIf(collidable -> collidable instanceof BreakableTile && ((BreakableTile) collidable).isDestroyed());
        }
    }



}