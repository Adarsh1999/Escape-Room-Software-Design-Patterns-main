package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;

public class PuzzleContextStrategy {

private PuzzleStrategy puzzleStrategy;


public PuzzleContextStrategy(PuzzleStrategy puzzleStrategy){
    this.puzzleStrategy = puzzleStrategy;
}

public void display(){
    puzzleStrategy.display();
}

public boolean solve(String answer){
    return puzzleStrategy.solve(answer);
}

public void showHint(){
    System.out.println(puzzleStrategy.showHint());
}

public PuzzleStrategy getPuzzleStrategy() {
        return puzzleStrategy;
    }
}
