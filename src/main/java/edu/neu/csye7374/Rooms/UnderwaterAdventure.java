package edu.neu.csye7374.Rooms;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.APIs.PuzzleStrategy;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Strategy.MCQPuzzleStrategy;
import edu.neu.csye7374.Strategy.OneWordPuzzleStrategy;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

/**
 * Underwater Adventure room
 * Dive into an underwater world and solve puzzles to find your way out.
 */
public class UnderwaterAdventure extends Room {

    public UnderwaterAdventure(RoomBuilder builder) {
        super(builder);
    }

    public static class UnderwaterAdventureBuilder extends Room.RoomBuilder {

        @Override
        public Room build() {
            /**
             * Set the puzzles and exit puzzle here
             */
            PuzzleStrategy firstQuestion = new MCQPuzzleStrategy(
                "What is the time complexity of the QuickSort algorithm?",
                List.of("O(1)", "O(n)", "O(log n)", "O(n log n)"),
                4,
                "The QuickSort algorithm has an average and best-case time complexity of O(n log n)."
            );
    
            PuzzleStrategy secondQuestion = new MCQPuzzleStrategy(
                "Which data structure uses First-In-First-Out (FIFO) ordering?",
                List.of("Stack", "Queue", "Tree", "Set"),
                2,
                "A Queue is a data structure that follows First-In-First-Out (FIFO) ordering of elements."
            );
    
            PuzzleStrategy finalQuestion = new OneWordPuzzleStrategy(
                "What design principle suggests that a class should have only one reason to change?",
                "single responsibility",
                "The Single Responsibility Principle (SRP) suggests that a class should have only one reason to change, meaning it should have only one responsibility."
            );
            PuzzleContextStrategy firstPuzzle = new PuzzleContextStrategy(firstQuestion);
            PuzzleContextStrategy secondPuzzle = new PuzzleContextStrategy(secondQuestion);
            PuzzleContextStrategy finalPuzzle = new PuzzleContextStrategy(finalQuestion);

            List<PuzzleContextStrategy> puzzleList = new ArrayList<>();
            puzzleList.add(firstPuzzle);
            puzzleList.add(secondPuzzle);
            puzzleList.add(finalPuzzle);

            this.setId(3)
                .setName("UnderwaterAdventure")
                .setDescription("Dive into an underwater world filled with mysteries. Solve the puzzles to swim your way to freedom.")
                .setPuzzles(puzzleList)
                .setExitPuzzle(finalPuzzle);

            return new UnderwaterAdventure(this);
        }

    }

    @Override
    public void exitRoom() {
        System.out.println("You've successfully emerged from the depths of the underwater adventure.");
    }
}
