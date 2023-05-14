package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class CoinScore {

    private static Text text;
    private static int coins;

    public CoinScore (double x, double y, int coins) {
        this.coins = coins;
        text = new Text(x, y, String.valueOf(coins));
        text.draw();
    }

    public static int getCoinScore() {
        return coins;
    }

    public static void increaseCoins(){
        updateCoinsDisplay();
        coins++;
    }

    public static void updateCoinsDisplay() {
        text.setText(String.valueOf(coins));
    }


}
