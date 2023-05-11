public class Game {
    private static final String PREFIX = "resources/";
    private final int delay;

    private Person person;

    private int score = 0;

    public Game(int delay){ //incomplete
        this.delay = delay;
    }
public void init(){
        Person person = new Person(100,300, PREFIX + "mario.png");
        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPerson(person);

}
}

