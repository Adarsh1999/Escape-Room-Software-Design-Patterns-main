package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Rooms.UnderwaterAdventure;

public class EagerSingletonUnderwaterAdventure extends RoomFactory{
    
    private static EagerSingletonUnderwaterAdventure instance = new EagerSingletonUnderwaterAdventure();

    private EagerSingletonUnderwaterAdventure() {
        // private constructor to prevent instantiation
    }

    public static EagerSingletonUnderwaterAdventure getInstance() {
        return instance;
    }

    @Override
    public Room createRoom() {
        return new UnderwaterAdventure.UnderwaterAdventureBuilder().build();
    }
}
