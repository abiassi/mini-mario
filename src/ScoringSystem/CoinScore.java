package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class CoinScore {

    private static Text text;
    private static int coins;

    private static Picture picture;

    private static Font font;

    public CoinScore (double x, double y, int coins, String resource) {
        this.coins = coins;
        text = new Text(x, y, "x " + String.valueOf(coins));
        text.setColor(Color.WHITE);
        text.grow(15,15);
        text.draw();
        picture = new Picture(text.getX() - 20, text.getY()+ 10, resource);
        picture.draw();

    }



    public static void increaseCoins(){
        updateCoinsDisplay();
        coins++;
    }

    public static void updateCoinsDisplay() {
        text.setText("x " + String.valueOf(coins));
    }


}
