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
 * MountainAscent room
 * A challenging nature-themed adventure set on a towering mountain.
 */

/**
 * Creating a MountainAscent room - MountainAscent mountainAscent = (MountainAscent) new
 * MountainAscent.MountainAscentBuilder().build();
 */
public class MountainAscent extends Room {

    public MountainAscent(RoomBuilder builder) {
        super(builder);
    }

    public static class MountainAscentBuilder extends Room.RoomBuilder {

        @Override
        public Room build() {
            /**
             * Set the puzzles and exit puzzle here
             */
            PuzzleStrategy firstQuestion = new MCQPuzzleStrategy("As you begin your ascent, you notice clouds gathering. What type of cloud formation typically indicates an approaching storm?",
                    List.of("Cumulonimbus", "Cirrus", "Stratus", "Cumulus"), 1, "Cumulonimbus clouds are often associated with thunderstorms and severe weather.");
            PuzzleStrategy secondQuestion = new MCQPuzzleStrategy("Halfway up the mountain, you come across a fork in the path. One path is covered in loose gravel, while the other is steep and rocky. Which is the safer path to take?",
                    List.of("Loose Gravel", "Steep and Rocky", "Neither", "Both are Safe"), 2, "A steep and rocky path, while challenging, provides better footing than loose gravel, which can cause slips and falls.");
            PuzzleStrategy finalQuestion = new OneWordPuzzleStrategy("Near the summit, you face one last challenge. A riddle is carved into the rock: 'I can be cracked, made, told, and played. What am I?'",
                    "Joke", "The answer is 'Joke,' something that can be cracked, made, told, and played.");
            PuzzleStrategy timedRiddlePuzzle = new TimedPuzzleDecorator(finalQuestion, 45);

            PuzzleContextStrategy firstPuzzle = new PuzzleContextStrategy(firstQuestion);
            PuzzleContextStrategy secondPuzzle = new PuzzleContextStrategy(secondQuestion);
            PuzzleContextStrategy finalPuzzle = new PuzzleContextStrategy(timedRiddlePuzzle);

            List<PuzzleContextStrategy> puzzleList = new ArrayList<>();
            puzzleList.add(firstPuzzle);
            puzzleList.add(secondPuzzle);
            puzzleList.add(finalPuzzle);

            this.setId(3)
                    .setName("MountainAscent")
                    .setDescription("You stand at the base of a towering mountain. To reach the summit and unlock its secrets, you must overcome nature's challenges.")
                    .setPuzzles(puzzleList)
                    .setExitPuzzle(finalPuzzle);

            return new MountainAscent(this);
        }

    }

    @Override
    public void exitRoom() {
        System.out.println("Congratulations! You've successfully scaled the mountain and unlocked its ancient secrets.");
    }
}
