package com.kota.lift.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kota on 2016.06.26..
 */
public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager manager;
    protected Texture background;

    public State (GameStateManager gsm){
        this.manager = gsm; mouse = new Vector3(); camera = new OrthographicCamera(); background = new Texture("gymbg_hd.png");
    }

    public abstract void handleInput();
    public abstract void update(float timeDifference);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
