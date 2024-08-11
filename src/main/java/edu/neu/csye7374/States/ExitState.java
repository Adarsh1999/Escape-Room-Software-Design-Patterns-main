package edu.neu.csye7374.States;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.Models.User;

public class ExitState implements PlayerStateAPI {

    private final User user;

    public ExitState(User user) {
        this.user = user;
    }

    public void EntryStateOn() {
//        Not allowable operations from this state i.e ExitState -> EntryState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Entry State from Exit State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void BeginnerStateOn() {
//        Not allowable operations from this state i.e ExitState -> BeginnerState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Beginner State from Exit State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void IntermediateStateOn() {
//        Not allowable operations from this state i.e ExitState -> IntermediateState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Intermediate State from Exit State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void AdvancedStateOn() {
//        Not allowable operations from this state i.e ExitState -> AdvancedState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Advanced State from Exit State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void ExitStateOn() {
        System.out.println("Already in the Advanced State ***************************");
    }

    public void displayState() {
        System.out.println("****************************** Current State is the Exit State ***************************");
        System.out.println("This is an exit state of the user in the Escape room game. The user exits the game in this state ***************************");
    }


}