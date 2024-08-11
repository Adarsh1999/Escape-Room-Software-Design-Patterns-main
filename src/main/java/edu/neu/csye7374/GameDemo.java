package edu.neu.csye7374;
import edu.neu.csye7374.APIs.GameFacadeAPI;
import edu.neu.csye7374.Models.GameFacadeImpl;

public class GameDemo {
    public static void main(String[] args) {
      
        GameFacadeAPI gameFacadeImpl = new GameFacadeImpl();
        gameFacadeImpl.getDetails();
        gameFacadeImpl.play();
    
    }
}
