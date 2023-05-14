import GameCharacter.Enemy;
import Tile.*;
import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;
import utils.Collectible;
import utils.Collidable;
import GameCharacter.Person;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int delay;
    private Person person;
    private List<Enemy> enemies;
    private List<Collidable> collidableTiles;

    public Game(int delay) {
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

        enemies = new ArrayList<>();
        enemies.add(new Enemy(360, 200));
        enemies.add(new Enemy(600, 200));
        enemies.add(new Enemy(1200, 200));


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
            person.update(collidableTiles, enemies);
            handleCollidableRemovals();
            updateEnemies();
            removeDeadEnemies();
        }
    }

    private void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.update(collidableTiles);
        }
    }

    private void removeDeadEnemies() {
        enemies.removeIf(Enemy::isDead);
    }

    private void handleCollidableRemovals() {
        collidableTiles.removeIf(collidable -> collidable instanceof Collectible && ((Collectible) collidable).isCollected());
        collidableTiles.removeIf(collidable -> collidable instanceof BreakableTile && ((BreakableTile) collidable).isDestroyed());
        collidableTiles.removeIf(collidable -> collidable instanceof MysteryBoxTile && ((MysteryBoxTile) collidable).isDestroyed());
    }



}