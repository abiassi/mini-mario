public class Score {
    private int score = 0;

    public Score(int score){
        this.score = score;
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
