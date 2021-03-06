package dk.avlund.hexagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
  final HexaGame game;

	private OrthographicCamera camera;

	public GameScreen(final HexaGame game) {
		this.game = game;
		 
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
	}


	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(41/255f, 128/255f, 185/255f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
 
		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
		game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
		
		game.batch.end();
 
		if (Gdx.input.justTouched()) {
			game.setScreen(new HighScoreScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}