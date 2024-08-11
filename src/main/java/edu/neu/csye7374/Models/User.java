package edu.neu.csye7374.Models;

import edu.neu.csye7374.APIs.PlayerStateAPI;
import edu.neu.csye7374.States.AdvancedState;
import edu.neu.csye7374.States.BeginnerState;
import edu.neu.csye7374.States.EntryState;
import edu.neu.csye7374.States.ExitState;
import edu.neu.csye7374.States.IntermediateState;

//Store the user details
//maintain the states of the user
public class User implements PlayerStateAPI{
    UserProfile userProfile;
    private PlayerStateAPI entryState;
    private PlayerStateAPI beginnerState;
    private PlayerStateAPI intermediateState;
    private PlayerStateAPI advancedState;
    private PlayerStateAPI exitState;
    private PlayerStateAPI state;

    public User(UserProfile userProfile) {
        //clone the user profile
        this.userProfile = userProfile.clone();
        this.entryState = new EntryState(this);
        this.beginnerState = new BeginnerState(this);
        this.intermediateState = new IntermediateState(this);
        this.advancedState = new AdvancedState(this);
        this.exitState = new ExitState(this);
        this.state = new EntryState(this); //initial state
    }

    public UserProfile getUserProfile() {
       return this.userProfile;
    }

    //getter for all the state
    public PlayerStateAPI getEntryState() {
        return entryState;
    }

    public PlayerStateAPI getBeginnerState() {
        return beginnerState;
    }

    public PlayerStateAPI getIntermediateState() {
        return intermediateState;
    }

    public PlayerStateAPI getAdvancedState() {
        return advancedState;
    }

    public PlayerStateAPI getExitState() {
        return exitState;
    }

    public void setState(PlayerStateAPI state) {
        this.state = state;
    }

    @Override
    public void EntryStateOn() {
       this.state.EntryStateOn();
    }

    @Override
    public void BeginnerStateOn() {
        this.state.BeginnerStateOn();
    }

    @Override
    public void IntermediateStateOn() {
        this.state.IntermediateStateOn();
    }

    @Override
    public void AdvancedStateOn() {
        this.state.AdvancedStateOn();
    }

    @Override
    public void ExitStateOn() {
        this.state.ExitStateOn();
    }

    @Override
    public void displayState() {
       this.state.displayState();
    }

}
