package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class CoinScore {

    private Text text;
    private int coins;

    public CoinScore (double x, double y, int coins) {
        this.coins = coins;
        text = new Text(x, y, String.valueOf(coins));
        text.draw();
    }

    public int getCoinScore() {
        return coins;
    }

    public void increaseCoins(){
        updateCoinsDisplay();
        coins++;
    }

    public void updateCoinsDisplay() {
        text.setText(String.valueOf(coins));
    }


}