package edu.neu.csye7374.HintCommand;

import edu.neu.csye7374.APIs.HintCommandAPI;
import edu.neu.csye7374.APIs.HintInvokerAPI;


public class PuzzleInvoker implements HintInvokerAPI {
 public HintCommandAPI hintCommand;
 
 public PuzzleInvoker(HintCommandAPI hintCommand){
    this.hintCommand = hintCommand;
 }

@Override
public void invoke() {
    this.hintCommand.execute();
}

 

}
