// Character.java
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Character {
    private int x;
    private int y;
    private Picture picture;

    public Character(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.picture = new Picture(x, y, imagePath);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        picture.translate(dx, dy);
    }

    public void render() {
        picture.draw();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
