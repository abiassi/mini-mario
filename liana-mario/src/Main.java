import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Canvas.setMaxX(600);
        Canvas.setMaxY(240);
Game game = new Game(35, 50);
game.init();
game.start();
    }
}