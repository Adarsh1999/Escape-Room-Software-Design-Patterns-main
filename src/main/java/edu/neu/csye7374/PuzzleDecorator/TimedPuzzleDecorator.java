package edu.neu.csye7374.PuzzleDecorator;

import edu.neu.csye7374.APIs.PuzzleStrategy;

public class TimedPuzzleDecorator implements PuzzleStrategy{


    private PuzzleStrategy wrappedPuzzle;
    private int timeLimitInSeconds;


    public TimedPuzzleDecorator(PuzzleStrategy wrappedPuzzle, int timeLimitInSeconds) {
        this.wrappedPuzzle = wrappedPuzzle;
        this.timeLimitInSeconds = timeLimitInSeconds;
    }

    @Override
    public boolean solve(String answer) {
       return wrappedPuzzle.solve(answer);
        
    }  
    public void startTimer() {
        System.out.println("Timer has started!!!!");
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(timeLimitInSeconds * 1000);
                System.out.println("Time's up! Please try again.");
                
            } catch (InterruptedException e) {
                // Timer interrupted if user answers before time's up
            }
        });
        timerThread.start();
    }

    @Override
    public void display() {
        wrappedPuzzle.display();
        
    }

    @Override
    public String showHint() {
        return wrappedPuzzle.showHint();
    }   
   
    
}
