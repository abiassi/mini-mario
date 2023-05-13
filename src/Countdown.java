import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Countdown {

        //when game.init(), timer == 100 and decreases every x seconds

        private Text timerText;
        private double x, y;

        Timer timer;

        String text;

        int seconds = 100;

        //public void paintShape(java.awt.Graphics2D g2)


        //how do we make dynamic text show up every x seconds?

        public Countdown(double x, double y, String text) {
            this.x = x;
            this.y = y;
            this.text = text;
            timerText = new Text(x, y, text);
            timerText.setText("Time: " + seconds);
            timerText.setColor(Color.BLACK);
            timerText.draw();
        }
    }


        //on Game, countdown() and timer.start();

       /* public void countdown() {
            timer = new Timer(800, new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    //still working on it
                }
            }
        }
    }
    */



