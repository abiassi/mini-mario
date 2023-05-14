package Tile;

import ScoringSystem.CoinScore;
import ScoringSystem.Score;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collectible;
import utils.Collidable;
import Character.Person;

import java.net.URL;

public class CoinTile extends Tile implements Collidable, Collectible {
    private Picture picture;
    private boolean collected;

    private CoinScore coinScore;;
    private Score score;

    public CoinTile() {
        super(TileType.COIN);
    }

    @Override
    public void render(int x, int y, int cellSize) {
        URL imageUrl = getClass().getClassLoader().getResource("img/coin_01.png");
        if (imageUrl != null) {
            String imagePath = imageUrl.getPath();
            picture = new Picture(x, y, imagePath);
            picture.draw();
        } else {
            throw new RuntimeException("Unable to load image for CoinTile");
        }
    }

    public void onCollision(Person person) {
        if (collected) {
            return;
        }
        picture.delete();
        collected = true;
        coinScore.increaseCoins();
        score.increaseScore();
    }

    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    @Override
    public boolean isCollected() {
        return collected;
    }
}
