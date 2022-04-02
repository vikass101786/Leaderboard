package Service;

import models.Score;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreServiceImpl implements ScoreService{

    Map<String , Integer> scoreMap = new HashMap<>();

    public ScoreServiceImpl(Map<String , Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    @Override
    public String updateScores(List<Score> scoreList) {
        for (Score score : scoreList) {
            updateUserScore(score);
        }
        return "SUCCESS";
    }

    @Override
    public String updateUserScore(Score score) {
        Integer currentScore = scoreMap.putIfAbsent(score.getName() , score.getCurrentScore());

            if (currentScore != null) {
                scoreMap.put(score.getName(), currentScore + score.getCurrentScore());
            }

        return "SUCCESS";
    }


    /*
    * Return top 10 players
    * */

    @Override
    public Map<String , Integer> getLeaderBoard() {

           LinkedHashMap<String , Integer> map =  scoreMap
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (name, score) -> score, LinkedHashMap::new));

           LinkedHashMap<String , Integer> mapToDisplay = new LinkedHashMap<>();

           for(Map.Entry<String , Integer> mapIter : scoreMap.entrySet()) {
               mapToDisplay.put(mapIter.getKey() , mapIter.getValue());
               if (map.size() == 10) {
                   break;
               }
           }

        return mapToDisplay;
    }
}
