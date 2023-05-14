package utils;

import GameCharacter.GameCharacter;

public class CollisionUtil {
    public static boolean isHitFromBelow(GameCharacter person, Collidable tile) {
        return person.getY() <= tile.getY() + tile.getHeight() && person.getVelocityY() < 0;
    }
}
