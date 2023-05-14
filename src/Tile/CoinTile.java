package Tile;

import ScoringSystem.CoinScore;
import ScoringSystem.Score;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collectible;
import utils.Collidable;
import GameCharacter.*;

public class CoinTile extends Tile implements Collidable, Collectible {
    private Picture picture;
    private boolean collected;

    public CoinTile() {
        super(TileType.COIN);
    }

    @Override
    public void render(int x, int y) {
            picture = new Picture(x, y, "src/Resources/coin_01.png");
            picture.draw();
    }

    public void onCollision(GameCharacter person) {
        if (collected) {
            return;
        }
        picture.delete();
        collected = true;
        CoinScore.increaseCoins();
        Score.increaseScore();
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
