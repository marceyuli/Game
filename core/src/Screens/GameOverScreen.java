package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.MainGame;

public class GameOverScreen implements Screen {
	private Texture gameoverTexture;
	private MainGame game;
	private Stage stage;
	private Skin skin;
	private Image gameover;
	private TextButton retry, menu;
	
	public GameOverScreen(final MainGame game) {
		this.game = game;
		stage = new Stage(new FitViewport(640,360));
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		gameoverTexture = new Texture("data/gameover.png");
		gameover = new Image(gameoverTexture);
		retry = new TextButton("Intente de nuevo", skin);
		menu = new TextButton("Menu", skin);
		
		
		retry.addCaptureListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.mainGameScreen);
			}
		});
		
		menu.addCaptureListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.menuScreen);
			}
		});
		
		gameover.setPosition(380 - gameover.getWidth(), 320 - gameover.getHeight());
		retry.setSize(150,100);
		menu.setSize(100, 100);
		retry.setPosition(200, 50);
		menu.setPosition(360, 50);
		stage.addActor(retry);
		stage.addActor(gameover);
		stage.addActor(menu);
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
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
	public void hide() {
		Gdx.input.setInputProcessor(null);
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		gameoverTexture.dispose();		
	}

}
