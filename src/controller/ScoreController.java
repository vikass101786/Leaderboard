package controller;

import Service.ScoreService;
import models.Score;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScoreController {

    ScoreService scoreService ;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public String updateScores(List<Score> scoreList) {
        return scoreService.updateScores(scoreList);
    }

    public String updateIndividualScore(Score score) {
        System.out.println(score.getName() + " " + score.getCurrentScore());
        return scoreService.updateUserScore(score);
    }

    public Map<String , Integer> getLeaderBoard() {
        return scoreService.getLeaderBoard();
    }

}
