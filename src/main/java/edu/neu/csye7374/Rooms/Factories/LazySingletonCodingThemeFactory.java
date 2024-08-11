package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Theme;
import edu.neu.csye7374.Models.User;
import edu.neu.csye7374.Themes.CodingTheme;

public class LazySingletonCodingThemeFactory extends ThemeFactory{
   private static LazySingletonCodingThemeFactory instance;

   private LazySingletonCodingThemeFactory() {
   }

   private static LazySingletonCodingThemeFactory getInstance() {
       if (instance == null) {
           instance = new LazySingletonCodingThemeFactory();
       }
       return instance;
   }

    @Override
    public Theme getTheme(User user) {
        return new CodingTheme(user);
    }

}
