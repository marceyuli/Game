package managers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.MainGame;

import Objects.Ball;
import Objects.Brick;
import Objects.Explosion;
import Objects.Table;
import Objects.Wall;

public class BallController {
	private Ball ball;
	private Wall wall;
	private Table table;
	private Stage stage;
	private Explosion explosion;
	private MainGame game;
	private Sound explosionSound;
	public int score;
	public int extraLives;
	public int requiredScore;

	public BallController(Ball ball, Wall wall, Table table, Stage stage, MainGame game, Explosion explosion, Sound explosionSound2) {
		super();
		this.ball = ball;
		this.wall = wall;
		this.table = table;
		this.stage = stage;
		this.game = game;
		this.explosion = explosion;
		explosionSound = explosionSound2; 
		score = ball.getScore();
		extraLives = ball.getLives();
		requiredScore = ball.requiredScore;
	}

	public void render(float delta) {
		colisionTabla();
		colision();
		isDead();

	}

	private void colision() {
		for (int i = 0; i < wall.getListaLadrillos().size; i++) {
			Brick brickActual = wall.getListaLadrillos().get(i);
			/*
			 * if(!(ball.getX() + ball.getWidth() <= brickActual.getX()) && !(ball.getX() <=
			 * brickActual.getX() + brickActual.getWidth()) && !(ball.getY() +
			 * ball.getHeight() <= brickActual.getY()) && !(ball.getY() >=
			 * brickActual.getY()+ brickActual.getHeight())) {
			 */
			if (brickActual.brickRect.overlaps(ball.ballRect)) {

				wall.getListaLadrillos().removeIndex(i);
				explosionSound.play();
				explosion = new Explosion(explosion.explosion);
				ball.incrementScore(2);
				stage.addActor(explosion);
				explosion.setPosition(brickActual.getX(), brickActual.getY());
				ball.setVarY(ball.getVarY() * -1);
				if(score >= requiredScore ) {
					extraLives++;
					//requiredScore += 5;
				}
				break;
			}
			
		}

	}

	private void colisionTabla() {

		if (table.tableRect.overlaps(ball.ballRect)) {
			//System.out.println("aa");
			// ball.setVarX(ball.getVarX() * -1);
			ball.setVarY(ball.getVarY() * -1);
		}
	}

	private void isDead() {
		if (ball.getY() < 0) {
			
			ball.loseLife();
			if(ball.getLives()==0) {
				ball.alive = false;
			stage.addAction(Actions.sequence(Actions.delay(0.25f), Actions.run(new Runnable() {
				@Override
				public void run() {
					game.setScreen(game.gameOverScreen);
				}
			}
			

			)));
			}
		}
	}
}
