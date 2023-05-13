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
        text = new Text(x, y, String.valueOf(seconds));
        text.draw();

        task = new TimerTask() {


            @Override
            public void run() {
                if (seconds > 0) {
                    text.setText(String.valueOf(seconds));
                    text.draw();
                    seconds--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }
        };


    }

    public void start() {
        timer.schedule(task, 0, 700);
    }
}


