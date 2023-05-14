package utils;

import Character.Person;

public interface Collidable {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void onCollision(Person person);
}
