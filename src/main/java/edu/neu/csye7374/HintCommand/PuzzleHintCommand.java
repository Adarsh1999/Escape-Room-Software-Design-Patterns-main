package edu.neu.csye7374.HintCommand;

import edu.neu.csye7374.APIs.HintCommandAPI;
import edu.neu.csye7374.APIs.HintReceiverAPI;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

public class PuzzleHintCommand implements HintCommandAPI {
    HintReceiverAPI receiverAPI;
    PuzzleContextStrategy strategy;

    public PuzzleHintCommand(HintReceiverAPI receiverAPI,PuzzleContextStrategy strategy){
        this.receiverAPI= receiverAPI;
        this.strategy = strategy;
    }

    @Override
    public void execute() {
       this.receiverAPI.generateHint(strategy);
        
    }
    


}
