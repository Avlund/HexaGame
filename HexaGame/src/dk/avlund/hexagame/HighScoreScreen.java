package dk.avlund.hexagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class HighScoreScreen implements Screen {
	final HexaGame game;

	private OrthographicCamera camera;

	public HighScoreScreen(final HexaGame game) {
		this.game = game;
		 
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(211/255f, 84/255f, 0, 1);
		Gdx.gl.glClearColor(39/255f, 174/255f, 96/255f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
 
		game.batch.begin();
		game.font.draw(game.batch, "HIGHSCORE", 30, 720);
		
		game.batch.end();
 
		if (Gdx.input.justTouched()) {
			game.setScreen(new MainMenuScreen(game));
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
