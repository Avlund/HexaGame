package dk.avlund.hexagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HexaGame extends Game {
	protected SpriteBatch batch;
	protected BitmapFont font;
	
	protected final int WORLD_WIDTH = 480;
	protected final int WORLD_HEIGHT = 800;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/Roboto-Thin-128.fnt"), false);
		font.setScale(0.62f);
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
