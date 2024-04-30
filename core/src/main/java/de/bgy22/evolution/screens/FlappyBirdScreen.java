package de.bgy22.evolution.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import de.bgy22.evolution.flappybird.PlayerBird;

public class FlappyBirdScreen implements Screen {

    public static final float GRAVITY = -4.0f;

    private Texture aiBirdImage;
    private Texture playerBirdImage;
    private PlayerBird player;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    @Override
    public void show() {
        aiBirdImage = new Texture(Gdx.files.internal("flappybird/sprites/bluebird-midflap.png"));
        playerBirdImage = new Texture(Gdx.files.internal("flappybird/sprites/redbird-midflap.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        batch = new SpriteBatch();

        player = new PlayerBird(new Sprite(playerBirdImage), new Vector2(0, 0));
    }

    public void update(float delta) {
        camera.update();
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
        aiBirdImage.dispose();
        playerBirdImage.dispose();
        batch.dispose();
    }
}
