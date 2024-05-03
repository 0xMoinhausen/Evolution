package de.bgy22.evolution.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.bgy22.evolution.jumpking.KnightPlayer;

public class JumpKingScreen implements Screen {

    private SpriteBatch batch = new SpriteBatch();
    private KnightPlayer player = new KnightPlayer();
    private OrthographicCamera camera = new OrthographicCamera();
    @Override
    public void show() {
        camera.setToOrtho(false, 800, 400);
    }

    public void update(float delta){
        player.update(delta);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
