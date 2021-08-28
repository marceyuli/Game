package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Brick extends Actor {
	protected Texture brick;
	public Rectangle brickRect;
	
	public Brick(Texture brick) {
		this.brick = brick;
		setSize(brick.getWidth(),brick.getHeight());
		this.brickRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(brick, getX(), getY());
	}

}
