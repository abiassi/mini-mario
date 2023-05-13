import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;
import utils.Collidable;
import Character.Person;

import java.util.List;

public class Game {
    private static final String PREFIX = "resources/";
    private final int delay;
    private Person person;
    //public int centerX= 300;
    // private int score = 0;
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
            //person.checkCollisions(collidableTiles);
        }
    }
}

    /*

                    if (utils.CollisionDetector.hasCollided(person, blocks[i])) { // Abi: Substitute for Tiles
                    System.out.println("colliding with block");
                    person.stopFall();
     */