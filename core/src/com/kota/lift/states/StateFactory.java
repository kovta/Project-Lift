package com.kota.lift.states;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class StateFactory {

    public StateFactory(){

    }

    public State makeState(String stateType, GameStateManager manager, OrthographicCamera camera){
        State returnState=null;
        if(stateType.equalsIgnoreCase("BaseState")){
            returnState= new BaseState(manager, camera);
        }else if(stateType.equalsIgnoreCase("SquatState")){
            returnState= new SquatState(manager,camera);
        }else if(stateType.equalsIgnoreCase("BenchPressState")){
            returnState= new BenchPressState(manager, camera);
        }else if(stateType.equalsIgnoreCase("ShiftState")) {
            returnState = new ShiftState(manager, camera);
        }
        return returnState;
    }
}
