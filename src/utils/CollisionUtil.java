package utils;

import Character.Person;
import utils.Collidable;

public class CollisionUtil {
    public static boolean isHitFromBelow(Person person, Collidable tile) {
        return person.getY() <= tile.getY() + tile.getHeight() && person.getVelocityY() < 0;
    }
}
