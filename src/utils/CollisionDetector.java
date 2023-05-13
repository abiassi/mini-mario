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

        boolean left = c1.getX() + c1.getWidth() >= c2.getX();
        boolean right = c1.getX() <= (c2.getX() + c2.getWidth());
        boolean top = c1.getY() + c1.getHeight() >= c2.getY();
        boolean bottom = c1.getY() <= c2.getY() + c2.getHeight();

        if (left) return CollisionSide.LEFT;
        if (right) return CollisionSide.RIGHT;
        if (top) return CollisionSide.TOP;
        if (bottom) return CollisionSide.BOTTOM;

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