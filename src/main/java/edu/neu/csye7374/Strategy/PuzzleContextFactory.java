package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;

public interface PuzzleContextFactory {

    public PuzzleContextStrategy assignPuzzleStrategy(PuzzleStrategy puzzleStrategy);
}
