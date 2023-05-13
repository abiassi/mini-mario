package Character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.Collidable;
import utils.CollisionDetector;
import Tile.Tile;
import java.util.List;

public class Person implements Collidable {
    private Picture picture;

    private int positionX;
    private int positionY;
    private double velocityX;
    private double velocityY;
    private boolean onGround;

    private final double SPEED = 0.2;
    private final float GRAVITY = 0.6f;
    private final int JUMP_STRENGTH = 1;


    public Person(int x, int y, String resource) {
        positionX = x;
        positionY = y;
        picture = new Picture(x, y, resource);
        picture.draw();
        onGround = false;
    }


    public void moveUp() {
        System.out.println("MoveUp called, onGround: " + onGround);
        if (onGround) {
            velocityY = -5;
            onGround = false;
        }
    }



    public void moveLeft() {
        velocityX = -SPEED;
    }

    public void moveRight() {
        velocityX = SPEED;
    }


    public int getX() {
        return positionX;
    }

    @Override
    public int getY() {
        return positionY;
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }



    public void update() {
        positionX += velocityX * 10;
        positionY += velocityY * 2.5;

        System.out.println("Position X: " + positionX + ", Position Y: " + positionY);
        System.out.println("Velocity X: " + velocityX + ", Velocity Y: " + velocityY);

        picture.translate(positionX - picture.getX(), positionY - picture.getY());

        if (!onGround) {
            applyGravity();
        }
    }






    private void applyGravity() {
        if (!onGround) {
            velocityY += GRAVITY * 0.1;
        }
    }


    public void checkCollisions(List<Collidable> collidableTiles) {
        for (Collidable tile : collidableTiles) {
            CollisionDetector.CollisionSide side = CollisionDetector.detectCollisionSide(this, tile);
            if (side != CollisionDetector.CollisionSide.NONE) {
                stopMovement(side, tile);

                if (side == CollisionDetector.CollisionSide.TOP) {
                    onGround = true;
                    System.out.println("Character on ground");
                }
            }
        }
    }








    public void stopMovement(CollisionDetector.CollisionSide side, Collidable collidable) {
        switch (side) {
            case TOP:
                velocityY = 0;
                positionY = collidable.getY() - getHeight();
                System.out.println("(Top) Adjusting Position Y to: " + positionY);
                break;
            case BOTTOM:
            //    velocityY = 0;
              //  positionY = collidable.getY() + collidable.getHeight() + 5;
               // System.out.println("(Bottom) Adjusting Position Y to: " + positionY);
                // break;
            case LEFT:
                // velocityX = 0;
                // positionX = collidable.getX() - getWidth();
                // System.out.println("Adjusting Position X to: " + positionX);
                // break;
            case RIGHT:
                // velocityX = 0;
                // positionX = collidable.getX() + collidable.getWidth();
                // System.out.println("Adjusting Position X to: " + positionX);
                // break;
            case NONE:
                // No action needed
                break;
        }
    }


    public void stopHorizontal() {
        velocityX = 0;
    }



}