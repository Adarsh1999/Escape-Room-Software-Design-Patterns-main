package edu.neu.csye7374.HintCommand;

import edu.neu.csye7374.APIs.HintReceiverAPI;
import edu.neu.csye7374.APIs.HintReceiverAdapteeAPI;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

public class PuzzleReceiver implements HintReceiverAPI {


    HintReceiverAdapteeAPI obj;
    public PuzzleReceiver() {
        this.obj = new HintObject();
    }

    @Override
    public void generateHint(PuzzleContextStrategy strategy) {
        System.out.println("Do you want a hint? (y/n)");
        String choice = System.console().readLine();

        if (choice.equals("y")) {
            System.out.print("Hint: ");
            this.obj.buildHint(strategy);
        }
    }
    
}
