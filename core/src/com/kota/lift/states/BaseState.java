package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.Lift;

/**
 * Created by Kota on 2016.06.26..
 */
public class BaseState extends State {
    private boolean shift = false;            //érintésre való eltolás próbálgatása, ( szerencsétlenkedés :D )

    public BaseState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, (Lift.WIDTH - (2*Lift.PADDING)) / 3, Lift.HEIGHT);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            shift = true;
            //manager.set(new SquatState(manager));
            //dispose();
        }
    }

    @Override
    public void update(float timeDifference) {
        handleInput();
        camera.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0);
        if(shift){
            for(int i = 0; i < 288; i++){
                batch.draw(background, i, 0);
                camera.update();
            }
            manager.set(new SquatState(manager));
        }

        batch.end();
    }

    @Override
    public void dispose(){

    }
}
