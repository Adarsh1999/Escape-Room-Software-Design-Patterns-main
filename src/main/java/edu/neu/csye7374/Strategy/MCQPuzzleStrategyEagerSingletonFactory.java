package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;

import java.util.List;

public class MCQPuzzleStrategyEagerSingletonFactory implements MCQPuzzleFactory{

    private static  MCQPuzzleStrategyEagerSingletonFactory instance= new MCQPuzzleStrategyEagerSingletonFactory();


    private MCQPuzzleStrategyEagerSingletonFactory(){

    }

    public static MCQPuzzleStrategyEagerSingletonFactory getInstance(){
        return  instance;
    }

    @Override
    public PuzzleStrategy createPuzzle(String question, List<String> options, int correctOption,String hint) {
        return new MCQPuzzleStrategy(question, options, correctOption, hint);
    }
}
