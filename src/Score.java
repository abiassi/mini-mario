import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private int score;
    private Text text;

    public Score(double x, double y, int score){
        this.score = score;
        text = new Text(x, y, String.valueOf(score));
        text.draw();
    }

    public int getScore() {
        return score;
    }


    //if coin is collided or if enemy is killed
    public int collect(){
        return score + 100;
    }


    //if player dies before concluding level, return to initial score
    public boolean playerDead(){
        return score == 0;
    }


    //if player concludes level, increase score by 400
    public int levelConcluded(){
        return score + 400;
    }
}
