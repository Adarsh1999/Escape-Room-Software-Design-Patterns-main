package edu.neu.csye7374.States;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.Models.User;

public class BeginnerState implements PlayerStateAPI {

    private final User user;

    public BeginnerState(User user) {
        this.user = user;
    }

    public void EntryStateOn() {
//        Not allowable operations from this state i.e BeginnerState -> EntryState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Entry State from Beginner State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void BeginnerStateOn() {
        System.out.println("Already in the Beginner State ***************************");
    }

    public void IntermediateStateOn() {
        System.out.println("Moving to the Intermediate State ***************************");
        user.setState(user.getIntermediateState());
    }

    public void AdvancedStateOn() {
//        Not allowable operations from this state i.e BeginnerState -> AdvancedState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Advanced State without successfully passing the Beginner State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void ExitStateOn() {
//        Not allowable operations from this state i.e BeginnerState -> ExitState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Exit State without successfully passing the Advanced State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void displayState() {
        System.out.println("****************************** Current State is the Beginner State ***************************");
        System.out.println("This is an beginning state of the user in the Escape room game. The user enters the first room in this state ***************************");
        System.out.println("Allowed operations are: Beginner state to Intermediate state ***************************");

    }

}