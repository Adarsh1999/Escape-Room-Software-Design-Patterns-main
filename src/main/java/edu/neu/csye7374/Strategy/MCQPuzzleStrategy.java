package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;

import java.util.List;

public class MCQPuzzleStrategy implements PuzzleStrategy {
    String question;
    List<String> options;
    int correctOption;
    String hint;

    public MCQPuzzleStrategy(String question, List<String> options, int correctOption, String hint) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.hint= hint;
    }
    @Override
    public boolean solve(String answer) {
        try {
            int option = Integer.parseInt(answer);
            return option == correctOption;
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid option number!");
            return false;
        }
    }


    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String showHint() {
        return hint;
    }

    @Override
    public void display() {
        System.out.println("Question: " + this.question);
       
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

    }
}

