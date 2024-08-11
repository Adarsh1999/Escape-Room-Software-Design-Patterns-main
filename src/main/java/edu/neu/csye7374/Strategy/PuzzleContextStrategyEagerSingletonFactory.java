package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.APIs.PuzzleStrategy;


public class PuzzleContextStrategyEagerSingletonFactory implements PuzzleContextFactory{



    private static  PuzzleContextStrategyEagerSingletonFactory instance= new PuzzleContextStrategyEagerSingletonFactory();


    private PuzzleContextStrategyEagerSingletonFactory(){

    }

    public static PuzzleContextStrategyEagerSingletonFactory getInstance(){
        return  instance;
    }

    @Override
    public PuzzleContextStrategy assignPuzzleStrategy(PuzzleStrategy puzzleStrategy) {
        return new PuzzleContextStrategy(puzzleStrategy);
    }
}
