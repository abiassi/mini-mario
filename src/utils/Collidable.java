package utils;
import GameCharacter.GameCharacter;

public interface Collidable {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void onCollision(GameCharacter person);
}
