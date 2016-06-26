package com.kota.lift.states;

/**
 * Created by Kota on 2016.06.26..
 */
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Kota on 2016.06.12..
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
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
}
