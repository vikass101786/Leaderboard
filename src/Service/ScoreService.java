package Service;

import models.Score;

import java.util.List;
import java.util.Map;

public interface ScoreService {

    public String updateScores(List<Score> scoreList);
    public String updateUserScore(Score score);
    public Map<String , Integer> getLeaderBoard();

}
