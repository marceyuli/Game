package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Explosion extends Actor {
	public Texture explosion;
	public Rectangle explosionRect;
	float time ;
	public TextureRegion[] regionEnMovimiento;
	public TextureRegion frameActual;
	public Animation animacion;
	public Explosion(Texture explosion) {
		this.explosion =explosion;
		TextureRegion[][] tmp = TextureRegion.split(explosion, explosion.getWidth()/16, explosion.getHeight());
		regionEnMovimiento = new TextureRegion[16];
		for(int i=0; i<16; i++) {
			regionEnMovimiento[i] = tmp[0][i];
		}
		animacion = new Animation(1/20f, regionEnMovimiento);
		time = 0f;
		//setPosition(0,0);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		time+=Gdx.graphics.getDeltaTime();
		frameActual = (TextureRegion) animacion.getKeyFrame(time, false);
		batch.draw(frameActual, getX(), getY(), 32 , 32);
		super.draw(batch, parentAlpha);
		
	}
	
	public boolean isFinished() {
		return animacion.isAnimationFinished(time);
	}
	
}
