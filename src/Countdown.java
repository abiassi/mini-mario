import java.util.*;

    public class Countdown {
        Timer timer;

        public Countdown () {
            timer = new Timer();



            TimerTask task = new TimerTask() {

                int seconds = 100;

                @Override
                public void run() {
                    if(seconds > 0){
                        System.out.println("Time: " + seconds);
                        seconds--;
                    }else{
                        System.out.println("Time's up!");
                        timer.cancel();
                    }
                }
            };
            timer.schedule(task, 0, 700);
        }





    }




