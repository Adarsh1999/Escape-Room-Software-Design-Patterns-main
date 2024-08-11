package edu.neu.csye7374.APIs;

/**
 * In this game there will be 3 rooms
 * The user has to go through different states to transition from different rooms and also to enter and exit the game.
 * The transition of states is as follows:
 * Entry -> Beginner(Room1) -> Intermediate(Room2) -> Advanced(Room3) -> Exit
 * Implemented State design Pattern for state transition of the user
 * Implemented an API for the various states of the player
 */

public interface PlayerStateAPI {
    void EntryStateOn();
    void BeginnerStateOn();
    void IntermediateStateOn();
    void AdvancedStateOn();
    void ExitStateOn();

    void displayState();
}
