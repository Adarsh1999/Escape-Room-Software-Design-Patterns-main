package edu.neu.csye7374.Rooms;

import java.util.ArrayList;
import java.util.List;
import edu.neu.csye7374.APIs.PuzzleStrategy;
import edu.neu.csye7374.Models.Room;
import edu.neu.csye7374.PuzzleDecorator.TimedPuzzleDecorator;
import edu.neu.csye7374.Strategy.MCQPuzzleStrategy;
import edu.neu.csye7374.Strategy.OneWordPuzzleStrategy;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

/**
 * ForestEscape room
 * A more challenging nature-themed escape adventure
 */

/**
 * Creating a ForestEscape room - ForestEscape forestEscape = (ForestEscape) new
 * ForestEscape.ForestEscapeBuilder().build();
 */
public class ForestEscape extends Room {

    public ForestEscape(RoomBuilder builder) {
        super(builder);
    }

    public static class ForestEscapeBuilder extends Room.RoomBuilder {

        @Override
        public Room build() {
            /**
             * Set the puzzles and exit puzzle here
             */
            PuzzleStrategy firstQuestion = new MCQPuzzleStrategy("Which tree species in the forest is known for its unique ability to survive fires?",
                    List.of("Redwood", "Pine", "Oak", "Birch"), 1, "Redwoods have thick bark and can resist fire damage.");
            PuzzleStrategy secondQuestion = new MCQPuzzleStrategy("You stumble upon a river. How can you determine the river's direction of flow using nature's clues?",
                    List.of("Observe the Moss on Trees", "Check the Wind Direction", "Look for Animal Tracks", "Follow the Sun's Path"), 1, "Moss usually grows on the north side of trees in the Northern Hemisphere, helping you infer direction.");
            PuzzleStrategy finalQuestion = new OneWordPuzzleStrategy("An ancient tree in the center of the forest holds a secret. Solve this riddle: 'I speak without a mouth and hear without ears. I have no body, but I come alive with wind.' What am I?",
                    "Echo", "The answer is 'Echo,' a natural phenomenon you can experience in the forest.");
            PuzzleStrategy timedRiddlePuzzle = new TimedPuzzleDecorator(finalQuestion, 60);

            PuzzleContextStrategy firstPuzzle = new PuzzleContextStrategy(firstQuestion);
            PuzzleContextStrategy secondPuzzle = new PuzzleContextStrategy(secondQuestion);
            PuzzleContextStrategy finalPuzzle = new PuzzleContextStrategy(timedRiddlePuzzle);

            List<PuzzleContextStrategy> puzzleList = new ArrayList<>();
            puzzleList.add(firstPuzzle);
            puzzleList.add(secondPuzzle);
            puzzleList.add(finalPuzzle);

            this.setId(2)
                    .setName("ForestEscape")
                    .setDescription("You find yourself in a mysterious forest. To escape, you must solve the ancient puzzles hidden within nature.")
                    .setPuzzles(puzzleList)
                    .setExitPuzzle(finalPuzzle);

            return new ForestEscape(this);
        }

    }

    @Override
    public void exitRoom() {
        System.out.println("You have successfully solved the mysteries of the forest and found the way out.");
    }
}
