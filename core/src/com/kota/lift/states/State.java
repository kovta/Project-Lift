package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kota.lift.Lift;

/**
 * Created by Kota on 2016.06.26..
 */
public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager manager;
    protected Texture background;

    protected boolean shift = false;
    //mennyi ido alatt alljon be a kamera a kovetkezo state kozepere
    protected final float shiftTime = 0.5f;
    protected int remainingPixels = Lift.STATE_WIDTH+Lift.PADDING;

    public State (GameStateManager gsm, OrthographicCamera camera){
        this.manager = gsm; mouse = new Vector3(); this.camera = camera; background = new Texture("gymbg_hd.png");
    }

    public abstract void handleInput();
    public abstract void update(float timeDifference);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();

    //param1: amelyik state-nek be kell jonnie
    //param2: milyen iranyba mozogjon a kamera
    protected void shiftScreen(State state, int dir){
        if(remainingPixels>0){
            float delta = Gdx.graphics.getDeltaTime();
            float pixelsToShift = (int)((Lift.STATE_WIDTH+Lift.PADDING)*delta/shiftTime);
            pixelsToShift = Math.min(pixelsToShift, remainingPixels);
            //Gdx.app.log("Pixels rremaining:", Float.toString(remainingPixels));
            remainingPixels-=pixelsToShift;
            //Gdx.app.log("Pixels to shift:", Float.toString(remainingPixels));

            camera.translate(dir*pixelsToShift,0,0);
            camera.update();
            //Gdx.app.log("Camera position:", camera.position.toString());
        }else{
            shift=false;
            remainingPixels = Lift.STATE_WIDTH+Lift.PADDING;
            manager.set(state);
        }
    }
}