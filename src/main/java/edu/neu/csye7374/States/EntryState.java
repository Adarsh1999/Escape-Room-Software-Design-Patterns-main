package edu.neu.csye7374.States;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.Models.User;

public class EntryState implements PlayerStateAPI {
//    const
//      user instance pass in teh constructor
//
    private final User user;

        public EntryState(User user) {
            this.user = user;
        }

        public void EntryStateOn() {
            System.out.println("Already in the Entry State ***************************");
        }

        public void BeginnerStateOn() {
//        Allowed operations from Entry state to Beginner state
           System.out.println("Moving to the Beginner State ***************************");
           user.setState(user.getBeginnerState());
        }

        public void IntermediateStateOn() {
//        Not allowable operations from this state i.e EntryState -> IntermediateState
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Intermediate State without successfully passing the Beginner State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }

        public void AdvancedStateOn() {
//        Not allowable operations from this state i.e EntryState -> AdvancedState
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ERROR: Can't escape to the Advanced State without successfully passing the Beginner State XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        }

        public void ExitStateOn() {
            System.out.println("Changing to the Exit State ***************************");
            user.setState(user.getExitState());
        }

        public void displayState() {
            System.out.println("****************************** Current State is the Entry State ***************************");
            System.out.println("This is an initial state of the user in the Escape room game to enter the credentials***************************");
        }

}