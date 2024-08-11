package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Rooms.HauntedMansion;

public class EagerSingletonHauntedMansion extends RoomFactory{
    private static EagerSingletonHauntedMansion instance = new EagerSingletonHauntedMansion();

    private EagerSingletonHauntedMansion() {
        // private constructor to prevent instantiation
    }

    public static EagerSingletonHauntedMansion getInstance() {
        return instance;
    }

    @Override
    public Room createRoom() {
        return new HauntedMansion.HauntedMansionBuilder().build();
    }
}
