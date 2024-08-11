package edu.neu.csye7374.Rooms.Factories;

import edu.neu.csye7374.Models.Theme;
import edu.neu.csye7374.Models.User;

public abstract class ThemeFactory {
    public abstract Theme getTheme(User user);
}
