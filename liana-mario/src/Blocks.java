import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Blocks implements Collidable {

    private Rectangle rectangle;

    public Blocks (int x, int y, int size){
        rectangle = new Rectangle(x,y,size,size);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();



    }
    @Override
    public int getX() {
        return rectangle.getX();
    }

    @Override
    public int getY() {
        return rectangle.getY();
    }

    @Override
    public int getWidth() {
        return rectangle.getWidth();
    }

    @Override
    public int getHeight() {
        return rectangle.getHeight();
    }
}
