package de.bgy22.evolution.flappybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PlayerBird extends Bird {

    public PlayerBird(Sprite sprite, Vector2 position) {
        super(sprite, position);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            this.jump(delta);
        }
    }
}
