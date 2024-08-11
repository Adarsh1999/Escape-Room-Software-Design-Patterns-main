package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;

import java.util.List;

public interface MCQPuzzleFactory {

public PuzzleStrategy createPuzzle(String question, List<String> options, int correctOption,String hint);
}
