package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.Lift;

/**
 * Created by Kota on 2016.06.26..
 */
public class BaseState extends State {
    //private boolean shift = false;            //érintésre való eltolás próbálgatása, ( szerencsétlenkedés :D )

    public BaseState(GameStateManager gsm, OrthographicCamera camera) {
        super(gsm, camera);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            shift = true;
            //dispose();
        }
    }


    @Override
    public void update(float timeDifference) {
        handleInput();
        if(shift){
            shiftScreen(manager.getState("SquatState"),1);
        }
        //camera.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }

    @Override
    public void dispose(){

    }
}