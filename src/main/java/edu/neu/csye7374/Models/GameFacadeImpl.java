package edu.neu.csye7374.Models;

import edu.neu.csye7374.APIs.GameFacadeAPI;

public class GameFacadeImpl implements GameFacadeAPI{
    Game game;

    public GameFacadeImpl() {
        this.game = new Game();
    }

    @Override
    public void getDetails() {
        game.createUser();
        game.getThemeFromUser();
    }

    @Override
    public void play() {
       game.start();
    }
}
