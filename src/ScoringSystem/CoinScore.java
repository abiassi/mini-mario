package ScoringSystem;

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
        text.setColor(org.academiadecodigo.simplegraphics.graphics.Color.WHITE);
        text.draw();
        picture = new Picture(text.getX() - 20, text.getY(), resource);
        picture.draw();

    }

    public static void paintShape(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 10));
        text.paintShape(g2);

    }



    public static void increaseCoins(){
        updateCoinsDisplay();
        coins++;
    }

    public static void updateCoinsDisplay() {
        text.setText("x " + String.valueOf(coins));
    }


}
