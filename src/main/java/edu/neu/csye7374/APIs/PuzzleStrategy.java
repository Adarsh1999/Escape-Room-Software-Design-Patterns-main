package edu.neu.csye7374.APIs;

public interface PuzzleStrategy {
    boolean solve(String answer);
    public void display();

    public String showHint();
}
