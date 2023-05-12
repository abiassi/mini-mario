import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Person implements Collidable {


    ///Properties///
    private Picture picture;
    // private CollisionDetector detector;
    private Blocks blocks;
    private final int SPEED = 10;
    private boolean isJumping;

    private boolean isFalling;
    private int maxJump; // picture.getY - picture.getHeight

    public Person(int x, int y, String resource) {

        picture = new Picture(x, y, resource);
        picture.draw();
        this.maxJump = 100;

    }



    public boolean isFalling() {
        return isFalling;
    }

    public boolean isJumping() {
        return isJumping;
    }


    public void moveUp() {
        picture.translate(0, -SPEED);
    }

    public void moveDown() {
        picture.translate(0, SPEED);
    }

    public void moveLeft() {
        System.out.println("moving left in moveleft");
        picture.translate(-SPEED, 0);
    }

    public void moveRight() {
        picture.translate(SPEED, 0);
    }


    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    public void jump() {
        isJumping = true;

    }
    public void stopFall(){
        isFalling = false;
    }


public boolean personPos() {
    return picture.getX() == 300;
}
    //update jump method to call at the end of loop inside game start//
/* if isJumping
      translate ip;
   if persons y equals maxJump
         isFalling equals true;
   if isFalling
       translate down
   if persons y equals ground
       isFalling equals false
 */
    public void update() {
        while (isJumping) {
            moveUp();
            if (picture.getY() == maxJump) {
                isFalling = true;
                moveDown();
                if (isFalling) {
                    moveDown();
                    //if (CollisionDetector.hasCollided(this, blocks)) {
                       // System.out.println("has colided is being used");
                       // isFalling = false;
                        // }


                        //}
                        //}
                    }
                }
            }
        }


        public void setBlocks (Blocks blocks){
            this.blocks = blocks;
        }
    }
