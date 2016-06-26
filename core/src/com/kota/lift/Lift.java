package com.kota.lift;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kota.lift.states.BaseState;
import com.kota.lift.states.GameStateManager;

public class Lift extends ApplicationAdapter {
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 512;
	public static final int STATE_WIDTH = 288;
	public static final int PADDING = 80;
	public static final String TITLE = "Lift things up and put them down";

	private GameStateManager manager;
	private SpriteBatch batch;

	@Override
	public void create () {
		manager = new GameStateManager();
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		manager.push(new BaseState(manager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		manager.update(Gdx.graphics.getDeltaTime());
		manager.render(batch);
	}
}
