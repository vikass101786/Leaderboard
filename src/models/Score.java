package models;

public class Score {
    String name;
    Integer currentScore;

    public Score(String name , Integer currentScore) {
        this.name = name;
        this.currentScore = currentScore;
    }

    public String getName() {
        return name;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }


}
