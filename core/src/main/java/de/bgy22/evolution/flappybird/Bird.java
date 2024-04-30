package de.bgy22.evolution.flappybird;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import de.bgy22.evolution.screens.FlappyBirdScreen;

public abstract class Bird {

    private Sprite sprite;
    private final float jumpForce = 2.2f;
    private float speedY = 0f;
    private Circle hitBox;

    public Bird(Sprite sprite, Vector2 position) {
        this.sprite = sprite;
        this.hitBox = new Circle(position, sprite.getHeight());
    }

    public void update(float delta) {
        speedY += FlappyBirdScreen.GRAVITY * delta;
        hitBox.y += speedY;
        sprite.setPosition(hitBox.x, hitBox.y);
    }

    public void render(Batch batch) {
        sprite.draw(batch);
    }

    protected void jump(float delta) {
        speedY = jumpForce;
    }
}
