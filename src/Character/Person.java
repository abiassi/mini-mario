package Character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Tile.Tile;
import java.util.List;

public class Person implements Collidable {


    ///Properties///
    private Picture picture;

    private final int SPEED = 10;
    private boolean isJumping;

    private boolean isFalling;
    private int maxJump; // picture.getY - picture.getHeight

    public Person(int x, int y, String resource) {

        picture = new Picture(x, y, resource);
        picture.draw();
        this.maxJump = 100; //set to 100 just for testing as original cal didnt work

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

    public void stopFall() {
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
        if (isJumping) {
            moveUp();
        }
        if (picture.getY() == maxJump) {
            isFalling = true;
            moveDown();
        }
        //  if (isFalling) {
        //    moveDown();
    }

    public void checkCollisions(List<Collidable> collidableTiles) {
        for (Collidable collidable : collidableTiles) {
            // Checking for a collision and on which side
            CollisionDetector.CollisionSide side = CollisionDetector.detectCollisionSide(this, collidable);
            if(side != CollisionDetector.CollisionSide.NONE) {
                ((Tile) collidable).onCollision(this, side);
            }
        }
    }

    public void stopMovement(CollisionDetector.CollisionSide side) {
        switch (side) {
            case TOP:
                moveDown();
                isFalling = false;
                break;
            case BOTTOM:
                moveUp();
                isJumping = false;
                break;
            case LEFT:
                this.moveRight();
                break;
            case RIGHT:
                this.moveLeft();
                break;
            case NONE:
                // No action needed
                break;
        }
    }

}