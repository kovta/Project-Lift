package com.kota.lift.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.Lift;

/**
 * Created by entk on 2016.06.29..
 */
public class ShiftState extends State {
    //mennyi ido alatt alljon be a kamera a kovetkezo state kozepere
    protected final float shiftTime = 0.5f;
    protected int remainingPixels = Lift.STATE_WIDTH+Lift.PADDING;
    private State nextState;
    private int direction;

    public ShiftState(GameStateManager manager, OrthographicCamera camera){
        super(manager, camera);
    }

    public void setShift(String nextState, int direction){
        this.nextState=manager.getState(nextState);
        this.direction=direction;
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float timeDifference) {
        if(remainingPixels>0){
            float pixelsToShift = (int)((Lift.STATE_WIDTH+Lift.PADDING)*timeDifference/shiftTime);
            pixelsToShift = Math.min(pixelsToShift, remainingPixels);
            //Gdx.app.log("Pixels remaining:", Float.toString(remainingPixels));
            remainingPixels-=pixelsToShift;
            //Gdx.app.log("Pixels to shift:", Float.toString(remainingPixels));
            camera.translate(direction*pixelsToShift,0,0);
            camera.update();
            //Gdx.app.log("Camera position:", camera.position.toString());
        }else{
            remainingPixels = Lift.STATE_WIDTH+Lift.PADDING;
            manager.set(nextState);
        }
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
    public void dispose() {

    }
}
