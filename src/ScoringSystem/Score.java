package ScoringSystem;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {

    private static int score = 0;
    private static Text text;

    public Score(double x, double y, int score){
        this.score = score;
        text = new Text(x, y, "SCORE: " + String.valueOf(score));
        text.setColor(org.academiadecodigo.simplegraphics.graphics.Color.WHITE);
        text.draw();
    }

    public static int getScore() {
        return score;
    }

    //if coin is collided or if enemy is killed
    public static int increaseScore(){
        updateScoreDisplay();
        return score += 200;
    }


    public static void updateScoreDisplay() {
        text.setText("SCORE: " + String.valueOf(score));
    }

    public boolean playerDead(){
        return score == 0;
    }

    public int levelConcluded(){
        return score += 400;
    }




}