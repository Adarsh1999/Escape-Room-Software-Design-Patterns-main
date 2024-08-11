package edu.neu.csye7374.TimerObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameObservableTimer implements  ObservableTimerAPI{

    List<ObserverTimerAPI> observerList = new ArrayList<>();
    private Timer timer;
    @Override
    public void addObserver(ObserverTimerAPI observer) {
                observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverTimerAPI observer) {
        observerList.remove(observer);
    }

    @Override
    public void startTimer(int durationInSeconds) {
    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            notifyObserversOnTimerEnd();
            timer.cancel();
            System.exit(0);
        }
    },durationInSeconds * 1000);

    notifyObserversOnTimerStart();
    }

    @Override
    public void notifyObserversOnTimerStart() {

        for (ObserverTimerAPI observers:observerList){
            observers.onTimerStart();
        }
    }

    @Override
    public void notifyObserversOnTimerEnd() {
        for (ObserverTimerAPI observers:observerList){
            observers.onTimerEnd();
        }
    }


}
