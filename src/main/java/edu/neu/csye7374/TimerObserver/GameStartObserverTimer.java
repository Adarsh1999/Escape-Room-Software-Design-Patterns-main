package edu.neu.csye7374.TimerObserver;

public class GameStartObserverTimer implements ObserverTimerAPI {


    @Override
    public void onTimerStart() {
        System.out.println("Game timer has started. Good luck!");
    }

    @Override
    public void onTimerEnd() {

    }
}
