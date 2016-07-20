package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.CustomGestureDetector;
import com.kota.lift.Lift;
import com.kota.lift.entities.Bar;

/**
 * Created by Kota on 2016.06.26..
 */
public class SquatState extends State {
    private Bar bar;

    public SquatState(GameStateManager gsm, OrthographicCamera camera) {
        super(gsm, camera);
        bar = new Bar(388, 300);
        Gdx.input.setInputProcessor(new CustomGestureDetector(new CustomGestureDetector.DirectionListener() {
            @Override
            public void onUp() {

            }
            @Override
            public void onRight() {
                ShiftState shiftState = (ShiftState) manager.getState("ShiftState");
                shiftState.setShift("BaseState", -1);
                manager.set(shiftState);
            }
            @Override
            public void onLeft() {
                ShiftState shiftState = (ShiftState) manager.getState("ShiftState");
                shiftState.setShift("BenchPressState", 1);
                manager.set(shiftState);
            }
            @Override
            public void onDown() {

            }
        }));
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            bar.lift(300);
            /*ShiftState shiftState = (ShiftState) manager.getState("ShiftState");
            shiftState.setShift("BenchPressState", 1);
            manager.set(shiftState);*/
        }
    }

    @Override
    public void update(float timeDifference) {
        handleInput();
        //bar.update(timeDifference);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(bar.getImage(), bar.getPosition().x, bar.getPosition().y);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}