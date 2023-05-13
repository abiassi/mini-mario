import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import Character.Person;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void init() {
        keyboard = new Keyboard(this);

        int[] keys = {
                KeyboardEvent.KEY_A,
                KeyboardEvent.KEY_W, //this is only for testing
                KeyboardEvent.KEY_D,
                KeyboardEvent.KEY_SPACE
        };

        for (int i = 0; i < keys.length; i++) {
            System.out.println("key was pressed");
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            event.setKey(keys[i]);
            keyboard.addEventListener(event);

            KeyboardEvent eventReleased = new KeyboardEvent();
            eventReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            eventReleased.setKey(keys[i]);
            keyboard.addEventListener(eventReleased);

        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                person.moveLeft();
                break;
            case KeyboardEvent.KEY_W:
                person.moveUp();
                break;
            case KeyboardEvent.KEY_D:
                person.moveRight();
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                person.stopHorizontal();
                break;
            case KeyboardEvent.KEY_D:
                person.stopHorizontal();
                break;
        }
    }
}