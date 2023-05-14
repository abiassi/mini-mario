package utils;

import utils.Collidable;

public class CollisionDetector {

    public enum CollisionSide {
        NONE, LEFT, RIGHT, TOP, BOTTOM
    }

    public static boolean hasCollided(Collidable c1, Collidable c2) {
        return (c1.getX() + c1.getWidth()) >= (c2.getX()+1) &&
                c1.getX() <= (c2.getX() + c2.getWidth()-1) &&
                (c1.getY() + (c1.getHeight()) >= c2.getY()+1) &&
                c1.getY() <= (c2.getY() + c2.getHeight()-1);
    }
}