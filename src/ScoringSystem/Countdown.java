package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Text;
import java.util.Timer;
import java.util.*;


public class Countdown {

    Timer timer;
    Text text;
    private int seconds;

    TimerTask task;

    public Countdown(double x, double y, int s) {
        this.seconds = s;
        timer = new Timer();
        text = new Text(x, y, "TIME: " + String.valueOf(seconds));
        text.setColor(org.academiadecodigo.simplegraphics.graphics.Color.WHITE);
        text.draw();

        task = new TimerTask() {


            @Override
            public void run() {
                if (seconds >= 0) {
                    text.setText("TIME: " + String.valueOf(seconds));
                    text.draw();
                    seconds--;
                } else {
                    timer.cancel();
                    displayMessage("TIME IS UP!");

                }
            }
        };


    }

    public void start() {
        timer.schedule(task, 0, 700);
    }

    public void displayMessage(String message) {
        // Display a big message on the screen
        Text bigText = new Text(1000, 100, message);
        bigText.setColor(org.academiadecodigo.simplegraphics.graphics.Color.RED);
        bigText.grow(200, 100);
        bigText.draw();


    }
}