package controller;

import Service.ScoreService;
import Service.ScoreServiceImpl;
import models.Board;
import models.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ScoreProvideController {

     static List<String> nameList = Arrays.asList("A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M", "N", "O", "P", "Q", "R" , "S", "T");

    public static void main(String[] args) {
        Board board = new Board();
        ScoreService scoreService = new ScoreServiceImpl(board.getLeaderBoardMap());
        ScoreController scoreController = new ScoreController(scoreService);

        List<Score> scoreList = new ArrayList<>();

        scoreList.add(new Score("A" , 100));
        scoreList.add(new Score("B" , 80));
        scoreList.add(new Score("C" , 90));
        scoreList.add(new Score("D" , 95));
        scoreList.add(new Score("E" , 180));
        scoreList.add(new Score("F" , 20));
        scoreList.add(new Score("G" , 30));
        scoreList.add(new Score("H" , 40));
        scoreList.add(new Score("I" , 110));
        scoreController.updateScores(scoreList);

        while (true) {
            CompletableFuture.runAsync(() -> {
                scoreController.updateIndividualScore(new Score(nameList.get((int)(Math.random() * 50 % nameList.size())) ,
                        (int)(Math.random()*97)));
            }, Executors.newFixedThreadPool(5));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(scoreController.getLeaderBoard());
        }
    }

}
