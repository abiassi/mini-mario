import TileMapCreator.CSVParser;
import TileMapCreator.TileMap;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Main implements KeyboardHandler {
    private static TileMap tileMap;
    private static Character character;

    public static void main(String[] args) {
        Main main = new Main();

        // Load the level
        tileMap = CSVParser.parse("src/Tests/Resources/level1.csv");
        if (tileMap != null) {
            tileMap.init();
        }

        // Create the character
        character = new Character(32, 32, "img/mario_01.png");
        character.render();

        // Set up keyboard input
        main.setUpKeyboard();

        // Main game loop
        while (true) {
            tileMap.updateCamera(character.getX(), character.getY(), tileMap.getWidth() * tileMap.getCellSize(), tileMap.getHeight() * tileMap.getCellSize());
            tileMap.render();

            try {
                Thread.sleep(16); // To limit the frame rate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setUpKeyboard() {
        Keyboard k = new Keyboard(this);

        // Set up left arrow key event
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        // Set up right arrow key event
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (character.getX() > 0) {
                    character.move(-4, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (character.getX() < (tileMap.getWidth() * tileMap.getCellSize()) - tileMap.getCellSize()) {
                    character.move(4, 0);
                }
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // Not used in this example
    }
}
