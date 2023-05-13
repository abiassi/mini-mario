import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Game {
    private static final String PREFIX = "resources/";
    private final int delay;

    private Person person;
    private Blocks[] blocks;
    public int centerX= 300;

    private int score = 0;


    public Game(int delay, int numOfBlocks) { //incomplete
        this.delay = delay;
        blocks = new Blocks[numOfBlocks];
    }


    public void init() {
        Picture background = new Picture(0, 0, PREFIX + "test-background.jpeg");
        background.draw();


        this.person = new Person(10, 180, PREFIX + "mario.png");
        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPerson(person);


        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Blocks(0 + (i * 50), 200, 50);

        }

    }

    public void start() throws InterruptedException {
        while (true) {

            Thread.sleep(delay);
            person.update();
            //method for following player, possible works but cant be put here as it lays in front of blocks and player
            if(person.getX() == centerX){
                Picture background = new Picture(0, 0, PREFIX + "test-background.jpeg");
                background.draw();
               background.translate(-1,0);

            }


            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] == null) {
                    continue;
                }


                if (CollisionDetector.hasCollided(person, blocks[i])) {
                    System.out.println("colliding with block");
                    person.stopFall();


                }
            }
        }
    }
}



