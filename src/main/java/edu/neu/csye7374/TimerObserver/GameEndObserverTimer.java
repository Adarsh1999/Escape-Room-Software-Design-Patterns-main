package edu.neu.csye7374.TimerObserver;

public class GameEndObserverTimer implements  ObserverTimerAPI{


    @Override
    public void onTimerEnd() {
        System.out.println("Game timer has ended. Game over.");
    }
    @Override
    public void onTimerStart() {

    }


}
