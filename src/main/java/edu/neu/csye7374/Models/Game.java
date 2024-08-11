package edu.neu.csye7374.Models;

import java.util.Random;

import edu.neu.csye7374.APIs.GameAPI;
import edu.neu.csye7374.Themes.CodingTheme;
import edu.neu.csye7374.Themes.ForestTheme;

public class Game implements GameAPI {
    private User user;
    private Theme theme;

    public Game() {
      
    }

    @Override
    public void createUser() {
        System.out.println("Please enter your name");
        String name = System.console().readLine();
        System.out.println("Please enter your email");
        String email = System.console().readLine();
        //generate a random id
        Random rand = new Random();
        int id = rand.nextInt(1000);
        UserProfile userProfile = new UserProfile.UserProfileBuilder()
                .setId(id)
                .setUserName(name)
                .setEmail(email)
                .build();

        this.user = new User(userProfile);
    }

    @Override
    public void getThemeFromUser() {
        System.out.println("Please select a theme");
        System.out.println("1. Coding");
        System.out.println("2. Forest");
        int themeId = Integer.parseInt(System.console().readLine());
        Theme theme = null;
        switch (themeId) {
            case 1:
               //use factories to create the theme
                theme = new CodingTheme(user); //Decorator pattern
                break;
            case 2:
                theme = new ForestTheme(user);
                break;
            default:
                System.out.println("Invalid theme selected");
                break;
        }
        this.theme = theme;
    }

    @Override
    public void start() {
        user.displayState();
        System.out.println("Welcome to Escape Room Game");
        theme.play();
    }
    
}
