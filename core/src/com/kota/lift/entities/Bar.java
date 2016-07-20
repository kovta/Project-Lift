package com.kota.lift.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kota on 2016.07.18..
 */
public class Bar {
    private static final int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;
    private Texture image;

    private int[] weights;

    public Bar(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        this.image = new Texture("bar.png");
        weights = new int[10];
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getImage() {
        return image;
    }

    public int[] getWeights() {
        return weights;
    }

    public void update (float dt){
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        velocity.scl(1/dt);
    }

    public void lift (float amount){
        velocity.y += amount;
    }
}
