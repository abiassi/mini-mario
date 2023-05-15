import ScoringSystem.CoinScore;
import ScoringSystem.Countdown;
import ScoringSystem.Score;
import GameCharacter.Enemy;
import Tile.*;
import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collectible;
import utils.Collidable;
import GameCharacter.Person;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int delay;
    private Person person;
    private Score score;
    private CoinScore coinScore;
    private Countdown countdown;

    private List<Enemy> enemies;
    private List<Collidable> collidableTiles;
    private boolean GameOver;

    public Game(int delay) {
        this.delay = delay;
    }




    public void init() {
        // Parse CSV and render tilemap
        TileMap tileMap = CSVParser.parse("src/Resources/level-1-v2.csv");
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
        person = new Person(50, 180, "src/Resources/mario_01.png");

        //Create Score
        score = new Score(60, 50, 0);

        //Create CoinScore
        coinScore = new CoinScore(250, 50,0, "src/Resources/coin_01.png");

        //Create Countdown
        countdown = new Countdown(400, 50, 120);
        countdown.start();

        // Create Keyboard handlers
        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPerson(person);

}

    public void start() throws InterruptedException {
        // Runs loop that updates all parts
        while (!GameOver) {
            Thread.sleep(delay);
            person.update(collidableTiles, enemies);
            handleCollidableRemovals();
            updateEnemies();
            removeDeadEnemies();
            checkGameOver();
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

    private void checkGameOver() {
        if (person.isDead() || person.hasFinishedLevel()) {
            GameOver = true;
            Picture picture = new Picture(960,50,"game.over.menu.jpeg");
            picture.draw();
        }
        if(person.hasFinishedLevel()){
            GameOver = true;
            Picture picture1 = new Picture(960,50,"level.com.menu.jpeg");
            picture1.draw();

        }
    }



}