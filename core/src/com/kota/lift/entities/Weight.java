package com.kota.lift.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Kota on 2016.07.18..
 */
public class Weight {
    private Vector2 position;
    private Texture image;

    public Weight(int x, int y, int type) {
        this.position.x = x;
        this.position.y = y;
        this.image = new Texture(Integer.toString(type) + ".png");
    }
}
