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
 * CaveOfEchoes room
 * A mysterious and challenging escape room set in a cave where echoes hold the key to your escape.
 */

/**
 * Creating a CaveOfEchoes room - CaveOfEchoes caveOfEchoes = (CaveOfEchoes) new
 * CaveOfEchoes.CaveOfEchoesBuilder().build();
 */
public class CaveOfEchoes extends Room {

    public CaveOfEchoes(RoomBuilder builder) {
        super(builder);
    }

    public static class CaveOfEchoesBuilder extends Room.RoomBuilder {

        @Override
        public Room build() {
            /**
             * Set the puzzles and exit puzzle here
             */
            PuzzleStrategy firstQuestion = new MCQPuzzleStrategy("As you enter the cave, you hear your voice echo. Which of these materials reflects sound best, creating a strong echo?",
                    List.of("Metal", "Wood", "Water", "Glass"), 1, "Metal surfaces reflect sound waves well, creating strong echoes.");
            PuzzleStrategy secondQuestion = new MCQPuzzleStrategy("Deep within the cave, you hear strange noises. Which natural phenomenon could cause echoes to sound distorted or eerie?",
                    List.of("Temperature changes", "Light refraction", "Air pressure variations", "Humidity levels"), 3, "Air pressure variations in caves can cause sound waves to bend, making echoes sound distorted.");
            PuzzleStrategy finalQuestion = new OneWordPuzzleStrategy("A final riddle echoes through the chamber: 'I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?'",
                    "Pencil", "The answer is 'Pencil,' a common object made from graphite taken from a mine.");
            PuzzleStrategy timedRiddlePuzzle = new TimedPuzzleDecorator(finalQuestion, 50);


            PuzzleContextStrategy firstPuzzle = new PuzzleContextStrategy(firstQuestion);
            PuzzleContextStrategy secondPuzzle = new PuzzleContextStrategy(secondQuestion);
            PuzzleContextStrategy finalPuzzle = new PuzzleContextStrategy(timedRiddlePuzzle);

            List<PuzzleContextStrategy> puzzleList = new ArrayList<>();
            puzzleList.add(firstPuzzle);
            puzzleList.add(secondPuzzle);
            puzzleList.add(finalPuzzle);

            this.setId(4)
                    .setName("CaveOfEchoes")
                    .setDescription("You've entered the Cave of Echoes, where every sound could be a clue or a trap. Only by understanding the echoes can you find your way out.")
                    .setPuzzles(puzzleList)
                    .setExitPuzzle(finalPuzzle);

            return new CaveOfEchoes(this);
        }

    }

    @Override
    public void exitRoom() {
        System.out.println("You have successfully navigated the Cave of Echoes, using the sounds around you to escape its eerie chambers.");
    }
}
