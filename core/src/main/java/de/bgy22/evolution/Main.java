package de.bgy22.evolution;

import com.badlogic.gdx.Game;
import de.bgy22.evolution.screens.FirstScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public static Main Instance;
    @Override
    public void create() {
        Instance = this;
        setScreen(new FirstScreen());
    }
}
