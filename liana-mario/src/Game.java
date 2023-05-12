import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Game {
    private static final String PREFIX = "resources/";
    private final int delay;

    private Person person;
    private Blocks[] blocks;

    private int score = 0;


    public Game(int delay , int numOfBlocks){ //incomplete
        this.delay = delay;
        blocks = new Blocks[numOfBlocks];
    }



public void init(){
    Picture background = new Picture(0, 0, PREFIX + "test-background.jpeg");
    background.draw();




    this.person = new Person(50,300, PREFIX + "mario.png");
    MyKeyboard myKeyboard = new MyKeyboard();
    myKeyboard.init();
    myKeyboard.setPerson(person);


        for(int i =0; i < blocks.length; i++ ){
            blocks[i] = new Blocks(0 + (i *50), 200, 50);

        }

}
public void start()throws InterruptedException{
        while (true){

            Thread.sleep(delay);
            person.update();




            for( int i = 0; i< blocks.length; i++){
                if(blocks[i] == null){
                    continue;
                }
                if(person.personPos()){
                    Picture background = new Picture(0,0, PREFIX + "test-background.jpeg");
                    background.translate(-100,-10);
                }

                if(CollisionDetector.hasCollided(person,blocks[i])){
                    System.out.println("big poo");
                    person.stopFall();


                }
            }
        }
}

}

