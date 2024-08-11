package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;


public interface OneWordPuzzleFactory {

    public PuzzleStrategy createPuzzle(String question, String answer,String hint);
}
