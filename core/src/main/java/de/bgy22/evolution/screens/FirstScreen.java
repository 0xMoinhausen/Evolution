package de.bgy22.evolution.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import de.bgy22.evolution.Main;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {

    Stage stage;

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        Skin skin = new Skin();
        BitmapFont font = new BitmapFont();
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

        table.setFillParent(true);
        skin.addRegions(buttonAtlas);

        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("buttonnormal");
        textButtonStyle.down = skin.getDrawable("buttonpressed");
        textButtonStyle.fontColor = Color.BLACK;

        TextButton textButton = new TextButton("Flappy Bird", textButtonStyle);
        textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Main.Instance.setScreen(new JumpKingScreen());
            }
        });
        table.add(textButton).center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
