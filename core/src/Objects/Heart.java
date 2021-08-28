package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Heart extends Actor{
	protected Texture heart;
	
	public Heart(Texture heart) {
		this.heart = heart;
	}
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(heart, getX(), getY());
	}
}

