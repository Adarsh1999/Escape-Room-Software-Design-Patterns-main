package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Rooms.JailBreak;

/**
 * Example Usage : Room jailbreak = (Room) EagerSingletonJailBreakFactory.getInstance().createRoom();
 */

public class EagerSingletonJailBreakFactory extends RoomFactory{
    private static EagerSingletonJailBreakFactory instance = new EagerSingletonJailBreakFactory();

    private EagerSingletonJailBreakFactory() {
        // private constructor to prevent instantiation
    }

    public static EagerSingletonJailBreakFactory getInstance() {
        return instance;
    }

    @Override
    public Room createRoom() {
        return new JailBreak.JailBreakBuilder().build();
    }
    
}
