package Screens;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.mygdx.game.MainGame;
import Objects.Ball;
import Objects.Brick;
import Objects.Explosion;
import Objects.Heart;
import Objects.Table;
import Objects.Wall;
import managers.BallController;
import managers.PlayerManager;

public class MainGameScreen implements Screen {

	private MainGame game;
	private Stage stage;
	
	private Table table;
	private Ball ball;
	private Wall wall;
	private Explosion explosion;
	private Heart heart;
	
	private Texture tableTexture;
	private Texture brickTexture;
	private Texture ballTexture;
	private Texture explosionTexture;
	private Texture heartTexture;
	
	private PlayerManager control;
	private BallController controlPelota;
	
	private Sound explosionSound;
	private SpriteBatch sb;
	private BitmapFont font;
	
	public MainGameScreen(MainGame game) {
		this.game = game;
		tableTexture = new Texture("data/table.png");
		brickTexture = new Texture("data/brick.png");
		ballTexture = new Texture("data/ball.png");
		explosionTexture = new Texture("data/explode.png");
		heartTexture = new Texture("data/heart.png");
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("data/explosion.mp3")); 		// TODO Auto-generated constructor stub
		sb = new SpriteBatch();
		 font  =
				 new BitmapFont(
				Gdx.files.internal("data/default.fnt"));
	}
	@Override
	public void show() {
		stage = new Stage();	
		//stage.setDebugAll(true);
		
		table = new Table(tableTexture);
		ball = new Ball(ballTexture);
		wall = new Wall(brickTexture);
		explosion = new Explosion(explosionTexture);
		heart = new Heart(heartTexture);
		
		stage.addActor(table);
		stage.addActor(ball);
		stage.addActor(wall);
		stage.addActor(heart);
		//stage.addActor(explosion);
        
		ball.setPosition(300, 30);
		table.setPosition(270,0);
		
		control = new PlayerManager(table);
		Gdx.input.setInputProcessor(control);
		controlPelota = new BallController(ball,wall,table,stage,game, explosion, explosionSound);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	
		stage.act();
		controlPelota.render(delta);
		stage.draw();		
		
		// draw score
		sb.setColor(1,1,1,1);
		sb.begin();
		font.draw(sb, " " +ball.getScore(), 10,20);
		sb.end();
		
		// draw lives
	
		for (int i=0; i< ball.getLives(); i++) {
			heart.setPosition(20 + i * 30,40);
			sb.begin();
			heart.draw(sb, i);
			sb.end();
		}
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
		stage.dispose();		
	}

	@Override
	public void dispose() {
		tableTexture.dispose();
		brickTexture.dispose();
		ballTexture.dispose();
		explosionTexture.dispose();
		explosionSound.dispose();
	}

}
