package com.kota.lift.states;

import com.badlogic.gdx.graphics.OrthographicCamera;

import java.util.HashMap;
import java.util.Map;

public class StateFactory {
    Map<String, State> stateMap = new HashMap<String, State>();
    OrthographicCamera camera;

    public StateFactory(OrthographicCamera cam){
        this.camera=cam;
    }

    private State makeState(String stateType, GameStateManager manager){
        State returnState=null;
        if(stateType.equalsIgnoreCase("BaseState")){
            returnState= new BaseState(manager, camera);
        }else if(stateType.equalsIgnoreCase("SquatState")){
            returnState= new SquatState(manager,camera);
        }else if(stateType.equalsIgnoreCase("BenchPressState")){
            returnState= new BenchPressState(manager, camera);
        }
        return returnState;
    }

    public State getState(String stateType, GameStateManager manager){
        State returnValue = stateMap.get(stateType);
        if(returnValue==null){
            returnValue=makeState(stateType, manager);
        }
        return returnValue;
    }
}
