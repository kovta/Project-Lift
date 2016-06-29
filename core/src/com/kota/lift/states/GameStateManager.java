package com.kota.lift.states;

/**
 * Created by Kota on 2016.06.26..
 */
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Kota on 2016.06.12..
 */
public class GameStateManager {
    private Stack<State> states;
    private StateFactory stateFactory;
    private AssetManager assetManager;

    public GameStateManager(StateFactory factory, AssetManager manager){
        states = new Stack<State>();
        this.stateFactory=factory;
        this.assetManager=manager;
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float timeDifference){
        states.peek().update(timeDifference);
    }

    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }

    public State getState(String stateType){
        return stateFactory.getState(stateType, this);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
