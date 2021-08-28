package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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

public class MenuScreen implements Screen {
	private Texture menuTexture;
	private MainGame game;
	private Stage stage;
	private Skin skin;
	private Image logo;
	private TextButton play;
	

	public MenuScreen(final MainGame game) {
		this.game = game;
		
		stage = new Stage(new FitViewport(640,360));
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		menuTexture = new Texture("data/arkanoid.png");
		logo = new Image(menuTexture);
		play = new TextButton("Jugar", skin);
		
		play.addCaptureListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(game.mainGameScreen);
			}
		});
		
		
		logo.setPosition(440 - logo.getWidth(), 320 - logo.getHeight());
		play.setSize(200,100);
		play.setPosition(220, 50);
		
		stage.addActor(play);
		stage.addActor(logo);
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
		skin.dispose();		
	}

}
