package edu.neu.csye7374.States;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.Models.User;

public class AdvancedState implements PlayerStateAPI {

    private final User user;

    public AdvancedState(User user) {
        this.user = user;
    }

    public void EntryStateOn() {
//        Not allowable operations from this state i.e AdvancedState -> EntryState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Entry State from Advanced State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void BeginnerStateOn() {
//        Not allowable operations from this state i.e AdvancedState -> BeginnerState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Beginner State from Advanced State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void IntermediateStateOn() {
//        Not allowable operations from this state i.e AdvancedState -> IntermediateState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Intermediate State from Advanced State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void AdvancedStateOn() {
        System.out.println("Already in the Advanced State ***************************");
    }

    public void ExitStateOn() {
        user.setState(user.getExitState());
        System.out.println("Ending with the ExitState ***************************");
        System.out.println("Hope you had fun playing the escape game ***************************");
    }

    public void displayState() {
        System.out.println("****************************** Current State is the Advanced State ***************************");
        System.out.println("This is an last state of the user in the Escape room game. The user enters the final room in this state ***************************");
        System.out.println("Allowed operations are: Advanced State to Exit State***************************");

    }

}