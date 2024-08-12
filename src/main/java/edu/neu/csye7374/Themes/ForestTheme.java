package edu.neu.csye7374.Themes;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Models.Theme;
import edu.neu.csye7374.Models.User;
import edu.neu.csye7374.Rooms.ForestEscape;


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
        ForestEscape forestescape = (ForestEscape) new ForestEscape.ForestEscapeBuilder().build();
//        HauntedMansion hauntedMansion = (HauntedMansion) new HauntedMansion.HauntedMansionBuilder().build();
//        UnderwaterAdventure underwaterAdventure = (UnderwaterAdventure) new UnderwaterAdventure.UnderwaterAdventureBuilder().build();
//        rooms.add(hauntedMansion);
//        rooms.add(jailbreak);


        rooms.add(forestescape);
        setRooms(rooms);
    }

    @Override
    public void loadInstructions() {
        List<String> instructions = new ArrayList<>();
        instructions.add("You are a lost traveler who wandered too deep into the heart of an enchanted forest. The only way out is to solve the ancient mysteries hidden within.");
        instructions.add("The forest is alive with secrets, and the trees whisper of long-forgotten knowledge. Your survival depends on your ability to understand the language of nature.");
        instructions.add("You find yourself surrounded by towering trees and a dense canopy. To escape, you must navigate through the forest and solve the puzzles left by those who came before you.");
        instructions.add("Every step you take brings you closer to freedom, but beware, the forest doesn't easily reveal its secrets. Only the wise will find their way out.");

        setInstructions(instructions);
    }
    
}
