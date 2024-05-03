package de.bgy22.evolution.jumpking;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Knight {

    //Visuals
    private Sprite knightSprite = new Sprite(new Texture("flappybird/sprites/bluebird-midflap.png"));
    private Rectangle hitBox = new Rectangle(200, 400, knightSprite.getWidth(), knightSprite.getHeight());


    //Input
    protected Vector2 wishDir = new Vector2(0,0); //Movement input

    //Physics/Player Variables
    private float maxSpeed = 10f;
    private float maxJumpVertical = 7.5f;
    private float maxJumpHorizontal = 10f;
    private float maxChargeTime = 2f;
    private float maxFallingVelocity = -15f;

    private float gravity = -7.5f;


    private Vector2 lastPos = new Vector2(0, 0);
    private Vector2 position = new Vector2(0,0);
    private Vector2 currentSpeed = new Vector2(0, 0);

    private float chargeTime = 0f;
    protected boolean isChargingJump = false;
    protected boolean isGrounded = false;
    private boolean colliding = false;

    public void render(Batch batch) {knightSprite.draw(batch);}

    public void update(float delta) {
        lastPos.x = hitBox.x;
        lastPos.y = hitBox.y;
        hitBox.setPosition(hitBox.x + currentSpeed.x, hitBox.y + currentSpeed.y);
        knightSprite.setPosition(hitBox.x, hitBox.y);

        if(isGrounded){
            currentSpeed.x = wishDir.scl(maxSpeed).x;
        }
        else{
            currentSpeed.y = Math.max(maxFallingVelocity, currentSpeed.y + gravity * delta);
            if(colliding){
                currentSpeed.x *= 1;
            }
        }
    }
    /**
     * Checks the collision and updates internal boolean
     * */
    public void collisionCheck(Rectangle shape){
        colliding = hitBox.contains(shape);
    }

    protected void chargeJump(float delta){
        isChargingJump = true;
        currentSpeed.setZero();
        chargeTime += delta;
        chargeTime = Math.min(chargeTime, maxChargeTime);
    }

    protected void releaseJump(){
        System.out.printf("Releasing jump with %.2f Power\ns", chargeTime / maxChargeTime);
        isChargingJump = false;
        currentSpeed = new Vector2(wishDir.x * maxJumpHorizontal, chargeTime / maxChargeTime * maxJumpVertical);
        chargeTime = 0;
    }

}
