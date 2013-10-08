package dk.avlund.hexagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen implements Screen {

	private OrthographicCamera camera;
	private Texture texture;
	private HexaGame game;
	private boolean soundon = true;
	private TextureRegion sound;
	private TextureRegion nosound;
	private Rectangle soundrect;
	private Rectangle playrect;
	
	private TextureRegion playIcon;
	private TextureRegion ost;

	public MainMenuScreen(HexaGame game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.WORLD_WIDTH, game.WORLD_HEIGHT);

		texture = new Texture(Gdx.files.internal("textureatlas.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		playIcon = new TextureRegion(texture, 1186, 0, 128, 128);
//		sound = new TextureRegion(texture, 0, 0, 128, 128);
		sound = new TextureRegion(texture, 1576, 0, 128, 128);
//		nosound = new TextureRegion(texture, 128, 0, 128, 128);
		nosound = new TextureRegion(texture, 1706, 0, 128, 128);
		
		ost = new TextureRegion(texture, 0, 0, 128, 128);
		
		playrect = new ReverseRectangle(game.WORLD_WIDTH/2-96, game.WORLD_HEIGHT/2+96, 192, 192, game.WORLD_HEIGHT);
		soundrect = new ReverseRectangle(10, 74, 64, 64, game.WORLD_HEIGHT);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(211/255f, 84/255f, 0, 1);
//		Gdx.gl.glClearColor(39/255f, 174/255f, 96/255f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		
		game.font.draw(game.batch, "HEXAGAME", 35, 720);
		
		game.batch.draw(playIcon, game.WORLD_WIDTH/2-96, game.WORLD_HEIGHT/2-96, game.WORLD_WIDTH/2, game.WORLD_HEIGHT/2, 192, 192, 1, 1, 0);

		game.batch.draw(ost, 128, 128, 192, 192, 128, 128, 1, 1, 0);

		if(soundon)
			game.batch.draw(sound, 10, 10, 42, 42, 64, 64, 1, 1, 0);
		else
			game.batch.draw(nosound, 10, 10, 42, 42, 64, 64, 1, 1, 0);

		game.batch.end();

		// process user input
		if (Gdx.input.justTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			if(soundrect.contains(touchPos.x, touchPos.y)) {
				soundon = !soundon;
			} 
			
			if(playrect.contains(touchPos.x, touchPos.y)) {
				game.setScreen(new GameScreen(game));
				dispose();
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
