package edu.neu.csye7374.Themes;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Models.Theme;
import edu.neu.csye7374.Models.User;
import edu.neu.csye7374.Rooms.HauntedMansion;
import edu.neu.csye7374.Rooms.JailBreak;
import edu.neu.csye7374.Rooms.UnderwaterAdventure;

public class ForestTheme extends Theme{
    
    public ForestTheme(User user) {
        super(user);
    }

    @Override
    public void createTheme() {
        System.out.println("Creating Forest Theme");
        setThemeName("Forest");
    }

    @Override
    public void loadRooms() {
        List<Room> rooms = new ArrayList<>();
        JailBreak jailbreak = (JailBreak) new JailBreak.JailBreakBuilder().build();
        HauntedMansion hauntedMansion = (HauntedMansion) new HauntedMansion.HauntedMansionBuilder().build();
        UnderwaterAdventure underwaterAdventure = (UnderwaterAdventure) new UnderwaterAdventure.UnderwaterAdventureBuilder().build();
        rooms.add(hauntedMansion);
        rooms.add(jailbreak);
        rooms.add(underwaterAdventure);
        setRooms(rooms);
    }

    @Override
    public void loadInstructions() {
        List<String> instructions = new ArrayList<>();
        instructions.add("You are a programmer who has been arrested for writing bad code. You must escape the jail and get back to your computer to fix your code before it's too late!");
        instructions.add("You are in a jail cell. You need to escape the jail cell to enter the next room.");
        setInstructions(instructions);
    }
    
}
