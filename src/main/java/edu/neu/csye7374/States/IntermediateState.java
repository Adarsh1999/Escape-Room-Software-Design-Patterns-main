package edu.neu.csye7374.States;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.Models.User;

public class IntermediateState implements PlayerStateAPI{

    private final User user;

    public IntermediateState(User user) {
        this.user = user;
    }

    public void EntryStateOn() {
//        Not allowable operations from this state i.e IntermediateState -> EntryState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Entry State from Intermediate State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void BeginnerStateOn() {
//        Not allowable operations from this state i.e IntermediateState -> BeginnerState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Beginner State from Intermediate State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void IntermediateStateOn() {
        System.out.println("Already in the Intermediate State ***************************");
    }

    public void AdvancedStateOn() {
        user.setState(user.getAdvancedState());
        System.out.println("Moving with the Advanced Room ***************************");
    }

    public void ExitStateOn() {
//        Not allowable operations from this state i.e IntermediateState -> ExitState
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Exit State without successfully passing the Advanced State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    public void displayState() {
        System.out.println("****************************** Current State is the Intermediate State ***************************");
        System.out.println("This is an second state of the user in the Escape room game. The user enters the second room in this state ***************************");
        System.out.println("Allowed operations are: Intermediate state to Advanced State***************************");
    }

}