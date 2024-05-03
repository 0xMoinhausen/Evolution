package de.bgy22.evolution.jumpking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KnightPlayer extends  Knight{

    @Override
    public void update(float delta) {
        super.update(delta);
        handleInput(delta);
    }

    void handleInput(float delta){
        wishDir.setZero();
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            wishDir.x -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            wishDir.x += 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            chargeJump(delta);
        }
        else if(isChargingJump) {
            releaseJump();
        }

    }
}
