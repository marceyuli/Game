package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor{
	private Texture ball;
	int varX ;
	int varY ;
    public Rectangle ballRect;
    public boolean alive;
	private int score;
	private int extraLives;
	public int requiredScore;

	public Ball(Texture ball) {
		this.ball = ball;
		varX=200;
		varY=200 ;
		setSize(ball.getWidth(), ball.getHeight());
		alive = true;

		this.ballRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
		score = 0;
		extraLives = 3;
		requiredScore = 10;
	}
	
	public void draw(Batch batch, float parentAlpha) {
		if(!alive) {
			
		}
		batch.draw(ball, getX(), getY());	}

	@Override
	public void act(float delta) {
		if(!alive) {
			return;
		}
		setX(getX() + varX * delta);
		setY(getY() + varY *delta);
		ballRect.setX(getX());
		ballRect.setY(getY());
		if (  getX()  <0 || getX() + ball.getWidth() > Gdx.graphics.getWidth()) {
			varX = -varX;
        }
		if (getY() <0 ||getY() + ball.getHeight() > Gdx.graphics.getHeight()) {
			varY = -varY;
        }
	}

	public int getVarX() {
		return varX;
	}

	public void setVarX(int varX) {
		this.varX = varX;
	}

	public int getVarY() {
		return varY;
	}

	public void setVarY(int varY) {
		this.varY = varY;
	}
	
	public int getScore() {
		return score;
	}
	public int getLives() {
		return extraLives;
	}
	public void loseLife() {
		extraLives--;
		score=0;
	}
	public void incrementScore(int l) {
		score +=l;
	}
}
