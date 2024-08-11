package edu.neu.csye7374.Rooms;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.APIs.PuzzleStrategy;

import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.Strategy.MCQPuzzleStrategy;
import edu.neu.csye7374.Strategy.OneWordPuzzleStrategy;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

/**
 * Haunted Mansion room
 * A spooky room where players must solve puzzles to escape the ghostly mansion.
 */
public class HauntedMansion extends Room {

    public HauntedMansion(RoomBuilder builder) {
        super(builder);
    }

    public static class HauntedMansionBuilder extends Room.RoomBuilder {

        @Override
        public Room build() {
            /**
             * Set the puzzles and exit puzzle here
             */
            PuzzleStrategy firstQuestion = new MCQPuzzleStrategy(
                "Which of the following is true about binary trees?",
                List.of("Every binary tree is a complete binary tree.", "Every complete binary tree is a full binary tree.", "Every full binary tree is a complete binary tree.", "A full binary tree with n leaves contains 2n - 1 nodes."),
                4,
                "A full binary tree with n leaves contains 2n - 1 nodes."
            );
    
            PuzzleStrategy secondQuestion = new MCQPuzzleStrategy(
                "What is the time complexity of a binary search algorithm?",
                List.of("O(1)", "O(n)", "O(log n)", "O(n log n)"),
                3,
                "The binary search algorithm has a time complexity of O(log n) in the average and worst cases."
            );
    
            PuzzleStrategy finalQuestion = new OneWordPuzzleStrategy(
                "Which design pattern promotes the creation of objects without specifying their exact class",
                "factory",
                "The Factory design pattern allows the creation of objects through a common interface without specifying their concrete class."
            );
            PuzzleContextStrategy firstPuzzle = new PuzzleContextStrategy(firstQuestion);
            PuzzleContextStrategy secondPuzzle = new PuzzleContextStrategy(secondQuestion);
            PuzzleContextStrategy finalPuzzle = new PuzzleContextStrategy(finalQuestion);

            List<PuzzleContextStrategy> puzzleList = new ArrayList<>();
            puzzleList.add(firstPuzzle);
            puzzleList.add(secondPuzzle);
            puzzleList.add(finalPuzzle);

            this.setId(2)
                .setName("HauntedMansion")
                .setDescription("You are trapped in a spooky haunted mansion. Solve the puzzles to escape its ghostly grasp.")
                .setPuzzles(puzzleList)
                .setExitPuzzle(finalPuzzle);

            return new HauntedMansion(this);
        }

    }

    @Override
    public void exitRoom() {
        System.out.println("Congratulations! You've escaped the haunted mansion.");
    }
}

