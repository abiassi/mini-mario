package utils;

import utils.Collidable;

public class CollisionDetector {

    public enum CollisionSide {
        NONE, LEFT, RIGHT, TOP, BOTTOM
    }

    public static CollisionSide detectCollisionSide(Collidable c1, Collidable c2) {
        if (!hasCollided(c1, c2)) {
            return CollisionSide.NONE;
        }

        double left = c2.getX() + c2.getWidth() - c1.getX();
        double right = c1.getX() + c1.getWidth() - c2.getX();
        double top = c2.getY() + c2.getHeight() - c1.getY();
        double bottom = c1.getY() + c1.getHeight() - c2.getY();

        double min = Math.min(Math.min(left, right), Math.min(top, bottom));

        if (min == left) return CollisionSide.LEFT;
        if (min == right) return CollisionSide.RIGHT;
        if (min == top) return CollisionSide.TOP;
        if (min == bottom) return CollisionSide.BOTTOM;

        // Fallback: if no side is determined, return none.
        return CollisionSide.NONE;
    }


    public static boolean hasCollided(Collidable c1, Collidable c2) {
        return (c1.getX() + c1.getWidth()) >= c2.getX() &&
                c1.getX() <= (c2.getX() + c2.getWidth()) &&
                (c1.getY() + c1.getHeight()) >= c2.getY() &&
                c1.getY() <= (c2.getY() + c2.getHeight());
    }
}