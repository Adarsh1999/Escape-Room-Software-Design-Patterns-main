package edu.neu.csye7374.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.APIs.HintCommandAPI;
import edu.neu.csye7374.APIs.HintInvokerAPI;
import edu.neu.csye7374.APIs.HintReceiverAPI;
import edu.neu.csye7374.HintCommand.PuzzleHintCommand;
import edu.neu.csye7374.HintCommand.PuzzleInvoker;
import edu.neu.csye7374.HintCommand.PuzzleReceiver;
import edu.neu.csye7374.PuzzleDecorator.TimedPuzzleDecorator;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

/**
 * In a game there will be multiple rooms
 * Example: Theme xyz requires user to escape 3 rooms
 * Room 1 -> Room 2 -> Room 3 -> Escape (in that order)
 * 
 * Abstract class to represent a room
 */

/**
 * Code Implementattion Reference:
 * https://dev.to/karthikrg/implementing-builder-pattern-abstract-class-3c1l
 */

public abstract class Room {
    private int id;
    private String name; // name of the room
    private String description; // description of the room
    private List<PuzzleContextStrategy> puzzles; // puzzles in the room
    private PuzzleContextStrategy exitPuzzle; // id of the puzzle that will lead to the next room // null if no next
                                              // room
    private String ThemeName; // Theme selected by the user in the Entry State

    public Room(RoomBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.puzzles = builder.puzzles;
        this.exitPuzzle = builder.exitPuzzle;
        this.ThemeName = builder.themeName;
    }

    /**
     * Getters
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<PuzzleContextStrategy> getPuzzles() {
        return puzzles;
    }

    public PuzzleContextStrategy getExitPuzzle() {
        return exitPuzzle;
    }

    public PuzzleContextStrategy removePuzzle(int index) {
        return puzzles.remove(index);
    }

    public void displayPuzzles(Map<Integer, PuzzleContextStrategy> puzzlesMap) {
        for (Map.Entry<Integer, PuzzleContextStrategy> entry : puzzlesMap.entrySet()) {
            System.out.print("Puzzle " + entry.getKey() + ". ");
            entry.getValue().display();
            System.out.println();
        }
    }

    /**
     * Get the user aquainted with the room
     */
    public void enterRoom(UserProfile user, String themeName) {
        this.ThemeName = themeName;
        System.out.println("Welcome :" + user);
        System.out.println("Looks like you have entered the " + this.getName() + "!");
        System.out.println("The choosen theme of the room is " + this.ThemeName + " Theme!");
        System.out.println("About this room: " + this.getDescription());
        System.out.println("Now, you'll be displayed a list of puzzles.");
        System.out.println(
                "You can solve them in any order, but you don't need to solve all of them to escape the room.");
        System.out.println("Press 1 to start solving the puzzles.");
        int choice = 0;

        // Start the timer once the user confirms the instructions
        do {
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
            // Call playRoom() method
        } while (choice != 1);

        playRoom();
    }

    public void playRoom() {
        Map<Integer, PuzzleContextStrategy> puzzlesMap = createPuzzlesMap();

        while (!puzzlesMap.isEmpty()) {
            System.out.println("===========================================");
            System.out.println("Puzzles remaining in this room: " + puzzlesMap.size());
            displayPuzzles(puzzlesMap);
            System.out.println("===========================================");
            int puzzleNumber = readPuzzleNumber();

            if (puzzlesMap.containsKey(puzzleNumber)) {
                solvePuzzle(puzzleNumber, puzzlesMap);
            } else {
                System.out.println("Invalid puzzle number. Please try again.");
            }
        }

        exitRoom();
    }

    private Map<Integer, PuzzleContextStrategy> createPuzzlesMap() {
        Map<Integer, PuzzleContextStrategy> puzzlesMap = new HashMap<>();
        for (int i = 0; i < puzzles.size(); i++) {
            puzzlesMap.put(i + 1, puzzles.get(i));
        }
        return puzzlesMap;
    }

    private int readPuzzleNumber() {
        System.out.println("Enter the puzzle number you want to solve: ");
        int puzzleNumber = 0;
        try {
            puzzleNumber = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return puzzleNumber;
    }

    private void solvePuzzle(int puzzleNumber, Map<Integer, PuzzleContextStrategy> puzzlesMap) {

        PuzzleContextStrategy puzzle = puzzlesMap.get(puzzleNumber);
        if (puzzle.getPuzzleStrategy() instanceof TimedPuzzleDecorator) {
            System.out.println("This puzzle will be timed one. Buck up!!");
            TimedPuzzleDecorator t = (TimedPuzzleDecorator) puzzle.getPuzzleStrategy();
            t.startTimer();
        }
        System.out.println("Enter your answer for puzzle number " + puzzleNumber + ": ");
        String answer = System.console().readLine();

        if (puzzle.solve(answer)) {
            System.out.println("Correct answer!");
            System.out.println("===========================================");
            puzzlesMap.remove(puzzleNumber);

            if (puzzle == exitPuzzle) {
                // the room has been solved
                puzzlesMap.clear();
            }
        }

        else if (answer != "") {

            System.out.println("Wrong answer! Try again.");
            System.out.println("===========================================");
            HintReceiverAPI hintReceiver = new PuzzleReceiver();
            HintCommandAPI hintCommand = new PuzzleHintCommand(hintReceiver, puzzle);
            HintInvokerAPI hintInvoker = new PuzzleInvoker(hintCommand);
            hintInvoker.invoke();
        }
    }

    abstract public void exitRoom();

    /**
     * Since room requires too many parameters, we are using builder pattern to
     * create a room
     */
    public abstract static class RoomBuilder {
        int id;
        String name;
        String description;
        List<PuzzleContextStrategy> puzzles;
        PuzzleContextStrategy exitPuzzle = null; // default value
        String themeName = "";

        public RoomBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public RoomBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RoomBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public RoomBuilder setPuzzles(List<PuzzleContextStrategy> puzzles) {
            this.puzzles = puzzles;
            return this;
        }

        public RoomBuilder setExitPuzzle(PuzzleContextStrategy puzzle) {
            this.exitPuzzle = puzzle;
            return this;
        }

        public RoomBuilder setThemeName(String themeName) {
            this.themeName = themeName;
            return this;
        }

        public abstract Room build();
    }

}