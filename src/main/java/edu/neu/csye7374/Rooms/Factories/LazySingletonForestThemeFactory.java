package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Theme;
import edu.neu.csye7374.Models.User;
import edu.neu.csye7374.Themes.ForestTheme;

public class LazySingletonForestThemeFactory extends ThemeFactory {
    
    private static LazySingletonForestThemeFactory instance;
    
    private LazySingletonForestThemeFactory() {
    }
    
    public static LazySingletonForestThemeFactory getInstance() {
        if(instance == null) {
            instance = new LazySingletonForestThemeFactory();
        }
        return instance;
    }
    
    @Override
    public Theme getTheme(User user) {
        return new ForestTheme(user);
    }
}
