package edu.neu.csye7374.Models;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.TimerObserver.GameEndObserverTimer;
import edu.neu.csye7374.TimerObserver.GameObservableTimer;
import edu.neu.csye7374.TimerObserver.GameStartObserverTimer;
import edu.neu.csye7374.TimerObserver.ObservableTimerAPI;
import edu.neu.csye7374.TimerObserver.ObserverTimerAPI;

public abstract class Theme {
    private String themeName;
    protected List<String> instructions;
    private List<Room> rooms; //the rooms are in order, so we can use this to load the rooms in order
    private User user; //the user who is playing the game

    public Theme(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public abstract void createTheme();

    public abstract void loadRooms();

    public abstract void loadInstructions();

    public void provideInstructions() {
        System.out.println("Instructions for " + themeName + " theme:");
        for (String instruction : instructions) {
            System.out.println("- " + instruction);
        }
    }

    public void exitTheme() {
        System.out.println("Congratulations! You've solved the room, Exiting " + themeName + " theme");
        System.exit(0);
    }
    
    public static void startUserClock() {
        ObservableTimerAPI gameTimer = new GameObservableTimer();
        ObserverTimerAPI startGameObserver= new GameStartObserverTimer();
        ObserverTimerAPI endGameObserver= new GameEndObserverTimer();
        gameTimer.addObserver(startGameObserver);
        gameTimer.addObserver(endGameObserver);
        gameTimer.startTimer(600);//10 minutes
     }
    //start the game
    public void start() {
        //push two states onto the stack
        Queue<PlayerStateAPI> queue = new LinkedList<>();
        queue.add(user.getBeginnerState());
        queue.add(user.getIntermediateState());
        queue.add(user.getAdvancedState());
        queue.add(user.getExitState());

        //start the clock
        startUserClock();
        while (rooms.size() > 0) {
            user.setState(queue.remove());
            //display the state
            user.displayState();
            Room room = rooms.remove(0);
            room.enterRoom(user.getUserProfile(), getThemeName()); // Passing the choosen theme to implement bridge pattern
        }
        user.setState(queue.remove());
        user.displayState();
    }
    
    //template method
    public void play() {
        createTheme();
        loadInstructions();
        loadRooms();
        provideInstructions();
        start();
        exitTheme();
    }
}




