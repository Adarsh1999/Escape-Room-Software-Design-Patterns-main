package edu.neu.csye7374.TimerObserver;

public interface ObservableTimerAPI {
    public void addObserver(ObserverTimerAPI observer);
    public void removeObserver(ObserverTimerAPI observer);
    public void notifyObserversOnTimerStart();
    public void notifyObserversOnTimerEnd();

    public void startTimer(int duration);

}
