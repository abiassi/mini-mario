import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Person implements Collidable {


    ///Properties///
    private Picture picture;
    private final int SPEED = 0;
    private boolean isJumping;

    private boolean isFalling;
    private int maxJump; // picture.getY - picture.getHeight

    public Person(int x, int y, String resource) {
        picture = new Picture(x, y, resource);
        picture.draw();
        this.maxJump = picture.getY() - picture.getHeight();
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
    public void update(){
        if(isJumping){
            moveUp();
        }
        if(picture.getY() == maxJump){
            isFalling = true;
        }
        if(isFalling){
            moveDown();
        }
        //still have to figure out how to calculate the ground (whether that be the actual floor or on an obstacle/platform

    }
}
