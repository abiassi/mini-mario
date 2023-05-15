package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Color;
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
        text.setColor(Color.WHITE);
        text.grow(15,15);
        text.draw();

        task = new TimerTask() {


            @Override
            public void run() {
                if (seconds >= 0) {
                    updateText(seconds);
                    seconds--;
                } else {
                    timer.cancel();
                    displayMessage("TIME IS UP!");

                }
            }
        };
    }

    public void updateText(int seconds) {
        text.setText("TIME: " + seconds);
        text.setColor(seconds > 5 ? Color.WHITE : Color.RED);
        text.draw();
    }


    public void displayMessage(String message) {
        // Display a big message on the screen
        Text bigText = new Text(1000, 100, message);
        bigText.setColor(org.academiadecodigo.simplegraphics.graphics.Color.RED);
        bigText.grow(200, 100);
        bigText.draw();


    }

    public void start() {
        timer.schedule(task, 0, 700);
    }
}