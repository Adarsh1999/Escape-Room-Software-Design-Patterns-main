package edu.neu.csye7374.HintCommand;

import edu.neu.csye7374.APIs.HintReceiverAdapteeAPI;
import edu.neu.csye7374.Strategy.PuzzleContextStrategy;

public class HintObject implements HintReceiverAdapteeAPI{
    @Override
    public void buildHint(PuzzleContextStrategy strategy){
        strategy.showHint();
    }
    
}
