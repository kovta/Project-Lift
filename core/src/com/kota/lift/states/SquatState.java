package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.Lift;

/**
 * Created by Kota on 2016.06.26..
 */
public class SquatState extends State {
    public SquatState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            manager.set(new BenchPressState(manager));
            //dispose();
        }
    }

    @Override
    public void update(float timeDifference) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, -(Lift.PADDING + Lift.STATE_WIDTH), 0);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
